package com.simpleshop.Errors;

import com.simpleshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameConstraintValidator implements ConstraintValidator<ValidUsername, String> {

    private UserService userService;

    @Autowired
    public UsernameConstraintValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean check(String username) {
        int lowerLetter = 0;

        for (char character : username.toCharArray()) {
            if (Character.isLowerCase(character)) { lowerLetter++; }
            else if (character == ' ') { return false; }
        }

        return lowerLetter >= 5;
    }

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userService.findByUsername(username).isPresent()) { return false; }
        return check(username);
    }
}
