package com.example.sample;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping("/")
    public String input(LoginForm form) {
        return "login";
    }

    @PostMapping("/output")
    public String output(@Validated LoginForm form, BindingResult result) {
        if(result.hasErrors()) {
            return input(form);
        }
        return "finish";
    }
}
