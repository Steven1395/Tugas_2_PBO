package repositories;

import models.Review;
import java.sql.*;
import java.util.*;

public class ReviewRepository {
    private final String DB_URL = "jdbc:sqlite:resources/villa.db";

    public List<Review> getReviewsByVillaId(int villaId) {
        List<Review> reviews = new ArrayList<>();

        String query = 
            "SELECT r.* FROM reviews r " +
            "JOIN bookings b ON r.booking = b.id " +
            "JOIN room_types rt ON b.room_type = rt.id " +
            "WHERE rt.villa = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, villaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Review review = new Review();
                review.setBooking(rs.getInt("booking"));
                review.setStar(rs.getInt("star"));
                review.setTitle(rs.getString("title"));
                review.setContent(rs.getString("content"));
                reviews.add(review);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }
}
