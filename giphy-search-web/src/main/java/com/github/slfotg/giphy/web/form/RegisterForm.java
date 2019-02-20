package com.github.slfotg.giphy.web.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.slfotg.giphy.web.form.validation.PasswordsMatch;

@PasswordsMatch(message = "{message.passwordMatch}")
public class RegisterForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "{message.emptyUsername}")
    @Size(min = 2, max = 20, message = "{message.usernameLength}")
    private String username;

    @NotNull(message = "{message.emptyPassword}")
    @Size(min = 8, max = 40, message = "{message.passwordLength}")
    private String password;

    @NotNull
    private String passwordMatch;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMatch() {
        return passwordMatch;
    }

    public void setPasswordMatch(String passwordMatch) {
        this.passwordMatch = passwordMatch;
    }

}
