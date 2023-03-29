package com.bank.bankinterface;

import java.util.List;

import com.bank.pojo.Address;

public interface AddresssInter {
	public List<Address> getAddressList();

	public boolean isAddressExist(Address address);

	public int saveAddress(Address addressList);

	public List<Address> saveAddressList(List<Address> list);

	public Address updateAddress(Address address, int id);

	public void deleteAddress(int id);

	public boolean disableAddress(int disable, int id);

	 
}
