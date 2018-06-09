package com.ITApp.SCN.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

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
    private UserModel receiver;

    @Column(name = "Message")
    private String message;

    @Column(name = "Date")
    private long date;

    protected MessageModel(){

    }

    public MessageModel(UserModel sender, UserModel receiver, String message, long date){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
    }

    public long getMessageId(){return id;}
    public void setMessageId(long id){this.id = id;}

    public UserModel getMessageSender(){return sender;}
    public void setMessageSender(UserModel sender){this.sender = sender;}

    public UserModel getMessageReceiver(){return receiver;}
    public void setMessageReceiver(UserModel receiver){this.receiver = receiver;}

    public long getMessageDate(){return date;}
    public void setMessageDate(long date){this.date = date;}

    public void setMessage(String message){this.message = message;}
    public String getMessage(){return message;}
}
