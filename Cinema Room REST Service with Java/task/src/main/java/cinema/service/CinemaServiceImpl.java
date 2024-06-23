package cinema.service;

import cinema.exception.CinemaRoomException;
import cinema.exception.CinemaStatisticException;
import cinema.model.CinemaRoom;
import cinema.model.CinemaRoomSeat;
import cinema.model.CinemaStatistic;
import cinema.model.CinemaTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static cinema.exception.ExceptionMessages.*;


@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRoomFactory roomFactory;
    private final CinemaTicketFactory ticketFactory;

    @Autowired
    public CinemaServiceImpl(CinemaRoomFactory roomFactory,
                             CinemaTicketFactory ticketFactory) {
        this.roomFactory = roomFactory;
        this.ticketFactory = ticketFactory;
    }

    @Override
    public CinemaRoom getCinemaRoom() {
        return roomFactory.getCinemaRoom();
    }

    @Override
    public ResponseEntity<CinemaTicket> purchase(CinemaRoomSeat cinemaRoomSeat) {
        CinemaRoomSeat seat = roomFactory.getCinemaRoomSeat(cinemaRoomSeat);
        if (seat == null) {
            throw new CinemaRoomException(ROW_OR_COLUMN_OUT_OF_BOUNDS_MESSAGE);
        }

        if (seat.isBooked()) {
            throw new CinemaRoomException(TICKET_IS_PURCHASED_MESSAGE);
        }

        seat.setBooked(true);
        CinemaTicket ticket = ticketFactory.purchaseTicket(seat);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(ticket);
    }

    @Override
    public ResponseEntity<CinemaTicket> returnTicket(CinemaTicket token) {
        CinemaTicket returnedTicket = ticketFactory.returnTicket(token.getToken());
        if (returnedTicket == null) {
            throw new CinemaRoomException(WRONG_TOKEN_MESSAGE);
        }
        roomFactory.getCinemaRoomSeat(returnedTicket.getSeat()).setBooked(false);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(returnedTicket);
    }

    @Override
    public ResponseEntity<CinemaStatistic> getStatistic(String password) {
        if (password == null || !(password.equals("super_secret"))) {
            throw new CinemaStatisticException(WRONG_PASSWORD_MESSAGE);
        }

        CinemaStatistic statistic = ticketFactory.getStatistic(roomFactory);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(statistic);
    }
}
