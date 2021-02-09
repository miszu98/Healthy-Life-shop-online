# Healthy Life shop online
### Online store with healthy food for delivery

## Assumptions
### The assumptions were to create a web application that would allow:
1. [Account registrations](#registration-form)
   * Full validation
   * Password hashing (`BCrypt`)
2. [Login](#login-page)
3. [Viewing all products](#main-page)
4. [Adding product to basket (kg or items)](#after-logging-in)
5. [Deleting products from basket](#after-logging-in)
5. [Filtering products](#filtered-offer)
6. [Sending e-mails after registration](#)
7. [Sending e-mails after submit an order with summary](#)

## Technologies and Dependecies

* JAVA language
* Spring Boot 
  * Spring Security
* Database: H2
* Hibernate
  * Hibernate Validator
- Thymeleaf
- Mail sender
- Passay

## Launch
Before starting, configure the `application.properties` file for a specific e-mail from which the application will be able to send e-mails to users

```
spring.mail.host= 
spring.mail.port=
spring.mail.username=
spring.mail.password=
```

## Images 

### Main page
#### sample offers are added here. Constants in the database. There is also filtering by province.
<p align="left"> 
  <img src="https://i.imgur.com/6xxtTm0.png"  width="700px">
</p>

### Login page 
#### from which we can log in or go to the registration form.
<p align="left"> 
  <img src="https://i.imgur.com/24iL1Wh.png"  width="700px">
</p>

### Registration form
<p align="left"> 
  <img src="https://i.imgur.com/7ZOiIC8.png"  width="700px">
</p>

### After logging in
#### you can add/delete your own offers.
<p align="left"> 
  <img src="https://i.imgur.com/ZAnbKJk.png"  width="700px">
</p>

### Filtered offer
<p align="left"> 
  <img src="https://i.imgur.com/OaSukpe.png"  width="700px">
</p>

### Details of offer
<p align="left"> 
  <img src="https://i.imgur.com/9x8diod.png"  width="700px">
</p>

## Status of project: 
```diff 
+ COMPLETE
```
