package com.capgemini.hotelreservation;

public class Hotel {
	public String name;
	public int weekdayRegularRate;
	public int weekendRegularRate;
	public int weekdayRewardsRate;
	public int weekendRewardsRate;
	public long totalRate;
	private int rating;

	public Hotel(String name, int weekdayRegularRate, int weekendRegularRate, int rating, int weekdayRewardsRate, int weekendRewardsRate) {
		super();
		this.name = name;
		this.weekdayRegularRate = weekdayRegularRate;
		this.weekendRegularRate = weekendRegularRate;
		this.rating = rating;
		this.weekdayRewardsRate = weekdayRewardsRate;
		this.weekendRewardsRate = weekendRewardsRate;
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

	public void setWeekendRegularRate(int weekendRegularRate) {
		this.weekendRegularRate = weekendRegularRate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getWeekdayRewardsRate() {
		return weekdayRewardsRate;
	}

	public void setWeekdayRewardsRate(int weekdayRewardsRate) {
		this.weekdayRewardsRate = weekdayRewardsRate;
	}

	public int getWeekendRewardsRate() {
		return weekendRewardsRate;
	}

	public void setWeekendRewardsRate(int weekendRewardsRate) {
		this.weekendRewardsRate = weekendRewardsRate;
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
				+ weekendRegularRate + "\nRating=" + rating + "\nTotalRate= " + totalRate;
	}

}
