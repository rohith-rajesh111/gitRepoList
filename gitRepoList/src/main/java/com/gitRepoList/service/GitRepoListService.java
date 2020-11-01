package com.gitRepoList.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.gitRepoList.model.AllReposList;

@Service
public class GitRepoListService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	/**
	 * This method invokes the GitHub public REST API with the inputs language and page using
	 * Spring's RestTemplate. If the value of language is invalid then RestClientException is thrown which
	 * is handled in the ControllerErrorHandler class. 
	 * 
	 * @param language
	 * @param page
	 * @return
	 * @throws RestClientException
	 */
	public AllReposList getAllProjects(String language,Integer page) throws RestClientException{
		
		final String uri = "https://api.github.com/search/repositories?q=language:{language}&page={page}";
		Map<String,Object> m = new HashMap<>();
		m.put("language", language);
		m.put("page", page);
		
		AllReposList ls = restTemplate.getForObject(uri,AllReposList.class,m);
		return ls;
	}
}
