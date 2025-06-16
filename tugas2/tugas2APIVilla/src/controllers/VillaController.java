package controllers;

import services.VillaService;
import tugas2.Response;
import tugas2.Request;
import models.Villa;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VillaController {
    private static VillaService villaService = new VillaService();

    public static void getAll(Request req, Response res) {
        try {
            List<Villa> villas = villaService.getAllVillas();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(villas);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal mengambil data vila\"}");
            res.send(500);
        }
    }

    public static void getById(Request req, Response res, int id) {
        Villa villa = villaService.getVillaById(id);
        if (villa == null) {
            res.setBody("{\"error\": \"Villa not found\"}");
            res.send(404);
            return;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(villa);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal serialisasi villa\"}");
            res.send(500);
        }
    }

    public static void searchByDate(Request req, Response res) {
        String ci = req.getQueryParam("ci_date");
        String co = req.getQueryParam("co_date");

        if (ci == null || co == null) {
            res.setBody("{\"error\": \"Harap sertakan ci_date dan co_date.\"}");
            res.send(400);
            return;
        }

        List<Villa> villas = villaService.getAvailableVillas(ci, co);

        if (villas.isEmpty()) {
            res.setBody("{\"error\": \"Tidak ada vila tersedia di tanggal tersebut.\"}");
            res.send(404);
            return;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(villas);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal mengkonversi data.\"}");
            res.send(500);
        }
    }

        public static void create(Request req, Response res) {
        try {
            Map<String, Object> body = req.getJSON();
            if (body == null || !body.containsKey("id") || !body.containsKey("name") ||
                !body.containsKey("description") || !body.containsKey("address")) {
                res.setBody("{\"error\": \"Harap lengkapi semua data (id, name, description, address)\"}");
                res.send(400);
                return;
            }

            Villa villa = new Villa();
            villa.setId((Integer) body.get("id"));
            villa.setName((String) body.get("name"));
            villa.setDescription((String) body.get("description"));
            villa.setAddress((String) body.get("address"));

            boolean success = villaService.createVilla(villa);

            if (success) {
                res.setBody("{\"message\": \"Villa berhasil ditambahkan\"}");
                res.send(201);
            } else {
                res.setBody("{\"error\": \"Gagal menambahkan villa\"}");
                res.send(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Kesalahan server saat memproses data\"}");
            res.send(500);
        }
    }

    public static void update(int id, Request req, Response res) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Villa updatedVilla = mapper.readValue(req.getBody(), Villa.class);
    
            boolean success = villaService.updateVilla(id, updatedVilla);
            if (success) {
                res.setBody("{\"message\": \"Villa berhasil diperbarui\"}");
                res.send(200);
            } else {
                res.setBody("{\"error\": \"Villa tidak ditemukan\"}");
                res.send(404);
            }
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal memperbarui data villa\"}");
            res.send(500);
        }
    }

    public static void delete(Request req, Response res, int id) {
        boolean success = villaService.deleteVilla(id);
    
        if (success) {
            res.setBody("{\"message\": \"Villa berhasil dihapus.\"}");
            res.send(200);
        } else {
            res.setBody("{\"error\": \"Villa tidak ditemukan atau gagal dihapus.\"}");
            res.send(404);
        }
    }

}
