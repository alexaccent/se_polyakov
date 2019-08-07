package sef.module13.activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	@SuppressWarnings("unused")
	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException, SQLException {

		Statement stm = conn.createStatement();
		List<Account> accounts = new ArrayList<>();

		try {

			ResultSet rs = stm.executeQuery("SELECT * FROM ACCOUNT");

			while(rs.next())
			{
				int rsId = rs.getInt(1);
				String rsFirstName = rs.getString(2);
				String rsLastName = rs.getString(3);
				String rsEmail = rs.getString(4);

				if (rsFirstName.equals(firstName) || rsLastName.equals(lastName)) {
					accounts.add(new AccountImpl(rsId, rsFirstName, rsLastName, rsEmail));
				}
			}

		} catch (SQLException e) {
			new AccountDAOException("Exception occcured while finding Account via Name", e);
		} finally {
			stm.close();
		}

		return accounts;
	}

	public Account findAccount(int id) throws AccountDAOException, SQLException {

		String selectSQL = "SELECT * FROM ACCOUNT WHERE ID = ?";
		PreparedStatement preparedStm = conn.prepareStatement(selectSQL);

		try {

			preparedStm.setInt(1 , id);
			ResultSet rs = preparedStm.executeQuery();
			rs.next();
			int rsId = rs.getInt(1);

			if (rsId == id) {

				String rsFirstName = rs.getString(2);
				String rsLastName = rs.getString(3);
				String rsEmail = rs.getString(4);

				Account account = new AccountImpl(id, rsFirstName, rsLastName, rsEmail);

				return account;
			}

		} catch (SQLException e) {

			new AccountDAOException("Exception occcured while finding Account via ID", e);
		} finally {
			preparedStm.close();
		}

		return null;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException, SQLException {

		String insertSQL = "INSERT INTO ACCOUNT (ID, FIRST_NAME,LAST_NAME,E_MAIL) VALUES (ACCOUNT_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement preparedStm = conn.prepareStatement(insertSQL);

		try {

			preparedStm.setString(1, firstName);
			preparedStm.setString(2, lastName);
			preparedStm.setString(3, email);
			int result = preparedStm.executeUpdate();

			if (result > 0) {
				return true;
			}

		} catch (SQLException e) {
			new AccountDAOException("Exception occured while inserting new Account", e);
		} finally {
			preparedStm.close();
		}

		return false;
	}

}
