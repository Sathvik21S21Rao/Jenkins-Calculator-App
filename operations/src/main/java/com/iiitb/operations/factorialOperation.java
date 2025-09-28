package com.iiitb.operations;

import java.math.BigInteger;

public class factorialOperation  extends unaryOperation<Number,BigInteger> {
    @Override
    public BigInteger execute(Number a) {
        if (a.doubleValue() < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if(a.doubleValue() != a.intValue()){
            throw new IllegalArgumentException("Factorial is only defined for integers");
        }
        
        BigInteger result = BigInteger.ONE;

            
        for (int i = 1; i <= a.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
