package com.chainsys.demoapp.service;

import java.util.List;

import com.chainsys.demoapp.dao.TaskDAO;
import com.chainsys.demoapp.model.Task;

public class TaskService {
	public List<Task> findAllTasks() {
		TaskDAO taskDao = TaskDAO.getInstance();
		return taskDao.findAllTasks();

	}

	/**
	 * @param task object
	 * @return boolean true if task details inserted
	 */
	public boolean insertTask(Task task) {
		TaskDAO taskDao = TaskDAO.getInstance();
		return taskDao.insertTask(task);
	}

	/**
	 * @param task object
	 * @return true if task details updated
	 */
	public boolean updateTaskStatus(Task task) {

		TaskDAO taskDao = TaskDAO.getInstance();
		return taskDao.updateTaskStatus(task);

	}

	/**
	 * @param task object
	 * @return true if task details updated
	 */
	public boolean updateTaskPriority(Task task) {
		TaskDAO taskDao = TaskDAO.getInstance();
		return taskDao.updateTaskPriority(task);

	}

	/**
	 * @param task object
	 * @return true if task is deleted
	 */
	public boolean deleteTask(Task task) {

		TaskDAO taskDao = TaskDAO.getInstance();
		return taskDao.deleteTask(task);

	}

}
