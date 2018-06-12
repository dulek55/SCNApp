package com.ITApp.SCN.services;

import java.util.Set;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.models.UserModel;

public interface ChatModelService {
	
	public void createChat(ChatModel chat);
	public void joinChat(ChatModel chat, UserModel user);
	public void leaveChat(ChatModel chat, UserModel user);
	public ChatModel findByName(String name);
	public void addMessage(ChatModel chat, MessageModel message);

}
