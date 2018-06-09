package com.ITApp.SCN.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.ChatModel;
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
	public void joinChannel(ChatModel chat, UserModel user) {
		chat.addUser(user);
	}
	@Override
	public void leaveChannel(ChatModel chat, UserModel user) {
		chat.removeUser(user);
		if(chat.getUsers().isEmpty()) {
			chatModelRepository.delete(chat);
		}
	}
	@Override
	public ChatModel findByName(String name) {
		return chatModelRepository.findByName(name);
	}
	@Override
	public void createChannel(String name) {
		ChatModel chatModel = new ChatModel();
		chatModel.setChatName(name);
		chatModelRepository.save(chatModel);
	}

}
