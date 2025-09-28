package com.iiitb.backend;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.iiitb.operations.*;
import java.math.BigInteger;
import com.iiitb.backend.Calculator;

public class calcBackend {
    public static void main(String[] args) {
        port(4567);
        unaryOperation<Number, Number> lnOp = new naturalLogOperation();
        unaryOperation<Number, Number> sqrtOp = new sqrtOperation();
        binaryOperation<Number, Number> powerOp = new powerOperation();
        unaryOperation<Number, BigInteger> factorialOp = new factorialOperation();
        Calculator calculator = new Calculator();

         // CORS setup
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
        Gson gson = new Gson();

        post("/power", (req, res) -> {
            res.type("application/json");
            OperationRequest opReq = gson.fromJson(req.body(), OperationRequest.class);
            Number result = null;
            String error = null;
            try {
                result = calculator.executeOperation(powerOp, opReq.a, opReq.b);
            } catch (Exception e) {
                error = e.getMessage();
            }
            return gson.toJson(new Response(error, result.toString()));
        });

        post("/sqrt", (req, res) -> {
            res.type("application/json");
            OperationRequest opReq = gson.fromJson(req.body(), OperationRequest.class);
            Number result = null;
            String error = null;
            try {
                result = calculator.executeOperation(sqrtOp, opReq.a);
            } catch (Exception e) {
                error = e.getMessage();
            }
            return gson.toJson(new Response(error, result.toString()));
        });

        post("/factorial", (req, res) -> {
            res.type("application/json");
            OperationRequest opReq = gson.fromJson(req.body(), OperationRequest.class);
            BigInteger result = null;
            String error = null;
            try {
                BigInteger input;
                input = new BigInteger(String.valueOf(opReq.a.longValue()));
                result = calculator.executeOperation(factorialOp, input);
            } catch (Exception e) {
                error = e.getMessage();
                return gson.toJson(new Response(error, null));
            }
            return gson.toJson(new Response(error, result != null ? result.toString() : null));
        });

        post("/ln", (req, res) -> {
            res.type("application/json");
            OperationRequest opReq = gson.fromJson(req.body(), OperationRequest.class);
            Number result = null;
            String error = null;
            try {
                result = calculator.executeOperation(lnOp, opReq.a);
            } catch (Exception e) {
                error = e.getMessage();
            }
            return gson.toJson(new Response(error, result.toString()));
        });
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
