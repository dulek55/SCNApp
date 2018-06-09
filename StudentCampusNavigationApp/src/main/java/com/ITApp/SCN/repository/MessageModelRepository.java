package com.ITApp.SCN.repository;

import com.ITApp.SCN.models.MessageModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageModelRepository extends JpaRepository<MessageModel, Long> {

}