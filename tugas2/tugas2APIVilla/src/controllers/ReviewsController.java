package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Reviews;
import tugas2.Response;

import java.util.ArrayList;
import java.util.List;

public class ReviewsController {
    public static void getByVillaId(int villaId, Response res) {
        try {
            // dummy data: booking id 1 dan 2 dimiliki oleh villa id 1
            List<Reviews> all = new ArrayList<>();
            all.add(new Reviews(1, 5, "Luar biasa!", "Villa sangat bersih dan nyaman."));
            all.add(new Reviews(2, 4, "Bagus tapi agak ramai", "Lingkungan agak bising, tapi oke."));

            // dummy relasi booking id → villa id
            List<Reviews> filtered = new ArrayList<>();
            if (villaId == 1) {
                filtered.add(all.get(0));
                filtered.add(all.get(1));
            }

            if (filtered.isEmpty()) {
                res.setBody("{\"message\":\"No reviews for this villa\"}");
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