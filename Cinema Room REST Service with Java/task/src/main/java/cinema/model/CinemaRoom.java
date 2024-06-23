package cinema.model;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CinemaRoom {

    private Integer rows;
    private Integer columns;
    private ConcurrentLinkedQueue<CinemaRoomSeat> seats;

    public CinemaRoom(Integer rows, Integer columns, ConcurrentLinkedQueue<CinemaRoomSeat> seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public ConcurrentLinkedQueue<CinemaRoomSeat> getSeats() {
        return this.seats;
    }

    public void setSeats(ConcurrentLinkedQueue<CinemaRoomSeat> seats) {
        this.seats = seats;
    }
}
