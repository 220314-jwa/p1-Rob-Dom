package com.revature.trms;

public class Department {
	private int depID;
	private String depName;
	private int depHeadID;
	private String pendingDepApproval;
	
	public Department( ) {
		depID=0;
		depName="";
		depHeadID=0;
		pendingDepApproval="";
	}
	
	public int getDepID() {
		return depID;
	}
	public void setDepID(int depID) {
		this.depID = depID;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public int getDepHeadID() {
		return depHeadID;
	}
	public void setDepHeadID(int depHeadID) {
		this.depHeadID = depHeadID;
	}

	public String getPendingDepApproval() {
		return pendingDepApproval;
	}

	public void setPendingDepApproval(String pendingDepApproval) {
		this.pendingDepApproval = pendingDepApproval;
	}
}
