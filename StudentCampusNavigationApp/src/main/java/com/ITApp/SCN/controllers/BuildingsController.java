package com.ITApp.SCN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ITApp.SCN.models.BuildingsModel;
import com.ITApp.SCN.services.BuildingsModelService;

@Controller
public class BuildingsController {
	
	@Autowired
	private BuildingsModelService buildingsModelService;
	
	
	@RequestMapping(value = "/addBuilding", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
	@ResponseBody
    public String addBuilding(@RequestParam("buildingname") String buildingname) {
		
		BuildingsModel buildingsModel = new BuildingsModel();
		
		buildingsModel.setBuildingName(buildingname);
		buildingsModelService.createBuilding(buildingsModel);
    	
		return "Building added successfully";
    }
	
}
