package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import repositories.BookingRepository;
import models.Booking;
import tugas2.Response;
import tugas2.Request;


import java.util.List;
import java.util.Map;

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
            e.printStackTrace();
            res.setBody("{\"error\": \"Gagal membaca data booking.\"}");
            res.send(500);
        }
    }


    public static void createBooking(Request req, Response res) {
        try {
            int customerId = Integer.parseInt(req.getPath().split("/")[2]);

            Map<String, Object> body = req.getJSON();
            if (body == null) {
                res.setBody("{\"error\": \"Body JSON tidak valid atau Content-Type hilang.\"}");
                res.send(400);
                return;
            }

            Booking booking = new Booking();
            booking.setCustomer(customerId);
            booking.setRoomType((Integer) body.get("room_type"));
            booking.setCheckinDate((String) body.get("checkin_date"));
            booking.setCheckoutDate((String) body.get("checkout_date"));
            booking.setPrice((Integer) body.get("price"));
            booking.setVoucher((String) body.get("voucher"));
            booking.setFinalPrice((Integer) body.get("final_price"));
            booking.setPaymentStatus((String) body.get("payment_status"));
            booking.setHasCheckedin((Boolean) body.get("has_checkedin"));
            booking.setHasCheckedout((Boolean) body.get("has_checkedout"));

            boolean success = repo.createBooking(booking);

            if (success) {
                res.setBody("{\"message\": \"Booking berhasil ditambahkan.\"}");
                res.send(201);
            } else {
                res.setBody("{\"error\": \"Gagal menambahkan booking.\"}");
                res.send(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Request error.\"}");
            res.send(400);
        }
    }

}
