package com.cg.mts.dto;

public class UserDTO {
	
    private int userId;
    private String username;
    private String role;
    private CustomerDTO customer;
    public UserDTO() {

    }
    public UserDTO(int userId, String username, String role, CustomerDTO customer) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.customer = customer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
}
