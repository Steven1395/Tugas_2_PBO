package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Review;
import repositories.ReviewRepository;
import tugas2.Request;
import tugas2.Response;
import java.util.Map;

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

    public class ReviewController {
        private static final ReviewRepository repo = new ReviewRepository();

        public static void getByCustomerId(int customerId, Response res) {
            List<Review> reviews = repo.getReviewsByCustomerId(customerId);

            if (reviews.isEmpty()) {
                res.setBody("{\"error\": \"Customer belum memberikan review.\"}");
                res.send(404);
                return;
            }

            try {
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(reviews);
                res.setBody(json);
                res.send(200);
            } catch (Exception e) {
                res.setBody("{\"error\": \"Gagal mengambil data review.\"}");
                res.send(500);
            }
        }
    }


    public static void create(int customerId, int bookingId, Request req, Response res) {
            try {
                Map<String, Object> body = req.getJSON();

                int star = (int) body.get("star");
                String title = (String) body.get("title");
                String content = (String) body.get("content");

                Review review = new Review(bookingId, star, title, content);

                boolean success = repo.saveReview(review);

                if (success) {
                    res.setBody("{\"message\": \"Review berhasil ditambahkan.\"}");
                    res.send(201);
                } else {
                    res.setBody("{\"error\": \"Gagal menyimpan review.\"}");
                    res.send(500);
                }

            } catch (Exception e) {
                e.printStackTrace();
                res.setBody("{\"error\": \"Server error.\"}");
                res.send(500);
            }
        }
    }


