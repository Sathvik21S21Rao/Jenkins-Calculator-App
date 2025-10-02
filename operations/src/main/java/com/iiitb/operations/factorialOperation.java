package com.iiitb.operations;

import java.math.BigInteger;

public class factorialOperation  extends unaryOperation {
    String opName = "factorial";

    @Override
    public String execute(Number... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Factorial operation requires exactly one argument");
        }
        Number a = args[0];
        if(a.doubleValue() != a.intValue()){
            throw new IllegalArgumentException("Factorial is only defined for integers");
        }
        if (a.intValue() < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= a.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.toString();
    }

}
