package com.ITApp.SCN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ITApp.SCN.repository.UserModelRepository;

@Controller
@RequestMapping(path="users")
public class UserController {

		@Autowired
		private UserModelRepository userModelRepository;
		
		
		
}
