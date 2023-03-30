package com.bank.pojo;

public class User {
//this i a user class
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private long mobileNumber;
	private String password;
	private String addharNumber;
	private String panNumber;
	private String drivinglicence;
	private String passport;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddharNumber() {
		return addharNumber;
	}

	public void setAddharNumber(String addharNumber) {
		this.addharNumber = addharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getDrivinglicence() {
		return drivinglicence;
	}

	public void setDrivinglicence(String drivinglicence) {
		this.drivinglicence = drivinglicence;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", addharNumber=" + addharNumber
				+ ", panNumber=" + panNumber + ", drivinglicence=" + drivinglicence + ", passport=" + passport + "]";
	}
	
	//this is first comment in user class
	
	

}
