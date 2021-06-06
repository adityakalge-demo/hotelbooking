package com.project.hotelBooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private long bonusPoints;
	private long previousBonusPoints;
	
	
	
	public long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getBonusPoints() {
		return bonusPoints;
	}
	public void setBonusPoints(long bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
	public long getPreviousBonusPoints() {
		return previousBonusPoints;
	}
	public void setPreviousBonusPoints(long previousBonusPoints) {
		this.previousBonusPoints = previousBonusPoints;
	}
	
}
