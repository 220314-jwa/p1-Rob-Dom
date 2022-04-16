package com.revature.trms;

public class Status {
	public int statusId;
	public String statusName;
	
	public Status() {
		statusId=0;
		statusName="";
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
