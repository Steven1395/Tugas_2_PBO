package repositories;

import java.sql.*;
import java.util.*;
import models.Villa;

public class VillaRepository {
    private final String DB_URL = "jdbc:sqlite:resources/villa.db";


    //METHOD UNTUK ALL VILLAS
    public List<Villa> getAllVillas() {
        List<Villa> villas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM villas")) {

            while (rs.next()) {
                Villa villa = new Villa();
                villa.setId(rs.getInt("id"));
                villa.setName(rs.getString("name"));
                villa.setDescription(rs.getString("description"));
                villa.setAddress(rs.getString("address"));
                villas.add(villa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return villas;
    }

    // METHOD VILLA BY ID
    public Villa getVillaById(int id) {
    Villa villa = null;
    try (Connection conn = DriverManager.getConnection(DB_URL);
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM villas WHERE id = ?")) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            villa = new Villa();
            villa.setId(rs.getInt("id"));
            villa.setName(rs.getString("name"));
            villa.setDescription(rs.getString("description"));
            villa.setAddress(rs.getString("address"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return villa;
}

    public List<Villa> getAvailableVillas(String ciDate, String coDate) {
        List<Villa> villas = new ArrayList<>();

        String sql = """
            SELECT DISTINCT v.*
            FROM villas v
            JOIN room_types r ON v.id = r.villa
            WHERE r.id NOT IN (
                SELECT b.room_type
                FROM bookings b
                WHERE NOT (
                    b.checkout_date <= ? OR
                    b.checkin_date >= ?
                )
            )
        """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ciDate);
            stmt.setString(2, coDate);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Villa villa = new Villa();
                villa.setId(rs.getInt("id"));
                villa.setName(rs.getString("name"));
                villa.setDescription(rs.getString("description"));
                villa.setAddress(rs.getString("address"));
                villas.add(villa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return villas;
    }

        public boolean insertVilla(Villa villa) {
        String sql = "INSERT INTO villas (id, name, description, address) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, villa.getId());
            stmt.setString(2, villa.getName());
            stmt.setString(3, villa.getDescription());
            stmt.setString(4, villa.getAddress());

            int affected = stmt.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // METHOD UNTUK UPDATE VILLA
    public boolean updateVilla(int id, Villa villa) {
        String sql = "UPDATE villas SET name = ?, description = ?, address = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, villa.getName());
            stmt.setString(2, villa.getDescription());
            stmt.setString(3, villa.getAddress());
            stmt.setInt(4, id);
    
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //METHOD HAPUS VILLA
    public boolean deleteVilla(int id) {
        String sql = "DELETE FROM villas WHERE id = ?";
    
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    

}
