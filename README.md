# Healthy Life shop online
 Online store with healthy food for delivery

## Assumptions
### The assumptions were to create a web application that would allow:
1. [Account registrations](#registration-form)
   * Full validation
   * Password hashing (`BCrypt`)
2. [Login](#login-page)
3. [Viewing all products](#all-products)
4. [Adding product to basket (kg or items)](#after-logging-in)
5. [Deleting products from basket](#after-logging-in)
5. [Filtering products](#filtered-offer)
6. [View cart](#view-cart)
7. [Placing orders](#order)
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
#### sample products on sliders, access to login, filter and view the cart after logging in
<p align="left"> 
  <img src="https://i.imgur.com/8pSLtW2.png"  width="700px">
</p>

### Filtered offer
<p align="left"> 
  <img src="https://i.imgur.com/vilkX1e.png"  width="700px">
</p>

### All products
<p align="left"> 
  <img src="https://i.imgur.com/C1U5N3Q.png"  width="700px">
</p>

### Login page 
#### from which we can log in or go to the registration form.
<p align="left"> 
  <img src="https://i.imgur.com/jGP8IEv.png"  width="700px">
</p>

### Registration form
<p align="left"> 
  <img src="https://i.imgur.com/FgS39JM.png"  width="700px">
</p>

### After logging in
#### you can add/delete your products to cart.
<p align="left"> 
  <img src="https://i.imgur.com/SYEe1lj.png"  width="250px"><img src="https://i.imgur.com/POEGELC.png"  width="250px">
</p>


### View cart
<p align="left"> 
  <img src="https://i.imgur.com/4XkDm9Z.png"  width="700px">
</p>

### Order
<p align="left"> 
  <img src="https://i.imgur.com/80oL1Na.png"  width="700px">
</p>

## Status of project: 
```diff 
+ COMPLETE
```
