package com.ITApp.SCN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ITApp.SCN.models.RoomModel;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomModelRepository extends JpaRepository<RoomModel, Long>{

}