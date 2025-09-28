package com.iiitb.operations;

public class sqrtOperation extends unaryOperation<Number,Number> {
    @Override
    public Number execute(Number a) {
        if (a.doubleValue() < 0) {
            throw new IllegalArgumentException("Cannot compute square root of negative number");
        }
       
        return Double.valueOf(Math.sqrt(a.doubleValue()));
    }
    
}
