package controllers;

import tugas2.Response;
import repositories.VouchersRepository;
import models.Voucher;
import com.fasterxml.jackson.databind.ObjectMapper;
import tugas2.Request;

import java.util.Map;
import java.util.List;

public class VouchersController {
    private static final VouchersRepository repo = new VouchersRepository();

    public static void getAll(Response res) {
        List<Voucher> vouchers = repo.getAllVouchers();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vouchers);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Gagal mengambil data vouchers.\"}");
            res.send(500);
        }
    }

    public static void getById(int id, Response res) {
        Voucher voucher = repo.getVoucherById(id);

        if (voucher == null) {
            res.setBody("{\"error\": \"Voucher tidak ditemukan.\"}");
            res.send(404);
            return;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(voucher);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Gagal mengambil data voucher.\"}");
            res.send(500);
        }
    }

    public static void create(Request req, Response res) {
        try {
            Map<String, Object> body = req.getJSON();

            String code = (String) body.get("code");
            Object discountObj = body.get("discount");
            String description = (String) body.get("description");
            String startDate = (String) body.get("start_date");
            String endDate = (String) body.get("end_date");

            double discount;
            if (discountObj instanceof Integer) {
                discount = ((Integer) discountObj).doubleValue();
            } else if (discountObj instanceof Double) {
                discount = (Double) discountObj;
            } else {
                discount = Double.parseDouble(discountObj.toString());
            }

            int nextId = repo.getNextId();

            Voucher voucher = new Voucher(nextId, code, discount, description, startDate, endDate);

            boolean success = repo.createVoucher(voucher);

            if (success) {
                res.setBody("{\"message\": \"Voucher berhasil dibuat.\"}");
                res.send(201);
            } else {
                res.setBody("{\"error\": \"Gagal membuat voucher.\"}");
                res.send(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Server error.\"}");
            res.send(500);
        }
    }

    public static void update(int id, Request req, Response res) {
        try {
            Map<String, Object> body = req.getJSON();

            String code = (String) body.get("code");
            Object discountObj = body.get("discount");
            String description = (String) body.get("description");
            String startDate = (String) body.get("start_date");
            String endDate = (String) body.get("end_date");

            double discount;
            if (discountObj instanceof Integer) {
                discount = ((Integer) discountObj).doubleValue();
            } else if (discountObj instanceof Double) {
                discount = (Double) discountObj;
            } else {
                discount = Double.parseDouble(discountObj.toString());
            }

            Voucher voucher = new Voucher(id, code, discount, description, startDate, endDate);

            boolean success = repo.updateVoucher(voucher);

            if (success) {
                res.setBody("{\"message\": \"Voucher berhasil diupdate.\"}");
                res.send(200);
            } else {
                res.setBody("{\"error\": \"Voucher tidak ditemukan atau update gagal.\"}");
                res.send(404);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Server error.\"}");
            res.send(500);
        }
    }

    public static void delete(int id, Response res) {
        boolean success = repo.deleteVoucher(id);

        if (success) {
            res.setBody("{\"message\": \"Voucher berhasil dihapus.\"}");
            res.send(200);
        } else {
            res.setBody("{\"error\": \"Voucher tidak ditemukan atau gagal dihapus.\"}");
            res.send(404);
        }
    }
}

