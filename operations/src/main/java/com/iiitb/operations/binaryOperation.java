package com.iiitb.operations;

public abstract class binaryOperation implements Operation{
    @Override
    public int getOperandCount() {
        return 2;
    }
}
