package com.cg.mts.dto;

import java.util.List;

public class TheatreDTO {
    private int theatreId;
    private String theatreName;
    private String theatreCity;
    private String managerName;
    private String managerContact;
    private List<ScreenDTO> screens;
    private List<ShowDTO> shows;
    public TheatreDTO() {

    }
    public TheatreDTO(int theatreId, String theatreName, String theatreCity, String managerName,
                          String managerContact, List<ScreenDTO> screens, List<ShowDTO> shows) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreCity = theatreCity;
        this.managerName = managerName;
        this.managerContact = managerContact;
        this.screens = screens;
        this.shows = shows;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreCity() {
        return theatreCity;
    }

    public void setTheatreCity(String theatreCity) {
        this.theatreCity = theatreCity;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerContact() {
        return managerContact;
    }

    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact;
    }

    public List<ScreenDTO> getScreens() {
        return screens;
    }

    public void setScreenIds(List<ScreenDTO> screens) {
        this.screens = screens;
    }
	public List<ShowDTO> getShows() {
		return shows;
	}
	public void setShowIds(List<ShowDTO> shows) {
		this.shows = shows;
	}

   
}
