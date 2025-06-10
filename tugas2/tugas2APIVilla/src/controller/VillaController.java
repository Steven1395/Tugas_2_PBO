package controller;

import model.Villa;
import tugas2.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

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
}

