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
	
	public static final String getCustomerList = "Select * from customer";
	public static final String saveCustomer = "insert into customer(first_name,last_name,account_number,current_balance,mobile_number,bank_id,addr_id,isEnable) values(?,?,?,?,?,?,?,?)";
	public static final String updateCustomer = "Update customer set last_name=? where id=?";
	public static final String deleteCustomer = "delete from customere where id=?";
	public static final String disableCustomer = "update customer set isEnable=? where id=?";
	public static final String getCustomerCurrentBalance = "select current_balance from customer where account_number=?";
	public static final String withdrawAmount = "update customer set current_balance=current_balance-? where account_number=?";

	@Override
	public List<Customer> getCustomerList() {

		Connection conn = null;

		Statement st = null;

		ResultSet rs = null;

		//String sql = "select * from customer";

		List<Customer> customerList = null;

		Customer customer = null;

		try {
			customer = new Customer();

			customerList = new ArrayList();

			conn = DBConnection.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery(getCustomerList);

			while (rs.next()) {
				customer.setCustomerId(rs.getInt("id"));

				customer.setCustomerFirstName(rs.getString("first_name"));

				customer.setCustomerLastName(rs.getString("last_name"));

				customer.setAccountNumber(rs.getInt("account_number"));

				customer.setCustomerCurrentBal(rs.getDouble("current_balance"));

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
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "update customer set isEnable=? where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(disableCustomer, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, disable);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Customer disabled.....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public double getCustomerCurrentBalance(int accountNumber) {
		double balance = 0.0;
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		ResultSet rs = null;
		// String sql = "select current_balance from customer where account_number=?";
		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(getCustomerCurrentBalance, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, accountNumber);
			rs = preset.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
				System.out.println(balance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return balance;
	}

	@Override
	public void depositAmount(int accountNumber, double amount) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int result = 0;
		String sql = "update customer set current_balance=current_balance+? where account_number=?";
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setDouble(++pos, amount);
			preset.setInt(++pos, accountNumber);
			result = preset.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println("Amount deposited successfully...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void withdrawAmount(int account_number, double amount) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int result = 0;
		ResultSet rs = null;
		double balance = 0.0;
		String ch = "select current_balance from customer where account_number=?";

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preset = conn.prepareStatement(ch, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, account_number);
			rs = preset.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
			}
			if (balance > amount) {
				pos = 0;
				preset = conn.prepareStatement(withdrawAmount, preset.RETURN_GENERATED_KEYS);
				preset.setDouble(++pos, amount);
				preset.setInt(++pos, account_number);
				result = preset.executeUpdate();
				if (result > 0) {
					conn.commit();
					System.out.println("Amount withdraw successfully...");
				}
			} else {
				System.out.println("Insufficient amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void transferAmount(int debter_account_number, int crediter_account_number, double amount) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int result = 0;
		ResultSet rs = null;
		double balance = 0.0;
		String check = "select current_balance from customer where account_number=?";
		String withdraw = "update customer set current_balance=current_balance-? where account_number=?";
		String deposit = "update customer set current_balance=current_balance+? where account_number=?";
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preset = conn.prepareStatement(check, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, debter_account_number);
			rs = preset.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
			}
			if (balance > amount) {
				pos = 0;
				preset = conn.prepareStatement(withdraw, preset.RETURN_GENERATED_KEYS);
				preset.setDouble(++pos, amount);
				preset.setInt(++pos, debter_account_number);
				result = preset.executeUpdate();
				if (result > 0) {
					conn.commit();
					System.out.println("Amount transferred successfully...");
				}
			} else {
				System.out.println("Insufficient amount to transfer");
			}

			pos = 0;
			preset = conn.prepareStatement(deposit, preset.RETURN_GENERATED_KEYS);
			preset.setDouble(++pos, amount);
			preset.setInt(++pos, crediter_account_number);
			result = preset.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println("Amount received.....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
