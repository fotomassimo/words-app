## WORDS-APP

# General info
Words-app is a REST-full web application that provides functionality of parsing the input text and give the
list of distinct words and their count as an output. 
Testing tool Postman can be used to test the application. 

# Technologies
List of used technologies:
* Apache Maven 
* Git 
* IntelliJ IDEA 2021.1.1
* JDK 11
* JUnit  
* Lombok   
* MySQL 8.0
* Spring Boot 2.3  

# Installation
Application can be launched on a computer that has JRE (JDK 11) and MySQL Workbench
installed.

These are steps to deploy the project on your computer:

1.Setup database: in `MySQL Workbench` create and open new connection with your credentials or use
the existing one, open file `src/main/resources/init_db.sql` from the folder of this project
`File`->`Open SQL script` and execute this script `Query`->`Execute (All or Selection)`.

2.Setup database connection properties: Open file `src/main/resources/application.properties` in this
project using IDE and set values `user`, `password` and localhost port value according to the
credentials from your MySQL connection.

3.Deploy the project on the web server using IDE by running the file `src/main/java/pmm/words/api/WordsApiApplication.java`
or build an executable *.jar file in IDE and launch it in a command line.   

Maven checkstyle plugin is present in the project and can be launched by command `mvn package` in the IDE Terminal. 

# Usage
The application access URL by default is `http://localhost:8080/index`.
Send a request in JSON format using tool Postman: `{"payload":"your_text"}`(don't forget to use escape character '\' 
for special characters). In response, you will get the words' statistics in JSON format.  
