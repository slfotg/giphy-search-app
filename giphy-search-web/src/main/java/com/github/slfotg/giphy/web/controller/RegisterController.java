package com.github.slfotg.giphy.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.slfotg.giphy.web.form.RegisterForm;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping({ "", "/" })
    public String register(Model model) {
        RegisterForm form = new RegisterForm();
        model.addAttribute("registrationForm", form);
        return "register";
    }

    @PostMapping({ "", "/" })
    public String registerNewUser(@ModelAttribute("registerForm") @Valid RegisterForm form,
            BindingResult bindingResult) {
        return "register";
    }
}
