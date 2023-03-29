package com.bank.bankimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.bankinterface.BankInter;
import com.bank.pojo.Address;
import com.bank.pojo.Bank;

import connection.DBConnection;

public class Bankimpl implements BankInter {

	@Override
	public List<Bank> getBankList() {
		Connection conn = null;

		Statement st = null;

		ResultSet rs = null;

		String sql = "select * from bank";

		Bank bank = null;

		List<Bank> bankList = null;

		try {
			conn = DBConnection.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery(sql);

			bankList = new ArrayList();

			while (rs.next()) {

				bank = new Bank();

				bank.setBankId(rs.getInt("id"));

				bank.setBankName(rs.getString("bank_name"));

				bank.setIfscNumber(rs.getString("ifsc_code"));

				bank.setTotalNumberOfCustomer(rs.getInt("total_no_of_cust"));

				bank.setBankBalance(rs.getDouble("bank_bal"));

				bank.setAddressId(rs.getInt("add_id"));

				bankList.add(bank);
			}

			for (Bank ban : bankList) {

				System.out.println("Bank List is" + ban);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bankList;
	}

	@Override
	public boolean isBankExist(Bank bank) {
		boolean flag = false;

		List<Bank> bankList = null;
		try {
			bankList = getBankList();

			for (Bank b : bankList) {

				if (b.getBankId() == bank.getBankId() && b.getBankName().equalsIgnoreCase(bank.getBankName())) {
					flag = true;

					System.out.println("Bank is already exist");
					break;

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public Bank saveBank(Bank bank) {

		Connection conn = null;
		PreparedStatement prepare = null;
		int result = 0;
		int addressId = 0;
		boolean flag = isBankExist(bank);
		if (!flag) {
			String sql = "insert into bank(id,bank_name,ifsc_code,total_no_of_cust,bank_bal,add_id)values(?,?,?,?,?,?)";

			try {

				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				prepare = conn.prepareStatement(sql, prepare.RETURN_GENERATED_KEYS);
				prepare.setInt(1, bank.getBankId());
				prepare.setString(2, bank.getBankName());
				prepare.setString(3, bank.getIfscNumber());
				prepare.setInt(4, bank.getTotalNumberOfCustomer());
				prepare.setDouble(5, bank.getBankBalance());

				Addressimpl impl = new Addressimpl();

				addressId = impl.saveAddress(bank.getAddress());
				result = prepare.executeUpdate();
				if (result > 0) {
					conn.commit();
					System.out.println(bank.getBankName() + " inserted into DB with " + bank.getBankId());
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
		}
		return bank;
	}

	@Override
	public List<Bank> saveBankList(List<Address> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bank updateBank(Bank bank, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		String sql = "update address set bank_bal=?   where id=?;";
		int result = 0;
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setDouble(++pos, bank.getBankBalance());
			preset.setInt(++pos, id);

			result = preset.executeUpdate();
			if (result > 0) {
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
		return bank;
	}

	@Override
	public void deleteBank(int id) {

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
	public boolean disableBank(int disable, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
