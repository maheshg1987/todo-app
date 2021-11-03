# todo-app
Todo list application for CURD operations.Spring Boot REST API for backend and React  for Frontend.

###Access Databse
H2 inmemory databased have used. 
> access url : http://localhost:8080/h2-console <br/>
> change the JDBC URL in login window as jdbc:h2:mem:tododb <br/>

### API Test
Todo app supports number of http method like (GET,POST,PUT,DELETE) <br/>

**POST** <br/>
http://localhost:8080/api/todo/ <br/>
{"name": "mahesh",
    "description": "bye",
    "dueDate": "2007-12-03",
    "status": "active"} <br/>
    
 **GET** <br/>
 http://localhost:8080/api/todo/{id} <br/>
 
 **PUT**<br/>
 http://localhost:8080/api/todo/{id} <br/>
{"name": "mahesh",
    "description": "bye",
    "dueDate": "2007-12-03",
    "status": "active"} <br/>
    
 **DELETE**<br/>
 http://localhost:8080/api/todo/{id} <br/>
  
