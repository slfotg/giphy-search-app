package com.github.slfotg.giphy.web.form.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.slfotg.giphy.web.form.RegisterForm;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, RegisterForm> {

    @Override
    public boolean isValid(RegisterForm registerForm, ConstraintValidatorContext context) {
        return registerForm.getPassword().equals(registerForm.getPasswordMatch());
    }
}