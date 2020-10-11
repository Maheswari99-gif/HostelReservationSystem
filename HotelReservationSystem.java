package com.capgemini.hotelreservation;

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
public class HotelReservationSystem 
{
	private static final Logger LOG = LogManager.getLogger(HotelReservationSystem.class);
	static Scanner input=new Scanner(System.in);
	public List<Hotel> hotelList;
	
	public HotelReservationSystem() {
		this.hotelList=new ArrayList<Hotel>();
	}
	/**
	 * 
	 */
	
	public void addHotels() {
		do {
			LOG.info("Enter the hotel details");
			LOG.info("Enter the name of hotel");
			String name = input.nextLine();
			LOG.info("Enter the regular rate");
			int regularRate = Integer.parseInt(input.nextLine());
			Hotel hotel = new Hotel(name, regularRate);
			hotelList.add(hotel);
			LOG.info("Enter 1 to add another hotel, else enter 0: ");
		}while(input.nextLine().equals("1"));
	}
	
	
	
    public static void main( String[] args )
    {
    	HotelReservationSystem hotelReservation=new HotelReservationSystem();
    	LOG.info("Welcome to Hotel Reservation Program");
		hotelReservation.addHotels();
		hotelReservation.hotelList.forEach(n->LOG.info(n));
    }
}