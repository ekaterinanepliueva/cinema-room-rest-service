package cinema.service;

import cinema.model.CinemaRoomSeat;
import cinema.model.CinemaStatistic;
import cinema.model.CinemaTicket;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class CinemaTicketFactory {

    private final ConcurrentLinkedQueue<CinemaTicket> tickets = new ConcurrentLinkedQueue<>();

    public CinemaTicket purchaseTicket(CinemaRoomSeat seat) {
        CinemaTicket ticket = new CinemaTicket(seat);
        tickets.add(ticket);
        return ticket;
    }

    public CinemaTicket returnTicket(String token) {
        CinemaTicket ticket = getTicketByToken(token);
        if (ticket != null) {
            tickets.remove(ticket);
            ticket.setToken(null);
            ticket.getSeat().setBooked(false);
        }
        return ticket;
    }

    private CinemaTicket getTicketByToken(String token) {
        return tickets.stream()
                .filter(t -> t.getToken().equals(token))
                .findFirst()
                .orElse(null);
    }

    public CinemaStatistic getStatistic(CinemaRoomFactory cinemaRoomFactory) {
        CinemaStatistic statistic = new CinemaStatistic();
        int income = 0;
        int purchased = 0;
        int available = cinemaRoomFactory.getCinemaRoom().getSeats().size();

        for (CinemaTicket ticket : tickets) {
            if (ticket.getSeat().isBooked()) {
                income += ticket.getSeat().getPrice();
                available--;
                purchased++;
            }
        }
        statistic.setIncome(income);
        statistic.setPurchased(purchased);
        statistic.setAvailable(available);
        return statistic;
    }
}
