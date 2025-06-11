package controller;

import model.Rooms;
import tugas2.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class RoomsController {
    public static void getByVillaId(int villaId, Response res) {
        try {
            List<Rooms> allRooms = new ArrayList<>();
            allRooms.add(new Rooms(1, 1, "Deluxe", 300000));
            allRooms.add(new Rooms(2, 2, "Standard", 250000));
            allRooms.add(new Rooms(3, 3, "Suite", 500000));

            List<Rooms> filtered = new ArrayList<>();
            for (Rooms room : allRooms) {
                if (room.villaId == villaId) {
                    filtered.add(room);
                }
            }

            if (filtered.isEmpty()) {
                res.setBody("{\"message\": \"No rooms found for this villa\"}");
                res.send(404);
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(filtered);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"message\":\"Internal Server Error\"}");
            res.send(500);
        }
    }
}
