package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class FrontController {
	
	@Autowired
	public UserService userService;
	
	// 1 . http://localhost:8080/
	 @GetMapping("/") // Handle requests to the home page
	    public String showHomePage() {
	        return "home";  // This will load home.html from templates folder
	    }
	 

	 
	  // 2. To display login page
	 @GetMapping("/log")
	 public String showLoginPage() {
	     return "login";  // Loads login.html
	 }
	 
	 // 3. To display register page
	 @GetMapping("/register")
	    public String showRegisterPage() {
	        return "register";  // Load register.html
	    }
	 
	 //4. First you have to register which is post mapping
	 //When you will pass the values from register.html it will take the parameters username and password ,
	 //and bind this with the variables as username and password which is of String type
	    @PostMapping("/register")
	    public String registerUser(@RequestParam("username") String username,
	                               @RequestParam("password") String password,
	                               Model model) {
	        
	    	// Model/entity class object and in constructor we have passed the values 
	        User user = new User(username, password);
	        String result = userService.registerUser(user);

	        if (result.equals("User registered successfully!")) {
	            return "redirect:/log";  // Redirect to login page
	        } else {
	            model.addAttribute("message", result);
	            return "register";  // Stay on register page if username exists
	        }
	    }
	 
	 
	 
}