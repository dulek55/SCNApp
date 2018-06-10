package com.ITApp.SCN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.RoomModel;
import com.ITApp.SCN.repository.RoomModelRepository;

@Service
public class RoomModelServiceImpl implements RoomModelService {
	@Autowired
	private RoomModelRepository roomModelRepository;
	
	@Override
	public void createRoom(RoomModel room) {
		roomModelRepository.save(room);
	}
}
