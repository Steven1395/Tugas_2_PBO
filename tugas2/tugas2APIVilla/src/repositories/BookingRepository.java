package repositories;

import models.Booking;
import java.sql.*;
import java.util.*;

public class BookingRepository {
    private final String DB_URL = "jdbc:sqlite:resources/villa.db";

    public List<Booking> getBookingsByVillaId(int villaId) {
        List<Booking> bookings = new ArrayList<>();

        String query = """
            SELECT b.* FROM bookings b
            JOIN room_types r ON b.room_type = r.id
            WHERE r.villa = ?
        """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, villaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setCustomer(rs.getInt("customer"));
                booking.setRoomType(rs.getInt("room_type"));
                booking.setCheckinDate(rs.getString("checkin_date"));
                booking.setCheckoutDate(rs.getString("checkout_date"));
                booking.setPrice(rs.getInt("price"));
                booking.setVoucher(rs.getString("voucher"));
                booking.setFinalPrice(rs.getInt("final_price"));
                booking.setPaymentStatus(rs.getString("payment_status"));
                booking.setHasCheckedin(rs.getBoolean("has_checkedin"));
                booking.setHasCheckedout(rs.getBoolean("has_checkedout"));

                bookings.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public List<Booking> getBookingsByCustomerId(int customerId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE customer = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getInt("id"));
                b.setCustomer(rs.getInt("customer"));
                b.setRoomType(rs.getInt("room_type"));
                b.setCheckinDate(rs.getString("checkin_date"));
                b.setCheckoutDate(rs.getString("checkout_date"));
                b.setPrice(rs.getInt("price"));
                b.setVoucher(rs.getString("voucher"));
                b.setFinalPrice(rs.getInt("final_price"));
                b.setPaymentStatus(rs.getString("payment_status"));
                b.setHasCheckedin(rs.getBoolean("has_checkedin"));
                b.setHasCheckedout(rs.getBoolean("has_checkedout"));
                bookings.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}
