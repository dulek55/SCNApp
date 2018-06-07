package com.ITApp.SCN.repository;

import com.ITApp.SCN.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserModelRepository extends CrudRepository<UserModel, Long> {

}