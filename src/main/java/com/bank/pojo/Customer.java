package com.bank.pojo;

public class Customer {
	private int customerId;
	private int bankId;
	private int addressId;
	private String customerFirstName;
	private String customerLastName;
	private int accountNumber;
	private double customerCurrentBal;
	private int mobileNumber;
	private Address address;
	public String getCustomerCurrentBal;
	private boolean isCustomerExist;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int  customerId) {
		this.customerId = customerId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getCustomerCurrentBal() {
		return customerCurrentBal;
	}
	public void setCustomerCurrentBal(double customerCurrentBal) {
		this.customerCurrentBal = customerCurrentBal;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean getIsExist() {
		return isCustomerExist;
	}
	public void setIsCustomerExist(boolean isCustomerExist) {
		this.isCustomerExist = isCustomerExist;
	}
	
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isCustomerExist() {
		return isCustomerExist;
	}
	public void setCustomerExist(boolean isCustomerExist) {
		this.isCustomerExist = isCustomerExist;
	}
	@Override
	public String toString() {
		return "Custumer [custumerId=" + customerId + ", bankId=" + bankId + ", addressId=" + addressId
				+ ", custumerFirstName=" + customerFirstName + ", custumerLastName=" + customerLastName
				+ ", accountNumber=" + accountNumber + ", custumerCurrentBal=" + customerCurrentBal + ", address="
				+ address + " ,isCustumerExist=" + isCustomerExist + "]";
	}
	
	//this is first comment in Customer class

}
