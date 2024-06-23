package cinema.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CinemaTicket {

    String token;
    @JsonProperty("ticket")
    CinemaRoomSeat seat;

    public CinemaTicket() {

    }
    public CinemaTicket(CinemaRoomSeat seat) {
        this.token = UUID.randomUUID().toString();
        this.seat = seat;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CinemaRoomSeat getSeat() {
        return this.seat;
    }

    public void setSeat(CinemaRoomSeat seat) {
        this.seat = seat;
    }
}
