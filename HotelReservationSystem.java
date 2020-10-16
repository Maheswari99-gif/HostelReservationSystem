package com.capgemini.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.*;
import java.time.temporal.*;
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
	// usecase3//
	// usecase5//
	/**
	 * 
	 */

	public void addHotels() {
		do {
			LOG.info("Enter the hotel details");
			LOG.info("Enter the name of hotel");
			String name = input.nextLine();
			LOG.info("Enter the rating");
			int rating = Integer.parseInt(input.nextLine());
			LOG.info("Enter the weekday regular rate");
			int weekdayRegularRate = Integer.parseInt(input.nextLine());
			LOG.info("Enter the weeekend regular rate");
			int weekendRegularRate = Integer.parseInt(input.nextLine());
			LOG.info("Enter the weekday rewards rate");
			int weekdayRewardsRate = Integer.parseInt(input.nextLine());
			LOG.info("Enter the weeekend rewards rate");
			int weekendRewardsRate = Integer.parseInt(input.nextLine());
			Hotel hotel = new Hotel(name, weekdayRegularRate, weekendRegularRate, rating, weekdayRewardsRate,
					weekendRewardsRate);
			hotelList.add(hotel);
			LOG.info("Enter 1 to add another hotel, else enter 0: ");
		} while (input.nextLine().equals("1"));
	}

	// usecase2//
	/**
	 * 
	 */
	//usecase12,11//

	private void getCheapestbestRatedHotelOrbestRated() {
		// String DayOfWeek;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MM yyyy");
		LOG.info("Enter start date (dd MM yyyy): ");
		String startDateInput = input.nextLine();
		LOG.info("Enter end date (dd MM yyyy): ");
		String endDateInput = input.nextLine();
		LocalDate startDate = LocalDate.parse(startDateInput, dateFormat);
		LocalDate endDate = LocalDate.parse(endDateInput, dateFormat);
		int noOfDaysBetween = (int) ChronoUnit.DAYS.between(startDate, endDate);
		DayOfWeek startW = startDate.getDayOfWeek();
		DayOfWeek endW = endDate.getDayOfWeek();
		long daysWithoutWeekends = noOfDaysBetween - 2 * ((noOfDaysBetween + startW.getValue()) / 7);
		long calcWeekDays = daysWithoutWeekends + (startW.getValue() == 1 ? 1 : 0) + (endW.getValue() == 1 ? 1 : 0);
		long calcWeekends = noOfDaysBetween - (calcWeekDays) + 1;
		LOG.info("NoOfWeekdays" + calcWeekDays + "NoOfWeekends" + calcWeekends);
		LOG.info("\n1.Rewards\n2.Regular");
		int choice = Integer.parseInt(input.nextLine());
		if (choice == 1) {
			for (Hotel hotel : hotelList) {
				long totalRate = calcWeekDays * hotel.getWeekdayRewardsRate()
						+ calcWeekDays * hotel.getWeekendRewardsRate();
				hotel.setTotalRate(totalRate);
				LOG.info("Total Rate=" + totalRate);
			}
		} else {
			for (Hotel hotel : hotelList) {
				long totalRate = calcWeekDays * hotel.getWeekdayRegularRate()
						+ calcWeekDays * hotel.getWeekendRegularRate();
				hotel.setTotalRate(totalRate);
				LOG.info("Total Rate=" + totalRate);
			}
		}
		LOG.info("\n1.Find cheapest best rated hotel\n2.Find best rated hotel\nEnter your choice 1 or 2 : ");
		int option = Integer.parseInt(input.nextLine());
		if (option == 1) {
			List<Hotel> sortedList = hotelList.stream().sorted(Comparator.comparing(Hotel::getTotalRate))
					.collect(Collectors.toList());

			Hotel cheapestHotel = sortedList.get(0);
			long cheapestRate = sortedList.get(0).getTotalRate();
			for (Hotel hotel : sortedList) {
				if (hotel.getTotalRate() <= cheapestRate) {
					if (hotel.getRating() > cheapestHotel.getRating())
						cheapestHotel = hotel;
				} else
					break;
			}
			LOG.info(cheapestHotel.getname() + ", Total rates : $" + cheapestHotel.getTotalRate() + " With Rating : "
					+ cheapestHotel.getRating());
		} else {
			List<Hotel> sortedList = hotelList.stream().sorted(Comparator.comparing(Hotel::getRating).reversed())
					.collect(Collectors.toList());
			Hotel bestRatedHotel = sortedList.get(0);
			long bestRate = sortedList.get(0).getRating();
			LOG.info(bestRatedHotel.getname() + " With Rating : " + bestRatedHotel.getRating());

		}

	}
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		HotelReservationSystem hotelReservation = new HotelReservationSystem();
		LOG.info("Welcome to Hotel Reservation Program");
		hotelReservation.addHotel("Lakewood", 110, 90, 80, 80, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 110, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 100, 40, 5);
		hotelReservation.hotelList.forEach(n -> LOG.info(n));
		hotelReservation.getCheapestbestRatedHotelOrbestRated();
	}
}
