package com.ITApp.SCN.repository;

import com.ITApp.SCN.models.BuildingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buildings", path = "buildings")
public interface BuildingsModelRepository extends JpaRepository<BuildingsModel, Long>{
	BuildingsModel findByName(String name);
}