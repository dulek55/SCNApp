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
    private long Id;

    @ManyToOne
    @NaturalId
    private UserModel Sender;

    @ManyToOne
    @NaturalId
    private UserModel Receiver;

    @Column(name = "Message")
    private String Message;

    @Column(name = "Date")
    private long Date;

    protected MessageModel(){

    }

    public MessageModel(UserModel sender, UserModel receiver, String message, long date){
        this.Sender = sender;
        this.Receiver = receiver;
        this.Message = message;
        this.Date = date;
    }

    public long getMessageId(){return Id;}
    public void setMessageId(long id){this.Id = Id;}

    public UserModel getMessageSender(){return Sender;}
    public void setMessageSender(UserModel Sender){this.Sender = Sender;}

    public UserModel getMessageReceiver(){return Receiver;}
    public void setMessageReceiver(UserModel Receiver){this.Receiver = Receiver;}

    public long getMessageDate(){return Date;}
    public void setMessageDate(long Date){this.Date = Date;}

    public void setMessage(String message){Message = message;}
    public String getMessage(){return Message;}
}
