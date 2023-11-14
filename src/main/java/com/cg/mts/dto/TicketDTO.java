package com.cg.mts.dto;

import java.util.List;

public class TicketDTO {
	
    private int ticketId;
    private int noOfSeats;
    private boolean ticketStatus;
    private List<SeatDTO> seats;
    private BookingDTO booking;
    
    public TicketDTO() {

    }
    
    public TicketDTO(int ticketId, int noOfSeats, boolean ticketStatus, List<SeatDTO> seats, BookingDTO booking) {
        this.ticketId = ticketId;
        this.noOfSeats = noOfSeats;
        this.ticketStatus = ticketStatus;
        this.seats = seats;
        this.booking = booking;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public boolean isTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
	public List<SeatDTO> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatDTO> seats) {
		this.seats = seats;
	}
	public BookingDTO getBooking() {
		return booking;
	}
	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}

}
