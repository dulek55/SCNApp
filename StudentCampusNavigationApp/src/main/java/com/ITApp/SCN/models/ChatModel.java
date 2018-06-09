package com.ITApp.SCN.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
    @ManyToMany(mappedBy = "chats")
    @Column(name = "users")
	private Set<UserModel> users;
    
    @ManyToMany(mappedBy = "chats")
    @Column(name = "messages")
    private Set<MessageModel> messages;
	
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
	
	public Set<UserModel> getUsers(){
		return this.users;
	}
	
	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}
	
	public void addUser(UserModel user) {
		this.users.add(user);
	}
	
	public void removeUser(UserModel user) {
		this.users.remove(user);
	}
	
	public Set<MessageModel> getMessages(){
		return this.messages;
	}
	
	public void setMessages(Set<MessageModel> messages) {
		this.messages = messages;
	}
	
	public void addMessage(MessageModel message) {
		this.messages.add(message);
	}
	
}
