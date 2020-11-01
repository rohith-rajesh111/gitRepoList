# gitRepoList
A REST service to list all the repositories of GitHub, for the provided input programming language.

This service internally invokes GitHub's public REST API https://docs.github.com/en/rest/reference/search#search-repositories and returns the following information
[{id , name, url, owner.login }]

*******************

## Steps to run

gitRepoList/gitRepoList can be kept as the project folder for IDEs like Eclipse or IntelliJ . 

gitRepoList/src/main/java/com.gitRepoList.GitRepoListApplication.java -> Run As Java Application

********************

## Supported Endpoints :


Once the application is deployed, the API has to be invoked using the following URI pattern:

/projects?language={language}&page={pageNumber}

Examples:
1. localhost:8080/projects?language=java&page=2
2. localhost:8080/projects?language=java

This will list all the projects for the specified language, with 30 results per page. If page number is not provided,
the first 30 rows will be displayed by default.

************************************

## Steps to create executable jar file


Go to the project root folder and run on console:

mvn clean package spring-boot:repackage
