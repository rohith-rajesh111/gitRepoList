package com.gitRepoList.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitRepoList.model.AllErrorsList;
import com.gitRepoList.model.ErrorDetails;

@ControllerAdvice
@RestController
public class ControllerErrorHandler implements ErrorController{
	
	@ExceptionHandler(RuntimeException.class)
	public ErrorDetails handleRunTimeException(RuntimeException e) {
		return new ErrorDetails("Error while invoking GitHub API",e.getMessage());
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/error")
	public ErrorDetails showErrorMessage() {
		return new ErrorDetails("Error while invoking GitHub API",String.format("Expected URL to be formed like this : /projects?language={language} Eg: localhost:8080/projects?language=java"));
	}
	
	@ExceptionHandler(HttpStatusCodeException.class)
	public AllErrorsList handleRestAPIInvocationException(HttpStatusCodeException e) 
			throws JsonMappingException, JsonProcessingException {
		
		String error = e.getResponseBodyAsString();
		ObjectMapper obj = new ObjectMapper();
		AllErrorsList ls = obj.readValue(error, AllErrorsList.class);
		return ls;
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ErrorDetails missingParamException(MissingServletRequestParameterException e) {
		
		return new ErrorDetails("Error while invoking GitHub API",e.getMessage());
		
	}
}
