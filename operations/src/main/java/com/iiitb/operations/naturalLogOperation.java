package com.iiitb.operations;

public class naturalLogOperation extends unaryOperation {
    String opName = "ln";
    public String execute(Number... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Natural logarithm operation requires exactly one argument");
        }
        if(args[0].doubleValue() <= 0) {
            throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers");
        }
        return Math.log(args[0].doubleValue())+"";
    }
}
