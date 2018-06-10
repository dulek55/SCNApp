package com.ITApp.SCN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ITApp.SCN.models.ClassModel;

@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassModelRepository extends JpaRepository<ClassModel, Long>{

}
