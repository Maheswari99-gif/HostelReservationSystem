package com.capgemini.hotelreservation;

public class Hotel {
	private String name;
	private int regularRate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegularRate() {
		return regularRate;
	}
	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}
	
	public Hotel(String name, int regularRate) {
		setName(name);
		setRegularRate(regularRate);
	}
	
	@Override
	public String toString() {
		return "\nHotel \n[ Name=  " + name + "\nRegular Rate=  $" + regularRate + " ]";
	}

}
