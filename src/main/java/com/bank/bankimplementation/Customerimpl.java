package com.bank.bankimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.bankinterface.CustomerInter;
import com.bank.pojo.Bank;
import com.bank.pojo.Customer;

import connection.DBConnection;

public class Customerimpl implements CustomerInter {

	@Override
	public List<Customer> getCustomerList() {

		Connection conn = null;

		Statement st = null;

		ResultSet rs = null;

		String sql = "select * from customer";

		List<Customer> customerList = null;

		Customer customer = null;

		try {
			customer = new Customer();

			customerList = new ArrayList();

			conn = DBConnection.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery(sql);

			while (rs.next()) {
				customer.setCustomerId(rs.getInt("id"));

				customer.setCustomerFirstName(rs.getString("first_name"));

				customer.setCustomerLastName(rs.getString("last_name"));

				customer.setAccountNumber(rs.getInt("account_number"));

				customer.setCustomerCurrentBal(rs.getInt("current_balance"));

				customer.setMobileNumber(rs.getInt("mobile_number"));

				customer.setBankId(rs.getInt("bank_id"));

				customer.setAddressId(rs.getInt("addr_id"));

				customerList.add(customer);
				for (Customer cust : customerList) {

					System.out.println("Customer list is" + cust);
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public boolean isCustomerExist(Customer customer) {
		boolean result = false;

		List<Customer> customerList = null;

		try {

			customerList = getCustomerList();

			for (Customer cust : customerList) {

				if (cust.getCustomerId() == customer.getCustomerId()
						&& cust.getMobileNumber() == customer.getMobileNumber()) {

					result = true;

					System.out.println("Customer is exist");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Connection conn = null;

		PreparedStatement prepare = null;

		int result = 0;

		int addressId = 0;

		String sql = "insert into customer(id, first_name, last_name, account_number, current_balance, mobile_number, bank_id, addr_id)values(?,?,?,?,?,?,?,?)";

		try {

			conn = DBConnection.getConnection();

			prepare = conn.prepareStatement(sql, prepare.RETURN_GENERATED_KEYS);

			prepare.setInt(1, customer.getCustomerId());

			prepare.setString(2, customer.getCustomerFirstName());

			prepare.setString(3, customer.getCustomerLastName());

			prepare.setInt(4, customer.getAccountNumber());

			prepare.setDouble(5, customer.getCustomerCurrentBal());

			prepare.setInt(6, customer.getMobileNumber());

			prepare.setInt(7, customer.getBankId());

			Addressimpl impl = new Addressimpl();

			addressId = impl.saveAddress(customer.getAddress());

			result = prepare.executeUpdate();

			if (result > 0) {

				System.out.println(customer.getCustomerId() + " Inserted into DB having Mobile number "
						+ customer.getMobileNumber());
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return customer;
	}

	@Override
	public List<Customer> saveCustomerList(List<Customer> Customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		String sql = "update address set mobile_number=?  where id=?;";
		int result = 0;
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, customer.getMobileNumber());
			preset.setInt(++pos, id);

			result = preset.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println("Customer is updated successfully......");
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
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		int result = 0;
		String sql = "delete from bank where id=?";

		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
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
	public boolean disableCustomer(int disable, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getCustomerCurrentBal(Customer cust) {
		Connection conn = null;
		PreparedStatement preset = null;
		int result = 0;
		String sql = "select current_balance from customer where id=? group by current_balance";
		int pos = 0;
		ResultSet rs = null;
		try {

			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, cust.getCustomerId());
			//preset.setInt(++pos, cust.getCustomerCurrentBal());
			rs = preset.executeQuery();
			if (rs.next()) {
				System.out.println(cust.getCustomerId()+ " customer current balance is " + cust.getCustomerCurrentBal());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
