package com.ITApp.SCN.services;

import java.util.Set;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.models.UserModel;

public interface ChatModelService {
	
	public void createChannel(String name);
	public void joinChannel(ChatModel chat, UserModel user);
	public void leaveChannel(ChatModel chat, UserModel user);
	public ChatModel findByName(String name);

}
