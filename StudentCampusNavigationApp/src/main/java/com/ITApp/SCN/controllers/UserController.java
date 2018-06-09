package com.ITApp.SCN.controllers;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	    
	    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json", consumes = {"application/json"})
		@ResponseBody
	    public String registration(@RequestBody UserModel userModel, BindingResult bindingResult) {
	    	
	    	userValidator.validate(userModel, bindingResult);
	    	
	    	 if (bindingResult.hasErrors()) {
	             return JSONObject.quote("Registration failed");
	         }
	    	userModelService.addUser(userModel);
	    	
	    	securityService.autologin(userModel.getUserName(), userModel.getUserPassword());
	    	
			return JSONObject.quote("Registration successful");
	    }
	    

		
}
