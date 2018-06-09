package com.ITApp.SCN.repository;

import com.ITApp.SCN.models.ChatModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "chats", path = "chats")
public interface ChatModelRepository extends JpaRepository<ChatModel, Long>{
	ChatModel findByName(String name);
}