package com.bank.bankimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.bankinterface.AddresssInter;
import com.bank.pojo.Address;

import connection.DBConnection;

public class Addressimpl implements AddresssInter {
	public static final String getAddressList = "select * from address";
	public static final String getSaveAddress = "insert into address(flat_number,landmark,city,district,state,country,pin_code) values(?,?,?,?,?,?,?)";
	public static final String getUpdateAddress = "update address set city=? where id=?";
	public static final String getDeleteAddress = "delete from address  where id=?";
	public static final String getDisableAddress = "update address set is_enable=? where id=?";

	@Override
	public List<Address> getAddressList() {

		Connection conn = null;

		Address address = null;

		Statement st = null;

		ResultSet rs = null;

		List<Address> addressList = null;

		try {

			conn = DBConnection.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery(getAddressList);

			addressList = new ArrayList<Address>();

			while (rs.next()) {
				address = new Address();

				address.setAddressId(rs.getInt("id"));

				address.setFlatNumber(rs.getInt("flat_number"));

				address.setLandMark(rs.getString("landmark"));

				address.setCity(rs.getString("city"));

				address.setDistric(rs.getString("district"));

				address.setState(rs.getString("State"));

				address.setCountry(rs.getString("country"));

				address.setPinNumber(rs.getInt("pin_code"));

				addressList.add(address);

			}

			for (Address ad : addressList) {

				System.out.println("Address are:" + ad);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}

		return addressList;

	}

	@Override
	public boolean isAddressExist(Address address) {
		boolean result = false;

		List<Address> addressList = null;

		try {
			addressList = getAddressList();

			for (Address add : addressList) {

				if (add.getAddressId() == address.getAddressId() && add.getCity().equalsIgnoreCase(address.getCity())) {

					result = true;

					// System.out.println("Address is exist" + address.getAddressId());

					System.out.println("Address with address Id " + address.getAddressId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	@Override
	public int saveAddress(Address address) {
		Connection conn = null;

		PreparedStatement prepare = null;

		int result = 0;

		int pos = 0;

		int addressId = 0;

		ResultSet rs = null;

		boolean flag = isAddressExist(address);
		if (!flag) {
			try {

				conn = DBConnection.getConnection();

				conn.setAutoCommit(false);

				prepare = conn.prepareStatement(getSaveAddress, prepare.RETURN_GENERATED_KEYS);

				prepare.setInt(++pos, address.getAddressId());

				prepare.setInt(++pos, address.getFlatNumber());

				prepare.setString(++pos, address.getLandMark());

				prepare.setString(++pos, address.getDistric());

				prepare.setString(++pos, address.getCity());

				prepare.setString(++pos, address.getState());

				prepare.setString(++pos, address.getCountry());

				prepare.setInt(++pos, address.getPinNumber());

				result = prepare.executeUpdate();

				rs = prepare.getGeneratedKeys();

				if (rs.next()) {

					conn.commit();

					addressId = rs.getInt(1);

					System.out.println(address.getCity() + " inserted into DB with " + addressId);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if (prepare != null) {
					try {
						prepare.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
			}
		} else {
			System.out.println("Address already exists.....");
		}

		return addressId;
	}

	@Override
	public List<Address> saveAddressList(List<Address> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address address, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(getUpdateAddress, preset.RETURN_GENERATED_KEYS);
			preset.setString(1, address.getCity());
			preset.setInt(2, id);

			result = preset.executeUpdate();
			if (result > 0) {
				System.out.println("Address updated successfully......");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}

		return address;

	}

	@Override
	public void deleteAddress(int id) {

		Connection conn = null;
		PreparedStatement preset = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(getDeleteAddress, preset.RETURN_GENERATED_KEYS);
			result = preset.executeUpdate();
			if (result > 0) {
				System.out.println("Address deleted successfully......");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (preset != null) {
			try {
				preset.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public boolean disableAddress(int disable, int id) {

		return false;
	}

}
