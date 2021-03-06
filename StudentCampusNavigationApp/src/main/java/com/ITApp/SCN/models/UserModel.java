package com.ITApp.SCN.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @Column(name = "UserID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @Column(name = "password")
    private String password;

    @Column(name = "Name")
    private String name;
    
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;
    
    @ManyToMany
    @JoinTable(name = "user_chat", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private Set<ChatModel> chats;

    
    public long getUserId(){return id;}
    public void setUserId(long id){this.id = id;}

    public String getUserPassword(){return password;}
    public void setUserPassword(String password){this.password = password;}

    public String getUserName(){return name;}
    public void setUserName(String name){this.name = name;}
    
    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
    
    public Set<ChatModel> getChats() {
    	return chats;
    }
    public void setChats(Set<ChatModel> chats) {
    	this.chats = chats;
    }
    public void addChat(ChatModel chat) {
    	chats.add(chat);
    }
    public void removeChat(ChatModel chat) {
    	chats.remove(chat);
    }
}