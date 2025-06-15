package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Review;
import repositories.ReviewRepository;
import tugas2.Response;

import java.util.List;

public class ReviewsController {
    private static final ReviewRepository repo = new ReviewRepository();

    public static void getByVillaId(int villaId, Response res) {
        List<Review> reviews = repo.getReviewsByVillaId(villaId);

        if (reviews.isEmpty()) {
            res.setBody("{\"error\": \"Tidak ada review ditemukan untuk vila ini.\"}");
            res.send(404);
            return;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(reviews);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Gagal membaca data review.\"}");
            res.send(500);
        }
    }
}
