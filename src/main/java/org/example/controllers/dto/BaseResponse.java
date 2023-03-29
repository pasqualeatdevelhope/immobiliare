package org.example.controllers.dto;

public class BaseResponse {
	private Status status = Status.OK;
	private String errorMessage;

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

	public enum Status {
		OK, KO
	}

	public static BaseResponse ok(){
		return new BaseResponse();
	}

}
