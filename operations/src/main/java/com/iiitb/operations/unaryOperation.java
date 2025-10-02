package com.iiitb.operations;

public abstract class unaryOperation implements Operation {
  
    @Override
    public int getOperandCount() {
        return 1;
    }
}
