package com.ITApp.SCN.services;

import java.util.List;
import com.ITApp.SCN.models.UserModel;

public interface UserModelService {

    public List<UserModel> getAll();

    public void addUser(UserModel user);
    public void updateUser(UserModel user,int id);
    public void removeUser(int id);
    public UserModel findByName(String name);
}
