***
# Todo-Application

Todo application for CURD operations.Spring Boot REST API for backend and React  for Frontend.

###How to run todo-rest-api
	1. Download file from the location and extract.
	2. Go the project download location and the target folder in commad line [cd todo-rest-api/target]
	3. run the command [ java -jar todo-rest-api-1.0.0.jar ]
	3. Verify the Application up and running successfully. 
###How to access the Databse
This application have used H2 inmemory databased. <br/>

	1. Open the browser and enter the url [ access url : http://localhost:8080/h2-console ]
	2. Change the JDBC URL in login window as [ jdbc:h2:mem:tododb ]
	3. verify the database logging.

###How to test API 
Todo rest-api supports number of http method like (GET,POST,PUT,DELETE) <br/>

** [How to send a create request] - POST **  <br/>

	1. Access url : http://localhost:8080/api/todo/
	2.PayLoad
			{"name": "mahesh",
		    "description": "test user",
		    "dueDate": "2021-11-03",
		    "status": "pending"} 
** [How to send a get request] - GET **  <br/>

	1. Access url: http://localhost:8080/api/todo/{id}
	
 ** [How to send a patch request] - PUT **  <br/>
 
	1. Access url :  http://localhost:8080/api/todo/{id} 
	2. Payload
			{"name": "mahesh guruge",
		    "description": "test user",
		    "dueDate": "2021-11-03",
		    "status": "done"}
 ** [How to send a delete request] - DELETE **  <br/> 
   
	1. Access url : http://localhost:8080/api/todo/{id}
 
***
