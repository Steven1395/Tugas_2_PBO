package controller;

import model.Bookings;
import tugas2.Request;
import tugas2.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

public class BookingsController {
    public static void getByVillaId(int villaId, Response res) {
        try {
            List<Bookings> allBookings = new ArrayList<>();
            allBookings.add(new Bookings(1, 1, 1, "2025-06-15 14:00:00", "2025-06-17 12:00:00", 500000, 50000, 450000, "success", true, false));
            allBookings.add(new Bookings(2, 2, 2, "2025-06-18 14:00:00", "2025-06-20 12:00:00", 600000, 0, 600000, "waiting", false, false));
            allBookings.add(new Bookings(3, 3, 3, "2025-07-01 14:00:00", "2025-07-05 12:00:00", 800000, 100000, 700000, "failed", false, false));

            List<Bookings> filtered = new ArrayList<>();
            for (Bookings b : allBookings) {
                if ((villaId == 1 && (b.roomType == 1 || b.roomType == 2)) ||
                        (villaId == 2 && b.roomType == 3)) {
                    filtered.add(b);
                }
            }

            if (filtered.isEmpty()) {
                res.setBody("{\"message\": \"No bookings found for this villa\"}");
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