package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import tugas2.Request;
import tugas2.Response;
import repositories.CustomerRepository;
import models.Customer;

import java.util.List;
import java.util.Map;

public class CustomerController {
    private static final CustomerRepository repo = new CustomerRepository();

    public static void getAll(Request req, Response res) {
        List<Customer> customers = repo.getAllCustomers();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(customers);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal mengambil data customer\"}");
            res.send(500);
        }
    }

    public static void getById(int id, Response res) {
        Customer customer = repo.getCustomerById(id);
    
        if (customer == null) {
            res.setBody("{\"error\": \"Customer tidak ditemukan.\"}");
            res.send(404);
            return;
        }
    
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(customer);
            res.setBody(json);
            res.send(200);
        } catch (Exception e) {
            res.setBody("{\"error\": \"Gagal mengambil data customer.\"}");
            res.send(500);
        }
    }

    public static void create(Request req, Response res) {
    try {
        Map<String, Object> body = req.getJSON();
        if (body == null || !body.containsKey("id") || !body.containsKey("name") ||
            !body.containsKey("email") || !body.containsKey("phone")) {
            res.setBody("{\"error\": \"Harap lengkapi data (id, name, email, phone)\"}");
            res.send(400);
            return;
        }

            Customer c = new Customer();
            c.setId((Integer) body.get("id"));
            c.setName((String) body.get("name"));
            c.setEmail((String) body.get("email"));
            c.setPhone((String) body.get("phone"));

            boolean success = repo.insertCustomer(c);

        if (success) {
            res.setBody("{\"message\": \"Customer berhasil ditambahkan\"}");
            res.send(201);
        } else {
            res.setBody("{\"error\": \"Gagal menambahkan customer (mungkin ID/email sudah digunakan)\"}");
            res.send(500);
        }

    } catch (Exception e) {
            e.printStackTrace();
            res.setBody("{\"error\": \"Kesalahan server saat memproses data\"}");
            res.send(500);
        }
    }
}
