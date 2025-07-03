package repositories;

import models.Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoucherRepository {
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
                voucher.setExpiryDate(rs.getString("expiry_date"));
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
                voucher.setExpiryDate(rs.getString("expiry_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voucher;
    }

    public boolean createVoucher(Voucher voucher) {
        String sql = "INSERT INTO vouchers (code, discount, expiry_date) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voucher.getCode());
            stmt.setDouble(2, voucher.getDiscount());
            stmt.setString(3, voucher.getExpiryDate());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
