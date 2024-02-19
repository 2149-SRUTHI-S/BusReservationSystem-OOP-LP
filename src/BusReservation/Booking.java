package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
	int booking_id;
	String passenger_name;
	int busNo;
	Date date;

	Booking() throws java.text.ParseException, ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter booking id: ");
		booking_id = sc.nextInt();
		System.out.println("Enter passenger name: ");
		passenger_name = sc.next();
		System.out.println("Enter bus number: ");
		busNo = sc.nextInt();
		System.out.println("Enter date: ");
		String inp_date = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		date = sdf.parse(inp_date);
	}

	public boolean isAvailable() throws SQLException {
		BusDAO bus = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = bus.getCapacity(busNo);
		int booked = bookingdao.getBookedCount(busNo, date);
		return booked < capacity;
	}
}
