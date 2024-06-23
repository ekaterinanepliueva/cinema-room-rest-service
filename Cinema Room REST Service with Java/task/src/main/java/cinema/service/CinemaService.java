package cinema.service;

import cinema.model.CinemaRoom;
import cinema.model.CinemaRoomSeat;
import cinema.model.CinemaStatistic;
import cinema.model.CinemaTicket;
import org.springframework.http.ResponseEntity;

public interface CinemaService {

    CinemaRoom getCinemaRoom();

    ResponseEntity<CinemaTicket> purchase(CinemaRoomSeat seat);
    ResponseEntity<CinemaTicket> returnTicket(CinemaTicket ticket);
    ResponseEntity<CinemaStatistic> getStatistic(String password);
}
