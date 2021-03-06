package com.ITApp.SCN.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.repository.ChatModelRepository;
import com.ITApp.SCN.repository.MessageModelRepository;
import com.ITApp.SCN.repository.UserModelRepository;

@Service
public class ChatModelServiceImpl implements ChatModelService{
	
	@Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private MessageModelRepository messageModelRepository;
    @Autowired
    private ChatModelRepository chatModelRepository;
    
    
	@Override
	public void joinChat(ChatModel chat, UserModel user) {
		chat.addUser(user);
		chatModelRepository.save(chat);
	}
	@Override
	public void leaveChat(ChatModel chat, UserModel user) {
		chat.removeUser(user);
		if(chat.getUsers().isEmpty()) {
			chatModelRepository.delete(chat);
		}
		chatModelRepository.save(chat);
	}
	@Override
	public ChatModel findByName(String name) {
		return chatModelRepository.findByName(name);
	}
	@Override
	public void createChat(ChatModel chat) {
		chat.setUsers(new HashSet<UserModel>());
		chat.setMessages(new HashSet<MessageModel>());
		chatModelRepository.save(chat);
	}
	@Override
	public void addMessage(ChatModel chat, MessageModel message) {
		chat.addMessage(message);
		chatModelRepository.save(chat);
	}

}
