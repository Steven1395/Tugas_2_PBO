package tugas2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import controllers.*;

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
        Request req = new Request(httpExchange);
        Response res = new Response(httpExchange);

        URI uri = httpExchange.getRequestURI();
        String path = uri.getPath();
        String method = httpExchange.getRequestMethod();
        System.out.printf("path: %s\n", path);
        

        // SEMUA ENDPOINT VILLA

        // get semua villa
        if (req.getPath().equals("/villas") && req.getMethod().equals("GET")) {
            VillaController.getAll(req, res);
            return;
        }

        //get berdasar idnya
        if (req.getMethod().equals("GET") && req.getPath().matches("^/villas/\\d+$")) {
            int id = Integer.parseInt(req.getPath().substring("/villas/".length()));
            VillaController.getById(req, res, id);
            return;
        }

        
        // GET /villa/{id}/rooms
        if (req.getMethod().equals("GET") && req.getPath().matches("^/villas/\\d+/rooms$")) {
            int villaId = Integer.parseInt(req.getPath().split("/")[2]);
            RoomsController.getByVillaId(villaId, res);
            return;
        }


        // get villa/bookings
        if (req.getMethod().equals("GET") && req.getPath().matches("^/villas/\\d+/bookings$")) {
            int villaId = Integer.parseInt(req.getPath().split("/")[2]);
            BookingsController.getByVillaId(villaId, res);
            return;
        }


        //get reviews
        if (req.getMethod().equals("GET") && req.getPath().matches("^/villas/\\d+/reviews$")) {
            int villaId = Integer.parseInt(req.getPath().split("/")[2]);
            ReviewsController.getByVillaId(villaId, res);
            return;
        }

    
        //get by date
        if (req.getMethod().equals("GET") && req.getPath().equals("/villas") &&
            req.getQueryParam("ci_date") != null && req.getQueryParam("co_date") != null) {

            VillaController.searchByDate(req, res);
            return;
        }


        //post insert villa
        if (req.getMethod().equals("POST") && req.getPath().equals("/villas")) {
            VillaController.create(req, res);
            return;
        }


        //post insert rooms villa
        if (req.getMethod().equals("POST") && req.getPath().matches("^/villas/\\d+/rooms$")) {
            int villaId = Integer.parseInt(req.getPath().split("/")[2]);
            RoomsController.addToVilla(villaId, req, res);
            return;
        }




        // SEMUA ENDPOINT CUSTOMER







        // SEMUA ENDPOINT VOUCHER








        // Handle request dan autentikasi dalam block try-catch dibawah. Tapi apa semua harus diletakkan disini?
        try {
            Map<String, Object> reqJsonMap = req.getJSON();
            System.out.println("first_name => " + reqJsonMap.get("first_name"));
            System.out.println("email => " + reqJsonMap.get("email"));
            System.out.println("Done!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // Handle response disini jika tidak ada yg menghandle
        if (!res.isSent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> resJsonMap = new HashMap<>();
            resJsonMap.put("message", "Request Success");

            String resJson = "";
            try {
                resJson = objectMapper.writeValueAsString(resJsonMap);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            res.setBody(resJson);
            res.send(HttpURLConnection.HTTP_OK);
            return;
        }



        httpExchange.close();
    }
}
