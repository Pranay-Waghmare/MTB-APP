package com.cg.mts.dto;

public class CustomerDTO {
	
    private int customerId;
    private String customerName;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    
    public CustomerDTO() {};
    
    public CustomerDTO(int customerId, String customerName, String address, String mobileNumber, String email, String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password=password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

  
}
