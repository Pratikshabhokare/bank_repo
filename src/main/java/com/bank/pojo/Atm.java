package com.bank.pojo;

public class Atm {
	
	private int id;
	private String bankName;
	private double balanace;
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
	@Override
	public String toString() {
		return "Atm [id=" + id + ", bankName=" + bankName + ", balanace=" + balanace + "]";
	}
	
	

}
