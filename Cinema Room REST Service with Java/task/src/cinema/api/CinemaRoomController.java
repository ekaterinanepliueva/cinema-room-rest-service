package cinema.api;

import cinema.model.CinemaRoom;
import cinema.model.CinemaRoomSeat;
import cinema.model.CinemaStatistic;
import cinema.model.CinemaTicket;
import cinema.service.CinemaService;
import cinema.service.CinemaServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaRoomController {

    private final CinemaService cinemaService;

    public CinemaRoomController(@Autowired CinemaServiceImpl cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public CinemaRoom getCinemaRoom() {
        return cinemaService.getCinemaRoom();
    }

    @PostMapping("/purchase")
    public ResponseEntity<CinemaTicket> purchaseTicket(@RequestBody CinemaRoomSeat seatToBook) {
        return cinemaService.purchase(seatToBook);
    }

    @PostMapping("/return")
    public ResponseEntity<CinemaTicket> returnTicket(@RequestBody CinemaTicket ticket) {
        return cinemaService.returnTicket(ticket);
    }

    @GetMapping("/stats")
    public ResponseEntity<CinemaStatistic> getStatistic(@PathParam("password") String password) {
        return cinemaService.getStatistic(password);
    }
}
