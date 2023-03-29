package com.bank.bankinterface;

import java.util.List;

import com.bank.pojo.Address;
import com.bank.pojo.Bank;

public interface BankInter {
	
	public List<Bank> getBankList();

	public boolean isBankExist(Bank bank);

	public Bank saveBank(Bank bank);

	public List<Bank> saveBankList(List<Address> list);

	public Bank updateBank(Bank bank, int id);

	public void deleteBank(int id);

	public boolean disableBank(int disable, int id);

}
