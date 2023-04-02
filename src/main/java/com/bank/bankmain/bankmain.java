package com.bank.bankmain;

import com.bank.bankimplementation.Addressimpl;
import com.bank.bankimplementation.Bankimpl;
import com.bank.bankimplementation.Customerimpl;
import com.bank.pojo.Address;
import com.bank.pojo.Bank;
import com.bank.pojo.Customer;

public class bankmain {
	public static void main(String args[]) {
		Address address1=new Address();
		address1.setAddressId(1);
		address1.setFlatNumber(101);
		address1.setLandMark("Shitalwadi");
		address1.setCity("Ramtek");
		address1.setDistric("Nagpur");
		address1.setState("Maharashtra");
		address1.setCountry("India");
		address1.setPinNumber(441106);
		
		Address address2=new Address();
		address2.setAddressId(2);
		address2.setFlatNumber(45);
		address2.setLandMark("near ganesh mandir");
		address2.setCity("Katol");
		address2.setDistric("Nagpur");
		address2.setState("Maharashtra");
		address2.setCountry("India");
		address2.setPinNumber(441302);
		
		Bank bank1=new Bank();
		bank1.setBankId(1);
		bank1.setBankName("UCO");
		bank1.setIfscNumber("XXXUCO");
		bank1.setTotalNumberOfCustomer(912);
		bank1.setAddressId(281081);
		bank1.setAddressId(1);
		
		Bank bank2=new Bank();
		bank2.setAddressId(2);
		bank2.setBankName("CANARA");
		bank2.setIfscNumber("XXCANARA");
		bank2.setTotalNumberOfCustomer(502);
		bank2.setBankBalance(302);
		bank2.setAddressId(2);
		
		
		Addressimpl addimpl=new Addressimpl();
		//addimpl.getAddressList();
		//addimpl.isAddressExist(address2);
		//addimpl.saveAddress(address2);
		
		Bankimpl bankimpl=new Bankimpl();
		//bankimpl.getBankList();
		//bankimpl.isBankExist(bank1);
		//bankimpl.saveBank(bank1);
		
		Customer customer = new Customer();
		customer.setCustomerId(4);
//		customer.setBankId(9);
//		customer.setAddressId(23);
//		customer.setCustomerFirstName("Saksh");
//		customer.setCustomerLastName("Meshr");
//		customer.setAccountNumber(501245331);
		customer.setCustomerCurrentBal(47555);
//		customer.setMobileNumber(608976547);
//		customer.setActive(true);
//		customer.setIsEnable(1);
//		customer.setAddress(address);
		Customerimpl Impl = new Customerimpl();
	     Impl.getCustomerCurrentBal(customer);
	}

}
