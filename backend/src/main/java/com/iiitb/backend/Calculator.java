package com.iiitb.backend;
import com.iiitb.operations.Operation;

public class Calculator {


    public String executeOperation(Operation operation, Number... input) {
        return operation.execute(input);
    }

}
