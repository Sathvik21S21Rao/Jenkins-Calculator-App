package com.iiitb.backend;
import com.iiitb.operations.binaryOperation;
import com.iiitb.operations.unaryOperation;

public class Calculator {

    public <T extends Number, R extends Number> R executeOperation(unaryOperation<T, R> operation, T input) {
        return operation.execute(input);
    }

    public <T extends Number, R extends Number> R executeOperation(binaryOperation<T, R> operation, T input1, T input2) {
        return operation.execute(input1, input2);
    }
}
