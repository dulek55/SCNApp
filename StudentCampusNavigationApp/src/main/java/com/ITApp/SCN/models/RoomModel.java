package com.ITApp.SCN.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rooms")
public class RoomModel {
	
	@Id
    @Column(name = "RoomID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
	
	@ManyToOne
	private BuildingsModel building;
	
	@Column(name = "RoomNumber")
	private String roomNumber;
	
	
	
	public long getId() {
		return id;
	}
	
	public BuildingsModel getBuilding() {
		return building;
	}
	public void setBuilding(BuildingsModel building) {
		this.building = building;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
