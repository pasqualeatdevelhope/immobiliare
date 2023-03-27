package org.example.controllers.dto;

public class StatusResponse {

	private Status status = Status.OK;
	private String errorMessage;

	public enum Status {
		OK, KO;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
