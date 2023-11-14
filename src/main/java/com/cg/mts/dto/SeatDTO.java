package com.cg.mts.dto;

import com.cg.mts.pojo.SeatStatus;

public class SeatDTO {
	
    private int seatId;
    private String seatNumber;
    private String type;
    private double price;
    private SeatStatus status;
    private TicketDTO ticket;
    
    public SeatDTO() {

    }
    
    public SeatDTO(int seatId, String seatNumber, String type, double price, SeatStatus status, TicketDTO ticket) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.type = type;
        this.price = price;
        this.status = status;
        this.ticket = ticket;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
	public TicketDTO getTicket() {
		return ticket;
	}
	public void setTicket(TicketDTO ticket) {
		this.ticket = ticket;
	}
}
