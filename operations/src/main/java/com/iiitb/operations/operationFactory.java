package com.iiitb.operations;
public class operationFactory {
    
    public static Operation createOperation(String operationType) {
        switch (operationType.toLowerCase()) {
            case "ln":
                return new naturalLogOperation();
            case "sqrt":
                return new sqrtOperation();
            case "power":
                return new powerOperation();
            case "factorial":
                return new factorialOperation();
            default:
                throw new IllegalArgumentException("Unknown operation type: " + operationType);
        }
    }
}

    
