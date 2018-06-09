package com.ITApp.SCN.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Chat")
public class ChatModel {
	
	@Id
    @Column(name = "ChatID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
	
	@Column(name = "ChatName")
    private String name;
	
	public long getChatId() {
		return id;
	}
	public void setChatID(long id) {
		this.id = id;
	}
	
	public String getChatName() {
		return name;
	}
	public void setChatName(String name) {
		this.name= name;
	}
}
