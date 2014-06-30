package com.ravipatel.statusserver.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ravipatel
 *
 */
public class BaseJsonOutput{
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	@JsonProperty("status_code")
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "BaseJsonOutput [message=" + message + ", success=" + success
				+ ", statuscode=" + statuscode + ", result=" + result + "]";
	}
	private String message;
	private Boolean success;
	private int statuscode;
	private Object result;
}