package com.chainsys.demoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.demoapp.model.User;
import com.chainsys.demoapp.util.ConnectionUtil;


public class UserDAO {
	
	/**
	 * make it as singlton 
	 */
	public static UserDAO userDao;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDao==null)
		{
			userDao=new UserDAO();
		}
		return userDao;
		
	}

	/**
	 * @param user object
	 * @return boolean true if user details inserted
	 */
	public boolean insertUser(User user) {
		Connection con = ConnectionUtil.getDbConnect();

		String query = "insert into user_demo (user_name,email,password) values('" + user.getName() + "','" + user.getEmail() + "','"
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
	 * @param user
	 * this method is to update user details in the table
	 * @return boolean true if value updated
	 */
	public boolean updateUser(User user) {
		String insertQuery = "update table user_demo user_name=?,password=? where email=?";
		
		Connection con = ConnectionUtil.getDbConnect();
		boolean result = false;
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.executeUpdate();
			

		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();
			
		}
		return result;
	}
	
	/**
	 * @return list of user objects fetched from the table
	 */
	public List<User> findAllUsers() {
		List<User> userList = new ArrayList<User>();

		String query = "select * from user_demo";
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
	/**
	 * @param user
	 * this method is to fetch user id from the table
	 * @return int user id 
	 */
	public int findUserId(User user) {
		String findUserID = "select id from user_demo where email= '" + user.getEmail() + "'";
		Connection con = ConnectionUtil.getDbConnect();
		Statement stmt;
		int userId = 0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(findUserID);
			if (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userId;

	}
	/**
	 * @param int userId
	 * this method is to fetch user details from the table
	 * @return User Object
	 */
	public User findUser(int userId) {
		String findUser = "select user_name,email,password from usersample123 where userID= '" + userId + "'";
		Connection con = ConnectionUtil.getDbConnect();
		Statement stmt;
		User user = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(findUser);
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;

	}

}
