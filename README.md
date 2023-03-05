# salesken_coding_assignment

<p align="center">
  <img src="https://www.linkpicture.com/q/student-report-management-system.png" alt="studentReport" />
</p>

 #  Student Reporting Management System
This application is a REST API for generating Student Report using CRUD operations.




### Tech Stacks

- Java
- Spring Boot 
- Spring Data JPA 
- MySQL 
- Hibernate
- Layered Architechture
- Swagger UI
- Lombok



### Modules
-StudentDetails Module
-StudentMarksSemesterWise Module

### Functionalities
    * Register Student records in database
    * Access all records of students from databse
    * Add student marks using student id in the database
    * Get Average marks of students in a particular subject
    * Get Average percentage of whole class
    * Get details of top two students from database.


##   ER_Diagram                                            
![Book Cab ER Diagram](https://www.linkpicture.com/q/ER-Diagram.png)

### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/saleskenDB
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

    
````
## API Root and Endpoint

* http://localhost:8888/register - Register Student

* http://localhost:8888/students - Get All students

* http://localhost:8888/addMarks/{id} - Add Marks with id

* http://localhost:8888/averageMarks - Calculate Average Marks Of student in a particular subject

* http://localhost:8888/percentage - Calculate Average percentage of whole class

* http://localhost:8888/toppers - Get top 2 toppers from the class


### Contributors

- [@Rakshika_Kadu](https://github.com/Rakshikakadu)

#### For any feedback, report, suggestions you can directly contact.
### THANK YOU



