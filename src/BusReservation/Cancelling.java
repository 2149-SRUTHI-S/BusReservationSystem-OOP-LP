package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cancelling {
	int booked_id;

	Cancelling() throws java.text.ParseException, ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter booked ID: ");
		booked_id = sc.nextInt();
	}
}
