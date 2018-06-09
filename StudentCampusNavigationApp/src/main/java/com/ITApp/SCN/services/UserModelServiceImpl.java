package com.ITApp.SCN.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.repository.ChatModelRepository;
import com.ITApp.SCN.repository.RoleModelRepository;
import com.ITApp.SCN.repository.UserModelRepository;

@Service
public class UserModelServiceImpl implements UserModelService{

    @Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private RoleModelRepository roleModelRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(UserModel user) {
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		// TODO: If we have admin and normal user we should not grant all permissions on account creation
		user.setRoles(new HashSet<>(roleModelRepository.findAll()));
		userModelRepository.save(user);
	}

	@Override
	public void updateUser(UserModel user, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel findByName(String name) {
		return userModelRepository.findByName(name);
	}

	@Override
	public void addUserToChat(UserModel user, ChatModel chat) {
		user.addChat(chat);
	}
}
