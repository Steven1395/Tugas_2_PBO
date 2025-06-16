package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import repositories.BookingRepository;
import models.Booking;
import tugas2.Response;

import java.util.List;

public class BookingsController {
    private static final BookingRepository repo = new BookingRepository();

    public static void getByVillaId(int villaId, Response res) {
        List<Booking> bookings = repo.getBookingsByVillaId(villaId);

        if (bookings.isEmpty()) {
            res.setBody("{\"error\": \"Tidak ada booking ditemukan untuk vila ini.\"}");
            res.send(404);
            return;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(bookings);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Gagal membaca data booking.\"}");
            res.send(500);
        }
    }

    public class BookingController {
        private static final BookingRepository repo = new BookingRepository();
    
        public static void getByCustomerId(int customerId, Response res) {
            List<Booking> bookings = repo.getBookingsByCustomerId(customerId);
    
            if (bookings.isEmpty()) {
                res.setBody("{\"error\": \"Customer belum memiliki booking.\"}");
                res.send(404);
                return;
            }
    
            try {
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(bookings);
                res.setBody(json);
                res.send(200);
            } catch (Exception e) {
                res.setBody("{\"error\": \"Gagal membaca data booking.\"}");
                res.send(500);
            }
        }
    }
}
