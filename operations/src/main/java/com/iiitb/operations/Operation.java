package com.iiitb.operations;

public interface Operation { 
    public int getOperandCount();
    public String execute(Number... args);
};
