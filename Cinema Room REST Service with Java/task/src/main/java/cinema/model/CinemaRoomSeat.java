package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CinemaRoomSeat {
    private Integer row;
    @JsonProperty("column")
    private Integer seat;
    private Integer price;
    @JsonIgnore
    private Boolean booked;

    public CinemaRoomSeat() {}

    public CinemaRoomSeat(Integer row, Integer seat) {
        this.row = row;
        this.seat = seat;
        this.price = row <= 4 ? 10 : 8;
        this.booked = false;
    }

    public Integer getRow() {
        return this.row;
    }

    public Integer getSeat() {
        return this.seat;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Boolean isBooked() {
        return this.booked;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CinemaRoomSeat seat1)) return false;
        return Objects.equals(getRow(), seat1.getRow()) && Objects.equals(getSeat(), seat1.getSeat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getSeat());
    }
}
