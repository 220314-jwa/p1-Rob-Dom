package com.revature.trms;

public class Event extends Reimbursement {
	private int event_id;
	private int dept_id;
	private String eventName;
	
	public Event() {
		event_id=0;
		dept_id=0;
		eventName="";
	}
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getHead_id() {
		return event_id;
	}
	public void setHead_id(int head_id) {
		this.event_id = head_id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
