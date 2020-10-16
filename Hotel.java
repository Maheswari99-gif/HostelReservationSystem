package com.capgemini.hotelreservation;

public class Hotel {
	public String name;
	public int weekdayRegularRate;
	public int weekendRegularRate;
	public long totalRate;

	public Hotel(String name, int weekdayRegularRate, int weekendRegularRate) {
		super();
		this.name = name;
		this.weekdayRegularRate = weekdayRegularRate;
		this.weekendRegularRate = weekendRegularRate;
		this.totalRate = totalRate;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getWeekdayRegularRate() {
		return weekdayRegularRate;
	}

	public void setWeekdayRegularRate(int weekdayRegularRate) {
		this.weekdayRegularRate = weekdayRegularRate;
	}

	public int getWeekendRegularRate() {
		return weekendRegularRate;
	}

	public void setWeekendRegularCustomerRate(int weekendRegularRate) {
		this.weekendRegularRate = weekendRegularRate;
	}

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long totalRate) {
		this.totalRate = totalRate;
	}

	@Override
	public String toString() {
		return "\nHotelName=  " + name + "\nWeekdayRate =  $" + weekdayRegularRate + "\nWeekendRate = $"
				+ weekendRegularRate + "\nTotalRate= " + totalRate;
	}

}
