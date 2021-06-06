package com.project.hotelBooking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roomId;
	private String roomType;
	private long roomRate;
	private String roomStatus;

	

	public Room() {
		super();
	}

	public Room(String roomType, long roomRate,String roomStatus) {
		super();
		this.roomStatus=roomStatus;
		this.roomType = roomType;
		this.roomRate = roomRate;
	}

	public long getRoomId() {
		return roomId;
	}
	
	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public long getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(long roomRate) {
		this.roomRate = roomRate;
	}


}
