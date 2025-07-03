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

    public List<Review> getReviewsByCustomerId(int customerId) {
        List<Review> reviews = new ArrayList<>();
        String sql = """
            SELECT r.booking, r.star, r.title, r.content
            FROM reviews r
            JOIN bookings b ON r.booking = b.id
            WHERE b.customer = ?
        """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
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

    public boolean saveReview(Review review) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "INSERT INTO reviews (booking, star, title, content) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, review.getBooking());
            stmt.setInt(2, review.getStar());
            stmt.setString(3, review.getTitle());
            stmt.setString(4, review.getContent());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
