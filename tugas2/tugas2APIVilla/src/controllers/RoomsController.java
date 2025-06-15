package controllers;

import repositories.RoomRepository;
import models.Room;
import tugas2.Request;
import tugas2.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class RoomsController {
    private static final RoomRepository repo = new RoomRepository();

    public static void getByVillaId(int villaId, Response res) {
        List<Room> rooms = repo.getRoomsByVillaId(villaId);
        if (rooms.isEmpty()) {
            res.setBody("{\"error\": \"Tidak ada kamar untuk villa ini\"}");
            res.send(404);
            return;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(rooms);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal membaca data kamar\"}");
            res.send(500);
        }
    }

        public static void addToVilla(int villaId, Request req, Response res) {
        try {
            Map<String, Object> body = req.getJSON();
            if (body == null) {
                res.setBody("{\"error\": \"Request body tidak valid.\"}");
                res.send(400);
                return;
            }

            Room room = new Room();
            room.setId((Integer) body.get("id"));
            room.setVilla(villaId); // ambil dari URL
            room.setName((String) body.get("name"));
            room.setQuantity((Integer) body.get("quantity"));
            room.setCapacity((Integer) body.get("capacity"));
            room.setPrice((Integer) body.get("price"));
            room.setBedSize((String) body.get("bed_size"));
            room.setHasDesk((Boolean) body.get("has_desk"));
            room.setHasAc((Boolean) body.get("has_ac"));
            room.setHasTv((Boolean) body.get("has_tv"));
            room.setHasWifi((Boolean) body.get("has_wifi"));
            room.setHasShower((Boolean) body.get("has_shower"));
            room.setHasHotwater((Boolean) body.get("has_hotwater"));
            room.setHasFridge((Boolean) body.get("has_fridge"));

            boolean success = repo.insertRoom(room);

            if (success) {
                res.setBody("{\"message\": \"Tipe kamar berhasil ditambahkan.\"}");
                res.send(201);
            } else {
                res.setBody("{\"error\": \"Gagal menambahkan kamar.\"}");
                res.send(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Server gagal memproses request.\"}");
            res.send(500);
        }
    }


}
