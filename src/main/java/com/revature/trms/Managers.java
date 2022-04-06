package com.revature.trms;

public class Managers {
	private int managerID;
	private String managerName;
	private String pendingRequests;
	
	public Managers() {
		managerID=0;
		managerName="";
		pendingRequests="";
	}
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getPendingRequests() {
		return pendingRequests;
	}

	public void setPendingRequests(String pendingRequests) {
		this.pendingRequests = pendingRequests;
	}
}
