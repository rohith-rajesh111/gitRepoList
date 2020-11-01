/**
 * The main controller class of the API. The only available endpoint is /projects
 * Expected URI to be formed like /projects?language={language}&page={page}
 */
package com.gitRepoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gitRepoList.model.AllReposList;
import com.gitRepoList.model.RepoDetails;
import com.gitRepoList.service.GitRepoListService;

@RestController
public class GitRepoListController{ 
	
	@Autowired
	GitRepoListService service;
	
	
	/**
	 * This method intercepts all the requests with /projects endpoint and redirects to the service method
	 * if the proper input params are received, and provides the list of repositories as the response received
	 * from the GitHub API. If the URI is not well formed or contains incorrect args, ControllerErrorHandler class
	 *  will handle the exceptions
	 * 
	 * @param language
	 * @param page
	 * @return
	 */
	
	@RequestMapping("/projects")
	@Cacheable("projects")
	public List<RepoDetails> getAllProjects(@RequestParam String language,
										  @RequestParam (required = false) Integer page){
		if(language==null || language.trim().equals(""))
			throw new RuntimeException("Please provide language param in the URI for fetching results");
		
		AllReposList ls = service.getAllProjects(language, (page==null || page<=1) ? new Integer(1) : page);
		if(ls!=null) {
			if(ls.getItems()!=null && ls.getItems().size()>0) {
				return ls.getItems();
			}
		}
		else {
			throw new RuntimeException("Error while invoking GitHub API");
		}
		return null;
	}
	

}
