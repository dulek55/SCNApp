package com.ITApp.SCN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.services.ChatModelService;
import com.ITApp.SCN.services.MessageModelService;
import com.ITApp.SCN.services.UserModelService;

@Controller
public class ChatController {

	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private MessageModelService messageModelService;
	
	@Autowired
	private ChatModelService chatModelService;
	
	@RequestMapping(value = "/joinChat", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
	@ResponseBody
    public String joinChat(@RequestParam("username") String username, @RequestParam("chatName") String chatname) {
    	
    	UserModel userModel = new UserModel();
    	userModel = userModelService.findByName(username);
    	ChatModel chatModel = new ChatModel();
    	chatModel = chatModelService.findByName(chatname);
    	
    	userModelService.addUserToChat(userModel, chatModel);
    	
		return "Joined chat successfully";
    }
}
