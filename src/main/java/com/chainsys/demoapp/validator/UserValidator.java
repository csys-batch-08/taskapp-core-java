package com.chainsys.demoapp.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chainsys.demoapp.dao.UserDAO;
import com.chainsys.demoapp.model.User;
import com.chainsys.demoapp.util.ConnectionUtil;

public class UserValidator {
	/**
	 * make it as singlton 
	 */
	public static UserValidator userValidator;
	private UserValidator()
	{
		
	}
	public static UserValidator getInstance()
	{
		if(userValidator==null)
		{
			userValidator=new UserValidator();
		}
		return userValidator;
		
	}

	/**
	 * @param long mobile number this method is to check user details in the table
	 * @return User Object if email and password present in the table 
	 */
	public User validateUser(String email, String password) {
		String validateQuery = "select name from user_cafe where email=?,password=?";
		Connection con = ConnectionUtil.getDbConnect();
		User user = null;
		try {
			PreparedStatement stmt = con.prepareStatement(validateQuery);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery(validateQuery);
			if (rs.next()) {
				user = new User(rs.getString(1),email,password);
			} 

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;
	}

}
