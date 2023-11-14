package com.cg.mts.dto;

import java.time.LocalDate;

public class BookingDTO {
    private int transactionId;
    private ShowDTO show;
    private LocalDate bookingDate;
    private String transactionMode;
    private String transactionStatus;
    private double totalCost;
    private CustomerDTO customer;
    private TicketDTO ticket;

    public BookingDTO() {};
    public BookingDTO(int transactionId, ShowDTO show, LocalDate bookingDate, String transactionMode,
                           String transactionStatus, double totalCost, CustomerDTO customer, TicketDTO ticket) {
        this.transactionId = transactionId;
        this.show = show;
        this.bookingDate = bookingDate;
        this.transactionMode = transactionMode;
        this.transactionStatus = transactionStatus;
        this.totalCost = totalCost;
        this.customer = customer;
        this.ticket = ticket;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    

    public ShowDTO getShow() {
		return show;
	}
	public void setShow(ShowDTO show) {
		this.show = show;
	}
	public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }
	public TicketDTO getTicket() {
		return ticket;
	}
	public void setTicket(TicketDTO ticket) {
		this.ticket = ticket;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}  
}