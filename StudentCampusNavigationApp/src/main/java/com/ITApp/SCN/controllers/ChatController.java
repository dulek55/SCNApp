package com.ITApp.SCN.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.services.ChatModelService;
import com.ITApp.SCN.services.MessageModelService;
import com.ITApp.SCN.services.SecurityService;
import com.ITApp.SCN.services.UserModelService;

@Controller
public class ChatController {

	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private MessageModelService messageModelService;
	
	@Autowired
	private ChatModelService chatModelService;
	
    @Autowired
    private SecurityService securityService;

	
	@RequestMapping(value = "/joinChat", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
	@ResponseBody
    public String joinChat(@RequestParam("chatname") String chatname) {
    	
    	UserModel userModel = userModelService.findByName(securityService.findLoggedInUsername());
    	ChatModel chatModel = chatModelService.findByName(chatname);
    	
    	// TO DO: check if user can join the chat
    	
    	if(chatModel != null) {
    		chatModelService.joinChat(chatModel, userModel);
    	}else{
    		chatModel = new ChatModel();
    		chatModel.setChatName(chatname);
    		chatModelService.createChat(chatModel);
        	chatModelService.joinChat(chatModel, userModel);
    	}
    	userModelService.addUserToChat(userModel, chatModel);

    	
		return "Joined chat successfully";
    }
	
	@RequestMapping(value = "/getUserChats", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public HashMap<String, Object> getUserChats() {
		UserModel userModel = userModelService.findByName(securityService.findLoggedInUsername());
    	HashMap<String, Object> map = new HashMap<>();
    	for (ChatModel chatModel : userModel.getChats()) {
    		map.put(String.valueOf(chatModel.getChatId()),chatModel.getChatName());
    	}
    	return map;
	}
	
	@RequestMapping(value = "/getChatsMessages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public HashMap<String, Object> getChatsMessages(@RequestParam("chatname") String chatname) {
		ChatModel chatModel = chatModelService.findByName(chatname);
    	HashMap<String, Object> map = new HashMap<>();
    	for (MessageModel messageModel : chatModel.getMessages()) {
    		map.put(String.valueOf(messageModel.getMessageId()),messageModel.getMessage());
    	}
    	return map;
	}
}
