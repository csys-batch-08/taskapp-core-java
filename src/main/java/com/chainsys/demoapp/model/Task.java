package com.chainsys.demoapp.model;

import java.util.Date;

public class Task {
	
	private int taskId;
	private String name;
	private String createdBy;
	private String priority;
	private String status;
	private Date createdDate;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", createdBy=" + createdBy + ", priority=" + priority
				+ ", status=" + status + ", createdDate=" + createdDate + "]";
	}
	public Task(int taskId, String name, String createdBy, String priority, String status, Date createdDate) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.createdBy = createdBy;
		this.priority = priority;
		this.status = status;
		this.createdDate = createdDate;
	}
	
	

}
