package com.chainsys.demoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.demoapp.model.Task;
import com.chainsys.demoapp.model.User;
import com.chainsys.demoapp.util.ConnectionUtil;

public class TaskDAO {

	/**
	 * make it as singlton
	 */
	public static TaskDAO taskDAO;

	private TaskDAO() {

	}

	public static TaskDAO getInstance() {
		if (taskDAO == null) {
			taskDAO = new TaskDAO();
		}
		return taskDAO;

	}
	/**
	 * @return list of task objects fetched from the table
	 */
	public List<Task> findAllTasks() {
		List<Task> taskList = new ArrayList<Task>();

		String query = "select name,priority,status,created_date from task123";
		Connection con = ConnectionUtil.getDbConnect();
		Statement stmt;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Task task=new Task(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDate(4));
				taskList.add(task);

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return taskList;

	}

	/**
	 * @param task object
	 * @return boolean true if task details inserted
	 */
	public boolean insertTask(Task task) {
		Connection con = ConnectionUtil.getDbConnect();

		String query = "insert into task123 (name,priority,status,created_date) values(?,?,?)";
		boolean flag = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, task.getName());
			stmt.setString(2, task.getPriority());
			stmt.setString(3, task.getStatus());
			stmt.setDate(4, new java.sql.Date(task.getCreatedDate().getTime()));

			flag = stmt.executeUpdate(query) > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * @param task object
	 * @return true if task details updated
	 */
	public boolean updateTaskStatus(Task task) {
		Connection con = ConnectionUtil.getDbConnect();
		String query = "update table task set status=? where name=? and status='pending'";
		boolean flag = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(2, task.getName());
			stmt.setString(1, task.getStatus());

			flag = stmt.executeUpdate(query) > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;

	}
	/**
	 * @param task object
	 * @return true if task details updated
	 */
	public boolean updateTaskPriority(Task task) {
		Connection con = ConnectionUtil.getDbConnect();
		String query = "update table task set priority=? where name=? and status='pending'";
		boolean flag = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(2, task.getName());
			stmt.setString(1, task.getPriority());
			flag = stmt.executeUpdate(query) > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;

	}

	/**
	 * @param task object
	 * @return true if task is deleted
	 */
	public boolean deleteTask(Task task)
	{
		Connection con = ConnectionUtil.getDbConnect();
		String query = "delete from task where name=? and status='pending'";
		boolean flag = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, task.getName());
			flag = stmt.executeUpdate(query) > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;

		
	}
}
