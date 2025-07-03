package repositories;

import models.Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VouchersRepository {
    private final String DB_URL = "jdbc:sqlite:resources/villa.db";

    public List<Voucher> getAllVouchers() {
        List<Voucher> vouchers = new ArrayList<>();
        String sql = "SELECT * FROM vouchers";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setId(rs.getInt("id"));
                voucher.setCode(rs.getString("code"));
                voucher.setDiscount(rs.getDouble("discount"));
                voucher.setDescription(rs.getString("description"));
                voucher.setStart_date(rs.getString("start_date"));
                voucher.setEnd_date(rs.getString("end_date"));
                vouchers.add(voucher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vouchers;
    }

    public Voucher getVoucherById(int id) {
        Voucher voucher = null;
        String sql = "SELECT * FROM vouchers WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                voucher = new Voucher();
                voucher.setId(rs.getInt("id"));
                voucher.setCode(rs.getString("code"));
                voucher.setDiscount(rs.getDouble("discount"));
                voucher.setDescription(rs.getString("description"));
                voucher.setStart_date(rs.getString("start_date"));
                voucher.setEnd_date(rs.getString("end_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voucher;
    }

    public boolean createVoucher(Voucher voucher) {
        String sql = "INSERT INTO vouchers (id, code, discount, description, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, voucher.getId());
            stmt.setString(2, voucher.getCode());
            stmt.setDouble(3, voucher.getDiscount());
            stmt.setString(4, voucher.getDescription());
            stmt.setString(5, voucher.getStart_date());
            stmt.setString(6, voucher.getEnd_date());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateVoucher(Voucher voucher) {
        String sql = "UPDATE vouchers SET code = ?, discount = ?, description = ?, start_date = ?, end_date = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voucher.getCode());
            stmt.setDouble(2, voucher.getDiscount());
            stmt.setString(3, voucher.getDescription());
            stmt.setString(4, voucher.getStart_date());
            stmt.setString(5, voucher.getEnd_date());
            stmt.setInt(6, voucher.getId());

            int affected = stmt.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteVoucher(int id) {
        String sql = "DELETE FROM vouchers WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int affected = stmt.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getNextId() {
        int nextId = 1;
        String sql = "SELECT MAX(id) AS max_id FROM vouchers";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                nextId = rs.getInt("max_id") + 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextId;
    }
}
