package com.revature.trms;

import java.util.Date;

public class Reimbursement {
	private long requestId;
	private long eventId;
	private long statusId;
	private Date eventDate;
	private String description;
	private Date submittedAt;
	
	public Reimbursement() {
		requestId = 0;
		eventId = 0;
		eventDate = new Date();
		statusId = 0;
		description = "";
		submittedAt = new Date();
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Date submittedAt) {
		this.submittedAt = submittedAt;
	}
}
//preparedStatement.setDate(7, (Date) req.getSubmitted_at());
// the above line is for date variables