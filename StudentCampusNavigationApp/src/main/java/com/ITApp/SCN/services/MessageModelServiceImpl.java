package com.ITApp.SCN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.models.RoleModel;
import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.repository.MessageModelRepository;
import com.ITApp.SCN.repository.RoleModelRepository;
import com.ITApp.SCN.repository.UserModelRepository;

@Service
public class MessageModelServiceImpl implements MessageModelService {
	
	@Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private RoleModelRepository roleModelRepository;
    @Autowired
    private MessageModelRepository messageModelRepository;

	@Override
	public void addMessageToUser(UserModel sender, UserModel receiver, MessageModel message) {
		
	}

	@Override
	public void addMessageToRole(UserModel sender, RoleModel receiverRole, MessageModel message) {
		// TODO Auto-generated method stub
		
	}

}
