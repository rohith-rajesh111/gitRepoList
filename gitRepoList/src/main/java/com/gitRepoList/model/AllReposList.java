package com.gitRepoList.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllReposList {
	
	private List<RepoDetails> items;

	public List<RepoDetails> getItems() {
		return items;
	}
	public void setItems(List<RepoDetails> list) {
		this.items = list;
	}

	
}
