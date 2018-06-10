package com.ITApp.SCN.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Class")
public class ClassModel {
	
	@Id
    @Column(name = "ClassID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
	
	@Column(name = "SubjectName")
    private String name;
	
	@Column(name = "Chat")
	private ChatModel chat;
	
	@Column(name = "Day")
	private int day;
	
	@Column(name = "Start time")
	private int time;
	
	@Column(name = "Room")
	private RoomModel room;
	
	
	
	public long getClassID() {
		return id;
	}
	
	public String getClassName() {
		return name;
	}
	public void setClassName(String name) {
		this.name = name;
	}
	
	public ChatModel getChat() {
		return chat;
	}
	public void setChat(ChatModel chat) {
		this.chat = chat;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public RoomModel getRoom() {
		return room;
	}
	public void setRoom(RoomModel room) {
		this.room = room;
	}
}
