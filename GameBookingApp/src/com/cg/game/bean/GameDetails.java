package com.cg.game.bean;

import java.sql.Date;

public class GameDetails 
{
	private String gameId ;
	private String gameName ;
	private String location ;
	private Date gameDate ;
	private int avSeats ;
	private double priceTicket ;
	
	public GameDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameDetails(String gameId, String gameName, String location,
			Date gameDate, int avSeats, double priceTicket) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.location = location;
		this.gameDate = gameDate;
		this.avSeats = avSeats;
		this.priceTicket = priceTicket;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public int getAvSeats() {
		return avSeats;
	}

	public void setAvSeats(int avSeats) {
		this.avSeats = avSeats;
	}

	public double getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(double priceTicket) {
		this.priceTicket = priceTicket;
	}
	
}
