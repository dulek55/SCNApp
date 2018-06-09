package com.ITApp.SCN.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Message")
public class MessageModel implements Serializable {

    @Id
    @Column(name = "MessageID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @ManyToOne
    private UserModel sender;

    @ManyToOne
    private ChatModel receiver;

    @Column(name = "Message")
    private String message;

    @Column(name = "Date")
    private long date;
    
    @ManyToMany
    @JoinTable(name = "message_chat", joinColumns = @JoinColumn(name = "message_id"), inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private Set<ChatModel> chats;

    protected MessageModel(){

    }

    public MessageModel(UserModel sender, ChatModel receiver, String message, long date){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
    }

    public long getMessageId(){return id;}
    public void setMessageId(long id){this.id = id;}

    public UserModel getMessageSender(){return sender;}
    public void setMessageSender(UserModel sender){this.sender = sender;}

    public ChatModel getMessageReceiver(){return receiver;}
    public void setMessageReceiver(ChatModel receiver){this.receiver = receiver;}

    public long getMessageDate(){return date;}
    public void setMessageDate(long date){this.date = date;}

    public void setMessage(String message){this.message = message;}
    public String getMessage(){return message;}
}
