package com.bank.pojo;

public class Atm {

	private int id;
	private String bankName;
	private double balanace;
	private int pinNumber;
	private String customerName;
	private double deposite;
	private double credit;
	private int numberOfNotes;
	private long contactNumber;
	private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalanace() {
		return balanace;
	}
	public void setBalanace(double balanace) {
		this.balanace = balanace;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getDeposite() {
		return deposite;
	}
	public void setDeposite(double deposite) {
		this.deposite = deposite;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public int getNumberOfNotes() {
		return numberOfNotes;
	}
	public void setNumberOfNotes(int numberOfNotes) {
		this.numberOfNotes = numberOfNotes;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Atm [id=" + id + ", bankName=" + bankName + ", balanace=" + balanace + ", pinNumber=" + pinNumber
				+ ", customerName=" + customerName + ", deposite=" + deposite + ", credit=" + credit
				+ ", numberOfNotes=" + numberOfNotes + ", contactNumber=" + contactNumber + ", address=" + address
				+ "]";
	}
	
	

}
