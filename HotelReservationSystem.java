package com.capgemini.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author MAHI
 *
 */
public class HotelReservationSystem {
	private static final Logger LOG = LogManager.getLogger(HotelReservationSystem.class);
	static Scanner input = new Scanner(System.in);
	private static List<Hotel> hotelList = new ArrayList<>();

//usecase1//
	/**
	 * 
	 */

	public void addHotels() {
		do {
			LOG.info("Enter the hotel details");
			LOG.info("Enter the name of hotel");
			String name = input.nextLine();
			LOG.info("Enter the weekday regular rate");
			int weekdayRegularRate = Integer.parseInt(input.nextLine());
			LOG.info("Enter the weeekend regular rate");
			int weekendRegularRate = Integer.parseInt(input.nextLine());
			Hotel hotel = new Hotel(name, weekdayRegularRate, weekendRegularRate);
			hotelList.add(hotel);
			LOG.info("Enter 1 to add another hotel, else enter 0: ");
		} while (input.nextLine().equals("1"));
	}

	// usecase2//
	/**
	 * 
	 */

	private static void getCheapestHotel() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MM yyyy");
		LOG.info("Enter start date (dd MM yyyy): ");
		String startDateInput = input.nextLine();
		LOG.info("Enter end date (dd MM yyyy): ");
		String endDateInput = input.nextLine();
		LocalDate startDate = LocalDate.parse(startDateInput, dateFormat);
		LocalDate endDate = LocalDate.parse(endDateInput, dateFormat);
		int noOfDaysBetween = (int) ChronoUnit.DAYS.between(startDate, endDate);
		int minCost = hotelList.get(0).weekdayRegularRate;
		String cheapestHotelName = hotelList.get(0).name;
		for (int i = 1; i < hotelList.size(); i++)
			if (hotelList.get(i).weekdayRegularRate < minCost) {
				minCost = hotelList.get(i).weekdayRegularRate;
				cheapestHotelName = hotelList.get(i).name;
			}
		LOG.info(cheapestHotelName + ", Total Cost : " + minCost * noOfDaysBetween);
	}

	public static void main(String[] args) {
		HotelReservationSystem hotelReservation = new HotelReservationSystem();
		LOG.info("Welcome to Hotel Reservation Program");
		hotelReservation.addHotels();
		hotelReservation.hotelList.forEach(n -> LOG.info(n));
		hotelReservation.getCheapestHotel();
	}
}
