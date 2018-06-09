package com.ITApp.SCN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
