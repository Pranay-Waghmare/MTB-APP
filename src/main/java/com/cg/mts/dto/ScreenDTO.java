package com.cg.mts.dto;

import java.util.List;

public class ScreenDTO {
	
    private int screenId;
    private TheatreDTO theatre;
    private List<ShowDTO> shows;
    private String screenName;
    private int rows;
    private int columns;
    public ScreenDTO() {

    }
    public ScreenDTO(int screenId, TheatreDTO theatre, List<ShowDTO> shows, String screenName, int rows, int columns) {
        this.screenId = screenId;
        this.theatre = theatre;
        this.shows = shows;
        this.screenName = screenName;
        this.rows = rows;
        this.columns = columns;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public TheatreDTO getTheatre() {
        return theatre;
    }

    public void setTheatre(TheatreDTO theatre) {
        this.theatre = theatre;
    }

    public List<ShowDTO> getShows() {
        return shows;
    }

    public void setShowIds(List<ShowDTO> showIds) {
        this.shows = showIds;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

   
}
