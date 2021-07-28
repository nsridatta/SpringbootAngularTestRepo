# Spring Boot Server Code

## After cloning this server project code run below command in your terminal:
**mvn clean install package**

## Once after successful maven installation , below mentioned are various ways to boot your application up:
1. Thru maven: **mvn spring-boot:run**
2. Thru Intellij / Eclipse / STS, run the application as java or spring boot application

Features:
1. AOP
2. Exception Handling using Controller Advice for most of the Contraints and Validations
3. In Memory H2 DB, with custom path and enabled console logging
4. Modified Actuator web path
5. Dev Tools support
6. Customized Log Back messaging
7. Swagger2 doc support
8. Custom Date and Email Validator Constraints
9. TDD style of approach


**Note**: You shall not see the default Spring boot banner, as that is turned off by default in the application-dev.properties file
