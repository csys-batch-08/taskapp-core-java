package com.chainsys.demoapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.demoapp.model.User;
import com.chainsys.demoapp.util.ConnectionUtil;


public class UserDAO {

	/**
	 * @param user object
	 * @return boolean true if user details inserted
	 */
	public boolean userInsert(User user) {
		Connection con = ConnectionUtil.getDbConnect();

		String query = "insert into UserSample123 values('" + user.getName() + "','" + user.getEmail() + "','"
				+ user.getPassword() + "')";
		boolean flag = false;
		Statement stmt = null;
		try {
			stmt = con.createStatement();

			flag = stmt.executeUpdate(query) > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	
	/**
	 * @return list of user objects fetched data from the table
	 */
	public List<User> showAll() {
		List<User> userList = new ArrayList<User>();

		String query = "select * from userSample123";
		Connection con = ConnectionUtil.getDbConnect();
		Statement stmt;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
				userList.add(user);

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return userList;

	}

}
