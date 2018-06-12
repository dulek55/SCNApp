package com.ITApp.SCN.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Message")
public class MessageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @ManyToOne			// WHY HERE WITHOUT @Column??
    private UserModel sender;

    @ManyToOne
    @JoinColumn(name = "chat_messages")
    private ChatModel chat;

    @Column(name = "Message")
    private String message;

    @Column(name = "Date")
    private Date date;
    

    /*protected MessageModel(){

    }

    public MessageModel(UserModel sender, ChatModel chat, String message, long date){
        this.sender = sender;
        this.chat = chat;
        this.message = message;
        this.date = date;
    }*/

    public long getMessageId(){return id;}
    public void setMessageId(long id){this.id = id;}

    public UserModel getMessageSender(){return sender;}
    public void setMessageSender(UserModel sender){this.sender = sender;}

    public ChatModel getMessageChat(){return chat;}
    public void setMessageChat(ChatModel chat){this.chat = chat;}

    public Date getMessageDate(){return date;}
    public void setMessageDate(Date date){this.date = date;}

    public void setMessage(String message){this.message = message;}
    public String getMessage(){return message;}
}
