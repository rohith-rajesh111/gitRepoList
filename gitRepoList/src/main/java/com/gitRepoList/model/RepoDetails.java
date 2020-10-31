package com.gitRepoList.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

class Owner{
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoDetails{

	private Long id;
	private String name;
	private String url;
	private Owner owner;
	
	public Long getId() {
		return id;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}		
}
