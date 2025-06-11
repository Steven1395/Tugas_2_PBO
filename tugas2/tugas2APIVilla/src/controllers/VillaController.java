    package controller;

    import com.fasterxml.jackson.databind.ObjectMapper;
    import model.Villa;
    import model.Bookings;
    import tugas2.Request;
    import tugas2.Response;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

public class VillaController {
    public static void getAll(Response res) {
        try {
            List<Villa> data = new ArrayList<>();
            data.add(new Villa(1, "Villa Mawar", "Ubud", 800000));
            data.add(new Villa(2, "Villa Melati", "Sanur", 950000));

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(data);

            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"message\":\"Internal Server Error\"}");
            res.send(500);
        }
    }

    public static void getById(int id, Response res) {
        try {
            // Dummy data list
            List<Villa> villaList = new ArrayList<>();
            villaList.add(new Villa(3, "Villa Phyton", "Ubud", 800000));
            villaList.add(new Villa(4, "Villa Jawa", "Malang", 950000));
            villaList.add(new Villa(5, "Villa Angin", "Canggu", 900000));

            // Cari villa yang id-nya cocok
            Villa found = null;
            for (Villa v : villaList) {
                if (v.id == id) {
                    found = v;
                    break;
                }
            }

            if (found == null) {
                res.setBody("{\"message\": \"Villa with ID " + id + " not found\"}");
                res.send(404);
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(found);

            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"message\": \"Internal Server Error\"}");
            res.send(500);
        }
    }

    public static void getAvailable(Request req, Response res) {
        try {
            String ciStr = req.getQueryParam("ci_date");
            String coStr = req.getQueryParam("co_date");

            if (ciStr == null || coStr == null) {
                res.setBody("{\"message\": \"Missing check-in or check-out date\"}");
                res.send(400);
                return;
            }

            LocalDate checkin = LocalDate.parse(ciStr);
            LocalDate checkout = LocalDate.parse(coStr);

            // Data dummy villas
            List<Villa> allVillas = new ArrayList<>();
            allVillas.add(new Villa(1, "Villa Mawar", "Ubud", 800000));
            allVillas.add(new Villa(2, "Villa Melati", "Sanur", 950000));
            allVillas.add(new Villa(3, "Villa Kenanga", "Seminyak", 750000));

            // Data dummy bookings
            List<Bookings> allBookings = new ArrayList<>();
            allBookings.add(new Bookings(1, 101, 1, "2025-06-15 14:00:00", "2025-06-17 12:00:00", 500000, 0, 500000, "success", true, false));
            allBookings.add(new Bookings(2, 102, 2, "2025-06-18 14:00:00", "2025-06-20 12:00:00", 600000, 0, 600000, "success", false, false));
            allBookings.add(new Bookings(3, 103, 3, "2025-07-01 14:00:00", "2025-07-05 12:00:00", 800000, 100000, 700000, "success", false, false));

            //  Cari villa yang dibooking dalam range tanggal
            Set<Integer> villaIdBooked = new HashSet<>();
            for (Bookings b : allBookings) {
                LocalDate bCheckin = LocalDate.parse(b.checkinDate.substring(0, 10));
                LocalDate bCheckout = LocalDate.parse(b.checkoutDate.substring(0, 10));

                boolean overlap = !(bCheckout.isBefore(checkin) || bCheckin.isAfter(checkout.minusDays(1)));

                if (overlap) {
                    if (b.roomType == 1 || b.roomType == 2) {
                        villaIdBooked.add(1); // roomType 1 & 2 = villa 1
                    } else if (b.roomType == 3) {
                        villaIdBooked.add(2); // roomType 3 = villa 2
                    }
                }
            }

            // Filter villa yang tidak sedang dibooking (berarti tersedia)
            List<Villa> available = new ArrayList<>();
            for (Villa v : allVillas) {
                if (!villaIdBooked.contains(v.id)) {
                    available.add(v);
                }
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(available);
            res.setBody(json);
            res.send(200);

        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"message\":\"Internal Server Error\"}");
            res.send(500);
        }
    }
}



