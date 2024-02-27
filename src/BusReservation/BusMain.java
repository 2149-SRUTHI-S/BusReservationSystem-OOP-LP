package BusReservation;

import java.sql.*;  
import java.util.*; 

public class BusMain {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		BusDAO bus = new BusDAO();
		try {
			bus.displayBusInfo();
			Scanner sc = new Scanner(System.in);
			int userOpt = 1;
			while (userOpt != 3) {
				System.out.println("Enter 1 to Book");
				System.out.println("Enter 2 to Cancel");
				System.out.println("Enter 3 to Exit");
				userOpt = sc.nextInt();

				if (userOpt == 1) {
					Booking booking = new Booking();
					if (booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed !!");
					} else
						System.out.println("Sorry! Bus is full. Try another bus or date.");
				} else if (userOpt == 2) {
					Cancelling cancelling = new Cancelling();
					CancellingDAO cancellingdao = new CancellingDAO();
					cancellingdao.cancelBooking(cancelling);
					System.out.println("Your booking is cancelled !!");
				}
				System.out.println("---------------------------------");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
