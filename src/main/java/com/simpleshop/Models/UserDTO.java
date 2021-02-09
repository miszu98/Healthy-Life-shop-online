package com.simpleshop.Models;import com.simpleshop.Errors.ValidPassword;import com.simpleshop.Errors.ValidUsername;import javax.validation.constraints.NotEmpty;public class UserDTO {    @ValidUsername    @NotEmpty(message = "Username field cannot be empty")    private String username;    @ValidPassword    @NotEmpty(message = "Password field cannot be empty")    private String password;    private String role;    private String email;    private String phoneNumber;    private String code;    public UserDTO() {    }    public UserDTO(String username, String password, String role, String email, String phoneNumber, String code) {        this.username = username;        this.password = password;        this.role = role;        this.email = email;        this.phoneNumber = phoneNumber;        this.code = code;    }    public String getUsername() {        return username;    }    public void setUsername(String username) {        this.username = username;    }    public String getPassword() {        return password;    }    public void setPassword(String password) {        this.password = password;    }    public String getRole() {        return role;    }    public void setRole(String role) {        this.role = role;    }    public String getEmail() {        return email;    }    public void setEmail(String email) {        this.email = email;    }    public String getPhoneNumber() {        return phoneNumber;    }    public void setPhoneNumber(String phoneNumber) {        this.phoneNumber = phoneNumber;    }    public String getCode() {        return code;    }    public void setCode(String code) {        this.code = code;    }}