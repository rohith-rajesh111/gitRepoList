package com.gitRepoList.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllErrorsList {
	private String message;
	private List<ErrorDetails> errors;
	
	public List<ErrorDetails> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetails> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
