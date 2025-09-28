package com.iiitb.operations;

public class naturalLogOperation extends unaryOperation<Number,Number> {
    public Number execute(Number a) {
        if (a.doubleValue() <= 0) {
            throw new IllegalArgumentException("Cannot compute natural logarithm of non-positive number");
        }
        return Double.valueOf(Math.log(a.doubleValue()));
    }
}
