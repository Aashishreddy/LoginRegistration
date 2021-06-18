package com.example.loginregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@Controller
public class AppController {

    @Autowired
    private UserRepository repository;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
            model.addAttribute("user",new User());
            return "signup_form"; //create a HTML using this name
    }

    //handler method
    @PostMapping("/process_register")
    public String processRegistration(User user){
        repository.save(user);
        return "register_success";
    }

    @GetMapping("/loginForm")
    public String loginForm(Model model){
        model.addAttribute("user", new User());
        return "loginForm";
    }

    @PostMapping("/loginCheck")
    public String loginForm(User user){
        String u1   = user.getEmail();
        String p1 = user.getPassword();

        System.out.println(u1+ " "+p1);
        return "login_success";
    }


}
