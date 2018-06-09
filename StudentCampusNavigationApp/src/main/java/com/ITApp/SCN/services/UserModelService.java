package com.ITApp.SCN.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.UserModel;
import com.ITApp.SCN.repository.UserModelRepository;

@Service
public class UserModelService {
	@Autowired
    private UserModelRepository userRepository;

    //public List<UserModel> getAll(){return userRepository.findAll();}

    public void addUser(UserModel user){

        userRepository.save(user);

    }

    public void updateUser(UserModel user,int id){
        //UserModel currentUser = userRepository.findById(id).get();
        /*currentUser.setUsername(user.getUsername());
        currentUser.setLastname(user.getLastname());
        currentUser.setEmail(user.getemail());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhone(user.getPhone());*/

        //userRepository.save(currentUser);
    	}

    public void removeUser(int id)
	{
		//userRepository.deleteById(id);
	}
}
