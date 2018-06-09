package com.ITApp.SCN.models;

import javax.persistence.*;

@Entity
@Table(name = "Buildings")
public class BuildingsModel {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "X")
    private float x;

    @Column(name = "Y")
    private float y;

    @Column(name = "Name")
    private String name;

    public long getBuildingId(){return id;}
    public void setBuildingId(int id){this.id = id;}

    public float getBuildingsX(){return x;}
    public void setBuildingsX(float x){this.x = x;}

    public float getBuildingsY(){return y;}
    public void setBuildingsY(float y){this.y = y;}

    public String getBuildingsName(){return name;}
    public void setBuildingName(String name){this.name = name;}

}