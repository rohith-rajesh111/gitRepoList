package com.gitRepoList.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetails {
	
	private String message;
	private String resource;
	
	public ErrorDetails() {
		
	}
	
	public ErrorDetails(String message, String resource) {
		super();
		this.message = message;
		this.resource = resource;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
}
