package com.ITApp.SCN.repository;

import com.ITApp.SCN.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserModelRepository extends JpaRepository<UserModel, Long> {
	UserModel findByName(String name);
}