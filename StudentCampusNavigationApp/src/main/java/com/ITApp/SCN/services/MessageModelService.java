package com.ITApp.SCN.services;

import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.models.RoleModel;
import com.ITApp.SCN.models.UserModel;

public interface MessageModelService {
	public void sendMessageToChat(MessageModel message);
}