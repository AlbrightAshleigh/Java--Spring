package com.ashleigh.dashboard.controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashleigh.dashboard.models.User;
import com.ashleigh.dashboard.services.UserService;
import com.ashleigh.dashboard.validator.UserValidator;

@Controller
public class UserController {
    private UserService userService;
    
    private UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
    	this.userService = userService;
    	this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    
    userValidator.validate(user,result);
    
    if (result.hasErrors()) {
        return "registrationPage";
    }
    ArrayList<User> users = userService.findAll();
    if(users.size()<1){
    	userService.saveUserWithAdminRole(user);
    } else{
    	userService.saveWithUserRole(user);
    }
    return "redirect:/login";
    }

    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model){
    	String username = principal.getName();
    	model.addAttribute("currentUser", userService.findByUsername(username));
    	return "adminPage";
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
        return "loginPage";
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        
        return "homePage";
    }

}