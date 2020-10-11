package com.capgemini.hotelreservation;

public class Hotel {
	public String name;
	public int regularRate;
	
	
	public Hotel(String name, int regularRate) {
		super();
		this.name = name;
		this.regularRate = regularRate;
	}
	
	@Override
	public String toString() {
		return "\nHotel \n[ Name=  " + name + "\nRegular Rate=  $" + regularRate + " ]";
	}

}
