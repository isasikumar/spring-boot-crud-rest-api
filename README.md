# Example CRUD REST APIs Using Spring Boot, PostgreSQL

A complete example of a "CRUD" service built with SpringBoot + PostgreSQL

### Endpoints 

|URL|Description|
|---|---|
|http://localhost:8085/ | Base URL |

#### REST Service

|HTTP Method|URL|Description|
|---|---|---|
|`POST`|http://localhost:8085/api/students | Create new Student |
|`PUT`|http://localhost:8085/api/students/{studentId} | Update Student by ID |
|`GET`|http://localhost:8085/api/students | Get Student List |
|`GET`|http://localhost:8085/api/students/{studentId} | Get Student by ID |
|`DELETE`|http://localhost:8085/api/students/{studentId} | Delete Student by ID |
|`GET`|http://localhost:8085/api/students/search/{searchValue} | Search Student with ID or Name |
