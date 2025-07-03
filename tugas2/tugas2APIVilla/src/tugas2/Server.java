package tugas2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import controllers.*;
import controllers.ReviewsController.ReviewController;
import controllers.VouchersController;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private HttpServer server;

    private class RequestHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) {
            Server.processHttpExchange(httpExchange);
        }
    }

    public Server(int port) throws Exception {
        server = HttpServer.create(new InetSocketAddress(port), 128);
        server.createContext("/", new RequestHandler());
        server.start();
    }

    public static void processHttpExchange(HttpExchange httpExchange) {

        URI uri = httpExchange.getRequestURI();
        String rawPath = uri.getPath();
        String rawMethod = httpExchange.getRequestMethod();

        Request req = new Request(httpExchange);
        Response res = new Response(httpExchange);

        String normalizedPath = req.getPath();
        String normalizedMethod = req.getMethod();

        // Debug jalur
        System.out.printf("RAW: %s | %s\n", rawPath, rawMethod);
        System.out.printf("NORM: %s | %s\n", normalizedPath, normalizedMethod);

        //get
        if (rawMethod.equals("GET") && rawPath.equals("/villas")) {
            VillaController.getAll(req, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/villas/\\d+$")) {
            int id = Integer.parseInt(rawPath.split("/")[2]);
            VillaController.getById(req, res, id);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/villas/\\d+/rooms$")) {
            int villaId = Integer.parseInt(rawPath.split("/")[2]);
            RoomsController.getByVillaId(villaId, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/villas/\\d+/bookings$")) {
            int villaId = Integer.parseInt(rawPath.split("/")[2]);
            BookingsController.getByVillaId(villaId, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/villas/\\d+/reviews$")) {
            int villaId = Integer.parseInt(rawPath.split("/")[2]);
            ReviewsController.getByVillaId(villaId, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.equals("/villas")
                && req.getQueryParam("ci_date") != null && req.getQueryParam("co_date") != null) {
            VillaController.searchByDate(req, res);
            return;
        }

        if (rawMethod.equals("POST") && rawPath.equals("/villas")) {
            VillaController.create(req, res);
            return;
        }

        if (rawMethod.equals("POST") && rawPath.matches("^/villas/\\d+/rooms$")) {
            int villaId = Integer.parseInt(rawPath.split("/")[2]);
            RoomsController.addToVilla(villaId, req, res);
            return;
        }

        if (rawMethod.equals("PUT") && rawPath.matches("^/villas/\\d+$")) {
            int id = Integer.parseInt(rawPath.split("/")[2]);
            VillaController.update(id, req, res);
            return;
        }

        if (rawMethod.equals("PUT") && rawPath.matches("^/villas/\\d+/rooms/\\d+$")) {
            String[] parts = rawPath.split("/");
            int villaId = Integer.parseInt(parts[2]);
            int roomId = Integer.parseInt(parts[4]);
            RoomsController.update(villaId, roomId, req, res);
            return;
        }

        if (rawMethod.equals("DELETE") && rawPath.matches("^/villas/\\d+/rooms/\\d+$")) {
            String[] parts = rawPath.split("/");
            int villaId = Integer.parseInt(parts[2]);
            int roomId = Integer.parseInt(parts[4]);
            RoomsController.delete(villaId, roomId, res);
            return;
        }

        if (rawMethod.equals("DELETE") && rawPath.matches("^/villas/\\d+$")) {
            int id = Integer.parseInt(rawPath.split("/")[2]);
            VillaController.delete(req, res, id);
            return;
        }

        // =============================
        // CUSTOMER ENDPOINT (pakai raw)
        // =============================

        if (rawMethod.equals("GET") && rawPath.equals("/customers")) {
            CustomerController.getAll(req, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/customers/\\d+$")) {
            int id = Integer.parseInt(rawPath.split("/")[2]);
            CustomerController.getById(id, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/customers/\\d+/bookings$")) {
            int customerId = Integer.parseInt(rawPath.split("/")[2]);
            BookingsController.getByCustomerId(customerId, res);
            return;
        }

        if (rawMethod.equals("GET") && rawPath.matches("^/customers/\\d+/reviews$")) {
            int customerId = Integer.parseInt(rawPath.split("/")[2]);
            ReviewController.getByCustomerId(customerId, res);
            return;
        }

        if (rawMethod.equals("POST") && rawPath.equals("/customers")) {
            CustomerController.create(req, res);
            return;
        }

        if (rawMethod.equals("POST") && rawPath.matches("^/customers/\\d+/bookings$")) {
            int customerId = Integer.parseInt(rawPath.split("/")[2]);
            BookingsController.createBooking(req, res);
            return;
        }

        if (rawMethod.equals("POST") && rawPath.matches("^/customers/\\d+/bookings/\\d+/reviews$")) {
            String[] segments = rawPath.split("/");
            int customerId = Integer.parseInt(segments[2]);
            int bookingId = Integer.parseInt(segments[4]);
            ReviewsController.create(customerId, bookingId, req, res);
            return;
        }

        if (rawMethod.equals("PUT") && rawPath.matches("^/customers/\\d+$")) {
            int customerId = Integer.parseInt(rawPath.split("/")[2]);
            CustomerController.update(customerId, req, res);
            return;
        }

        // =============================
        // VOUCHER ENDPOINT (pakai normalized)
        // =============================

        if (normalizedMethod.equals("GET") && normalizedPath.equals("/vouchers")) {
            VouchersController.getAll(res);
            return;
        }

        if (normalizedMethod.equals("GET") && normalizedPath.matches("^/vouchers/\\d+$")) {
            int id = Integer.parseInt(normalizedPath.split("/")[2]);
            VouchersController.getById(id, res);
            return;
        }

        if (normalizedMethod.equals("POST") && normalizedPath.equals("/vouchers")) {
            VouchersController.create(req, res);
            return;
        }

        if (normalizedMethod.equals("PUT") && normalizedPath.matches("^/vouchers/\\d+$")) {
            int id = Integer.parseInt(normalizedPath.split("/")[2]);
            VouchersController.update(id, req, res);
            return;
        }

        if (normalizedMethod.equals("DELETE") && normalizedPath.matches("^/vouchers/\\d+/?$")) {
            int id = Integer.parseInt(normalizedPath.split("/")[2]);
            VouchersController.delete(id, res);
            return;
        }

    

        if (!res.isSent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> resJsonMap = new HashMap<>();
            resJsonMap.put("message", "Request Success");

            String resJson = "";
            try {
                resJson = objectMapper.writeValueAsString(resJsonMap);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            res.setBody(resJson);
            res.send(HttpURLConnection.HTTP_OK);
        }

        httpExchange.close();
    }
}
