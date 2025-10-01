package com.iiitb.frontend;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Paths;

public class FrontendServer {
    public static void main(String[] args) throws Exception {
        int port = 8000;
        // Use relative path for Docker compatibility
        String baseDir = Paths.get("frontend/static").toAbsolutePath().toString();
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new StaticFileHandler(baseDir));
        server.setExecutor(null);
        System.out.println("Serving files from: " + baseDir);
        System.out.println("Frontend server running at http://localhost:" + port);
        server.start();
    }

    static class StaticFileHandler implements HttpHandler {
        private final String baseDir;
        StaticFileHandler(String baseDir) { this.baseDir = baseDir; }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) path = "/index.html";
            File file = new File(baseDir + path).getCanonicalFile();
            if (!file.getPath().startsWith(new File(baseDir).getCanonicalPath())) {
                exchange.sendResponseHeaders(403, -1); // Forbidden
                return;
            }
            if (!file.exists() || file.isDirectory()) {
                exchange.sendResponseHeaders(404, -1); // Not found
                return;
            }
            String mime = path.endsWith(".html") ? "text/html" : "application/octet-stream";
            exchange.getResponseHeaders().set("Content-Type", mime);
            exchange.sendResponseHeaders(200, file.length());
            try (OutputStream os = exchange.getResponseBody(); FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                }
            }
        }
    }
}
