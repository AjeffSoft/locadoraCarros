package com.ajeff.locadora.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String error;
	private String message;
	private String path;
	private Long timeStamp;
	
	public StandardError() {}

	public StandardError(Integer status, String error, String message, String path, Long timeStamp) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
	

}
