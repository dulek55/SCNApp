package com.ITApp.SCN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ITApp.SCN.models.BuildingsModel;
import com.ITApp.SCN.models.RoomModel;
import com.ITApp.SCN.services.BuildingsModelService;
import com.ITApp.SCN.services.RoomModelServiceImpl;

@Controller
public class RoomController {
	
	@Autowired
	private RoomModelServiceImpl roomModelService;
	
	@Autowired 
	private BuildingsModelService buildingsModelService;
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
	@ResponseBody
    public String addBuilding(@RequestParam("roomnumber") String roomnumber, @RequestParam("buildingsname") String buildingsname) {
		
		RoomModel roomModel = new RoomModel();
		BuildingsModel buildingsModel = buildingsModelService.findByName(buildingsname);
		
		roomModel.setRoomNumber(roomnumber);
		
		if(buildingsModel == null) {
			buildingsModel = new BuildingsModel();
			
			buildingsModel.setBuildingName(buildingsname);
			buildingsModelService.createBuilding(buildingsModel);
		}
		
		roomModel.setBuilding(buildingsModel);
		
		roomModelService.createRoom(roomModel);
    	
		return "Room added successfully";
    }
}
