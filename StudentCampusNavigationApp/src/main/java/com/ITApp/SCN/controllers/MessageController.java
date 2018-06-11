package com.ITApp.SCN.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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

public class MessageController {
	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private MessageModelService messageModelService;
	
	@Autowired
	private ChatModelService chatModelService;
	
    @Autowired
    private SecurityService securityService;

	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"}) // IS CONSUMES CORRECT??
	@ResponseBody
    public String sendMessage(@RequestParam("chatName") String chatname, @RequestParam("message") String messageText) {
    	
    	UserModel userModel = userModelService.findByName(securityService.findLoggedInUsername());
    	ChatModel chatModel = chatModelService.findByName(chatname);
    	MessageModel messageModel = new MessageModel();
    	    	
    	messageModel.setMessageSender(userModel);
    	messageModel.setMessageChat(chatModel);
    	messageModel.setMessage(messageText);
    	messageModel.setMessageDate(new Date());
    	
    	if(chatModel == null) {
    		chatModel = new ChatModel();
    		chatModel.setChatName(chatname);
    		chatModelService.createChat(chatModel);
    		chatModelService.joinChat(chatModel, userModel);
    		userModelService.addUserToChat(userModel, chatModel);
    	}
    	messageModelService.sendMessageToChat(messageModel);

		return "Message sent successfully";
    }
}
