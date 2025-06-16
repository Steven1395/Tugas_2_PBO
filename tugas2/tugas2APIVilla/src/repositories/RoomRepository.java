package repositories;

import java.sql.*;
import java.util.*;
import models.Room;

public class RoomRepository {
    private final String DB_URL = "jdbc:sqlite:resources/villa.db";

    public List<Room> getRoomsByVillaId(int villaId) {
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM room_types WHERE villa = ?")) {

            stmt.setInt(1, villaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setVilla(rs.getInt("villa"));
                room.setName(rs.getString("name"));
                room.setQuantity(rs.getInt("quantity"));
                room.setCapacity(rs.getInt("capacity"));
                room.setPrice(rs.getInt("price"));
                room.setBedSize(rs.getString("bed_size"));
                room.setHasDesk(rs.getBoolean("has_desk"));
                room.setHasAc(rs.getBoolean("has_ac"));
                room.setHasTv(rs.getBoolean("has_tv"));
                room.setHasWifi(rs.getBoolean("has_wifi"));
                room.setHasShower(rs.getBoolean("has_shower"));
                room.setHasHotwater(rs.getBoolean("has_hotwater"));
                room.setHasFridge(rs.getBoolean("has_fridge"));
                rooms.add(room);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

        public boolean insertRoom(Room room) {
        String sql = "INSERT INTO room_types (id, villa, name, quantity, capacity, price, bed_size, has_desk, has_ac, has_tv, has_wifi, has_shower, has_hotwater, has_fridge) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, room.getId());
            stmt.setInt(2, room.getVilla());
            stmt.setString(3, room.getName());
            stmt.setInt(4, room.getQuantity());
            stmt.setInt(5, room.getCapacity());
            stmt.setInt(6, room.getPrice());
            stmt.setString(7, room.getBedSize());
            stmt.setBoolean(8, room.isHasDesk());
            stmt.setBoolean(9, room.isHasAc());
            stmt.setBoolean(10, room.isHasTv());
            stmt.setBoolean(11, room.isHasWifi());
            stmt.setBoolean(12, room.isHasShower());
            stmt.setBoolean(13, room.isHasHotwater());
            stmt.setBoolean(14, room.isHasFridge());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRoom(int roomId, Room room) {
        String sql = "UPDATE room_types SET name = ?, quantity = ?, capacity = ?, price = ?, bed_size = ?, has_desk = ?, has_ac = ?, has_tv = ?, has_wifi = ?, has_shower = ?, has_hotwater = ?, has_fridge = ? WHERE id = ?";
    
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, room.getName());
            stmt.setInt(2, room.getQuantity());
            stmt.setInt(3, room.getCapacity());
            stmt.setInt(4, room.getPrice());
            stmt.setString(5, room.getBedSize());
            stmt.setBoolean(6, room.isHasDesk());
            stmt.setBoolean(7, room.isHasAc());
            stmt.setBoolean(8, room.isHasTv());
            stmt.setBoolean(9, room.isHasWifi());
            stmt.setBoolean(10, room.isHasShower());
            stmt.setBoolean(11, room.isHasHotwater());
            stmt.setBoolean(12, room.isHasFridge());
            stmt.setInt(13, roomId);
    
            return stmt.executeUpdate() > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    

    public boolean deleteRoom(int roomId) {
        String sql = "DELETE FROM room_types WHERE id = ?";
    
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, roomId);
            return stmt.executeUpdate() > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    

}
