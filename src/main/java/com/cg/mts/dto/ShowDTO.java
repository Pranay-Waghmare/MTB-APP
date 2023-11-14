package com.cg.mts.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShowDTO {
    private int showId;
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
    private String showName;
    private MovieDTO movie;
    private ScreenDTO screen;
    private TheatreDTO theatre;
    private BookingDTO booking;
    private LocalDate showDate;
    public ShowDTO() {

    }
    public ShowDTO(int showId, LocalDateTime showStartTime, LocalDateTime showEndTime, String showName, MovieDTO movie,
                        ScreenDTO screen, TheatreDTO theatre, BookingDTO booking, LocalDate showDate) {
        this.showId = showId;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.showName = showName;
        this.movie = movie;
        this.screen = screen;
        this.theatre = theatre;
        this.booking = booking;
        this.showDate = showDate;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public LocalDateTime getShowEndTime() {
        return showEndTime;
    }

    public void setShowEndTime(LocalDateTime showEndTime) {
        this.showEndTime = showEndTime;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovieId(MovieDTO movie) {
        this.movie = movie;
    }

    public ScreenDTO getScreen() {
        return screen;
    }

    public void setScreenId(ScreenDTO screen) {
        this.screen = screen;
    }

    public TheatreDTO getTheatre() {
        return theatre;
    }

    public void setTheatreId(TheatreDTO theatre) {
        this.theatre = theatre;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBookingId(BookingDTO booking) {
        this.booking = booking;
    }
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

   
}
