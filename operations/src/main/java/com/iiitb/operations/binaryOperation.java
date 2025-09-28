package com.iiitb.operations;

public abstract class binaryOperation<T extends Number, R extends Number> {
    public abstract R execute(T a, T b);
}
