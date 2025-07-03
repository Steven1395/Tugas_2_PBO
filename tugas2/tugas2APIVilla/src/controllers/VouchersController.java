package controllers;

import tugas2.Response;
import repositories.VoucherRepository;
import models.Voucher;
import com.fasterxml.jackson.databind.ObjectMapper;
import tugas2.Request;

import java.util.Map;
import java.util.List;

public class VoucherController {
    private static final VoucherRepository repo = new VoucherRepository();

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
        System.out.println("Masuk VoucherController.create");
        try {
            Map<String, Object> body = req.getJSON();

            String code = (String) body.get("code");
            double discount = (double) body.get("discount");
            String expiryDate = (String) body.get("expiryDate");

            Voucher voucher = new Voucher(code, discount, expiryDate);

            boolean success = repo.createVoucher(voucher);

            if (success) {
                res.setBody("{\"message\": \"Voucher berhasil dibuat.\"}");
                res.send(201);
            } else {
                res.setBody("{\"error\": \"Gagal membuat voucher.\"}");
                res.send(500);
            }

        } catch (Exception e)  {
            e.printStackTrace();
            res.setBody("{\"error\": \"Server error.\"}");
            res.send(500);
        }
    }
}
