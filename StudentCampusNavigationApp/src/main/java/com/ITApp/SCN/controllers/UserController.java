package com.ITApp.SCN.controllers;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.repository.UserModelRepository;
import com.ITApp.SCN.services.SecurityService;
import com.ITApp.SCN.services.UserModelService;
import com.ITApp.SCN.validators.UserModelValidator;

@Controller
public class UserController {

		@Autowired
		private UserModelService userModelService;

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    private UserModelValidator userValidator;
	    
	    @RequestMapping(value = "/registration", method = RequestMethod.GET, produces = "application/json")
	    @ResponseBody
	    public HashMap<String, Object> registration() {
	    	HashMap<String, Object> map = new HashMap<>();
	    	map.put("messege", "POST /registration to register a new account");
	    	map.put("error", "1");
	    	return map;
	    }
	    
	    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
		@ResponseBody
	    public String registration(@RequestParam("username") String username, @RequestParam("password") String password) {
	    	
	    	UserModel userModel = new UserModel();
	    	username.trim();
	    	password.trim();
	    	userModel.setUserName(username);
	    	userModel.setUserPassword(password);
	    	
	        if (userModel.getUserName().length() < 2 || userModel.getUserName().length() > 32 || userModel.getUserName().isEmpty()) {
	        	return "Registration failed, incorrect username";
	        }
	        if (userModelService.findByName(userModel.getUserName()) != null) {
	           return "Registration failed, user already registered";
	        }

	        if (userModel.getUserPassword().length() < 2 || userModel.getUserPassword().length() > 32 || userModel.getUserPassword().isEmpty()) {
	            return "Registration failed, incorrect password";
	        }
	    	userModelService.addUser(userModel);
	    	
	    	securityService.autologin(userModel.getUserName(), userModel.getUserPassword());
	    	
			return "Registration successful";
	    }
	    
	    
	    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	    @ResponseBody
	    public String welcome() {
	        return securityService.findLoggedInUsername();
	    }
	    
	    @RequestMapping(value = {"/loginFailed"}, method = RequestMethod.GET)
	    @ResponseBody
	    public String loginFailed() {
	        return "Login Failed";
	    }
	    @RequestMapping(value = {"/loginSuccess"}, method = RequestMethod.GET)
	    @ResponseBody
	    public String loginSuccess() {
	        return "Login Success";
	    }
	    
		
}
