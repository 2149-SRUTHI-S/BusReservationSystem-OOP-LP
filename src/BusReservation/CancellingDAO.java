package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancellingDAO {
	public void cancelBooking(Cancelling cancelling) throws SQLException {
		String query = "delete from booking where booking_id=?";
		Connection con = DBConnection.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, cancelling.booked_id);
		st.executeUpdate();
	}
}
