package com.cms.incident.audit;

import java.util.Date;

public class ExceptionMessage {
	private int errorCode;
    private String errorMessage;
    private String description;
    private Date timestamp;
 
    public ExceptionMessage() {
    }
 
    public ExceptionMessage(
    		int errorCode, 
    		String errorMessage, 
    		String description, 
    		Date timestamp) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.description = description;
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getErrorCode() {
        return errorCode;
    }
 
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
