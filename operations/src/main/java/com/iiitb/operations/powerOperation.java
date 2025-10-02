package com.iiitb.operations;


public class powerOperation extends binaryOperation {
    String opName = "power";
    @Override
    public String execute(Number... args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Power operation requires exactly two arguments");
        }
        return Math.pow(args[0].doubleValue(), args[1].doubleValue())+"";
    }
    
}
