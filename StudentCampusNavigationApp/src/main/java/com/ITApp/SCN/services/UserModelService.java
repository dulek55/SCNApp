package com.ITApp.SCN.services;

import java.util.List;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.UserModel;

public interface UserModelService {

    public List<UserModel> getAll();

    public void addUser(UserModel user);
    public void updateUser(UserModel user, long id);
    public void removeUser(long id);
    public UserModel findByName(String name);
    public void addUserToChat(UserModel user, ChatModel chat);
    public void removeUserFromChat(UserModel user, ChatModel chat);
}
