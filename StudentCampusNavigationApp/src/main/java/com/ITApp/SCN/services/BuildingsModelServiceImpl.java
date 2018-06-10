package com.ITApp.SCN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.BuildingsModel;
import com.ITApp.SCN.models.ChatModel;
import com.ITApp.SCN.repository.BuildingsModelRepository;

@Service
public class BuildingsModelServiceImpl implements BuildingsModelService {
	
	@Autowired
	private BuildingsModelRepository buildingsModelRepository;

	@Override
	public void createBuilding(BuildingsModel building) {
		buildingsModelRepository.save(building);
	}

	@Override
	public BuildingsModel findByName(String name) {
		return buildingsModelRepository.findByName(name);
	}
}
