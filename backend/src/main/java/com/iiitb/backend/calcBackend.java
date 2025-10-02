package com.iiitb.backend;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.iiitb.operations.*;

import java.io.InputStream;
import java.util.HashMap;

public class calcBackend {
    public static void main(String[] args) {
        java.util.Properties props = new java.util.Properties();
        try (InputStream fis = calcBackend.class.getClassLoader().getResourceAsStream("config.properties");) {
            props.load(fis);
        } catch (Exception e) {
            System.err.println("Could not load config.properties due to " + e.getMessage() + ", using default port 4567");
        }
        int portNum = 4567; // default port
        if (props.getProperty("server.port") != null) {
            try {
            portNum = Integer.parseInt(props.getProperty("server.port"));
            } catch (NumberFormatException ignored) {}
        }
        port(portNum);
        Calculator calculator = new Calculator();
        
        HashMap<String, Operation> operations = new HashMap<>();
        for (String key : props.stringPropertyNames()) {
            String value = props.getProperty(key);
            if (value.equalsIgnoreCase("enable")) {
                try {
                    Operation op = operationFactory.createOperation(key);
                    operations.put(key, op);
                } catch (IllegalArgumentException e) {
                    System.err.println("Unknown operation in config: " + key);
                }
            }

        }

        
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });
        post("/operations", (req, res) -> {
            Gson gson = new Gson();
            // Return available operations along with their operand count
            HashMap<String, Integer> opsWithOperands = new HashMap<>();
            for (String opName : operations.keySet()) {
                Operation op = operations.get(opName);
                opsWithOperands.put(opName, op.getOperandCount());
            }
            return gson.toJson(opsWithOperands);
        });
        Gson gson = new Gson();
        for(String opName : operations.keySet()) {
            post("/" + opName, (req, res) -> {
                try {
                    OperationRequest requestData = gson.fromJson(req.body(), OperationRequest.class);
                    Operation operation = operations.get(opName);
                    if (operation == null) {
                        res.status(400);
                        return gson.toJson(new Response("Operation not supported", null));
                    }
                    String result = calculator.executeOperation(operation, requestData.operands);
                    return gson.toJson(new Response(null, result));
                } catch (Exception e) {
                    res.status(400);
                    return gson.toJson(new Response(e.getMessage(), null));
                }
            });
        }

    }


    static class Response {
        String error;
        String result;
        Response(String error, String result) {
            this.error = error;
            this.result = result;
        }
    }
    
}
