package com.bank.pojo;

import java.util.List;

public class Bank {
	private int bankId;
	private String bankName;
	private String ifscNumber;
	private int totalNumberOfCustomer;
	private double bankBalance;
	private Customer customer;
	private int addressId;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	// private Customer[] custArray;
	private List<Customer> customerlist;

	public List<Customer> getCustomerlist() {
		return customerlist;
	}

	public void setCustomerlist(List<Customer> customerlist) {
		this.customerlist = customerlist;
	}

//	
//	public Customer[] getCustArray() {
//		return custArray;
//	}
//	public void setCustArray(Customer[] custArray) {
//		this.custArray = custArray;
//	}
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscNumber() {
		return ifscNumber;
	}

	public void setIfscNumber(String ifscNumber) {
		this.ifscNumber = ifscNumber;
	}

	public int getTotalNumberOfCustomer() {
		return totalNumberOfCustomer;
	}

	public void setTotalNumberOfCustomer(int totalNumberOfCustomer) {
		this.totalNumberOfCustomer = totalNumberOfCustomer;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public Customer getCostumer() {
		return customer;
	}

	public void setCustumer(Customer custumer) {
		this.customer = custumer;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", ifscNumber=" + ifscNumber
				+ ", totalNumberOfCustomer=" + totalNumberOfCustomer + ", bankBalance=" + bankBalance + ", customer="
				+ customer + ", addressId=" + addressId + ", address=" + address + ", customerlist=" + customerlist
				+ "]";
	}
	//this is first comment in Bank class
	//this is second comment in Bank class

}
