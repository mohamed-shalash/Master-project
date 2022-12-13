# Master-project

this project is a computer model for engineering master degree about bridge construction systems in Egypt.
tools used
- java
- spring boot
- spring mvc thymeleaf
- mysql database
- topsis

### configure the project to run in your environment

- data base used is mysql first install mysql database
```properties
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/demo

```
- you need then to build the project install java and maven building tool then use this commands


### run the project

- first install maven [steps](https://maven.apache.org/install.html)
- use this command to run spring project `mvn spring-boot:run`

### package this app

- clean create jar `mvn clean install`
- run this jar `java -jar <jar file name>`
