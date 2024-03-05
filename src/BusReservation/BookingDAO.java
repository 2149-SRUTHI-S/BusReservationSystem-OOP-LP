package BusReservation;  
         
import java.util.Date;    
import java.sql.*;    

public class BookingDAO {
	public void addBooking(Booking booking) throws SQLException {  
		String query = "insert into booking values(?,?,?,?)";
		Connection con = DBConnection.getConnection();
		PreparedStatement st = con.prepareStatement(query);  
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		st.setInt(1, booking.booking_id);
		st.setString(2, booking.passenger_name);
		st.setInt(3, booking.busNo);
		st.setDate(4, sqldate);
		st.executeUpdate();
	}

	public int getBookedCount(int busNo, Date date) throws SQLException {
		String query = "select count(passenger_name) from booking where busNo=? and travel_date=?";
		Connection con = DBConnection.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		st.setInt(1, busNo);
		st.setDate(2, sqldate);
		ResultSet rs = st.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
}
