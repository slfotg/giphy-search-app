package com.github.slfotg.giphy.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.slfotg.giphy.service.GiphyUserService;
import com.github.slfotg.giphy.web.form.RegisterForm;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private GiphyUserService giphyUserService;

    @GetMapping({ "", "/" })
    public String register(Model model) {
        RegisterForm form = new RegisterForm();
        model.addAttribute("registerForm", form);
        return "register";
    }

    @PostMapping({ "", "/" })
    public String registerNewUser(@Valid RegisterForm form, BindingResult bindingResult) {
        if (!bindingResult.hasErrors() && giphyUserService.userExists(form.getUsername())) {
            bindingResult.rejectValue("username", "message.usernameExists");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }
        giphyUserService.registerNewUser(form.getUsername(), form.getPassword());
        return "redirect:/login";
    }
}
