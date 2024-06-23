package cinema.service;

import cinema.model.CinemaRoom;
import cinema.model.CinemaRoomSeat;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CinemaRoomFactory {
    private final Integer rowsNumber = 9;
    private final Integer seatsNumber = 9;
    private final CinemaRoom cinemaRoom = createCinemaRoom();

    private CinemaRoom createCinemaRoom() {
        return new CinemaRoom(rowsNumber, seatsNumber, createCinemaRoomSeats());
    }

    private ConcurrentLinkedQueue<CinemaRoomSeat> createCinemaRoomSeats() {
        return IntStream.rangeClosed(1, rowsNumber)
                .boxed()
                .flatMap(row ->
                        IntStream
                                .rangeClosed(1, seatsNumber)
                                .mapToObj(column -> new CinemaRoomSeat(row, column)))
                .collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
    }

    public CinemaRoomSeat getCinemaRoomSeat(CinemaRoomSeat seatToBook) {
        return cinemaRoom.getSeats()
                .stream()
                .filter(seat ->
                        seat.getRow().equals(seatToBook.getRow()) && seat.getSeat().equals(seatToBook.getSeat())
                )
                .findFirst()
                .orElse(null);
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }
}