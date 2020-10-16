package com.capgemini.hotelreservation;

public class Hotel {
	public String name;
	public int weekdayRegularRate;
	public int weekendRegularRate;

	public Hotel(String name, int weekdayRegularRate, int weekendRegularRate) {
		super();
		this.name = name;
		this.weekdayRegularRate = weekdayRegularRate;
		this.weekendRegularRate = weekendRegularRate;
	}

	@Override
	public String toString() {
		return "\nHotelName=  " + name + "\nWeekdayRate =  $" + weekdayRegularRate + "\nWeekendRate = $" + weekendRegularRate;
	}

}
