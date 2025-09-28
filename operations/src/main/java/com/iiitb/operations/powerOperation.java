package com.iiitb.operations;


public class powerOperation extends binaryOperation<Number,Number> {
    @Override
    public Number execute(Number a, Number b) {
        return Double.valueOf(Math.pow(a.doubleValue(), b.doubleValue()));
    }
    
}
