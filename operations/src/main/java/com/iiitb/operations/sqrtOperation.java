package com.iiitb.operations;

public class sqrtOperation extends unaryOperation {
    String opName = "sqrt";
    
    @Override
    public String execute(Number...args) {
        if (args.length != 1 ) {
            throw new IllegalArgumentException("Square root operation requires exactly one argument");
        }
        if(args[0].doubleValue() < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers");
        }

        return Math.sqrt(args[0].doubleValue())+"";
    }
    
}
