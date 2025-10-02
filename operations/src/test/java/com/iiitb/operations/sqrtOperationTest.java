package com.iiitb.operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class sqrtOperationTest {

    private final sqrtOperation sqrtOp = new sqrtOperation();

    @Test
    void testPositiveNumberSqrt() {
        assertEquals(2.0, Double.parseDouble(sqrtOp.execute(4.0)), 0.001, "sqrt(4) = 2");
        assertEquals(3.0, Double.parseDouble(sqrtOp.execute(9.0)), 0.001, "sqrt(9) = 3");
        assertEquals(5.0, Double.parseDouble(sqrtOp.execute(25.0)), 0.001, "sqrt(25) = 5");
        assertEquals(1.414213562, Double.parseDouble(sqrtOp.execute(2.0)), 0.001, "sqrt(2) ≈ 1.414");
    }

    @Test
    void testZeroSqrt() {
        assertEquals(0.0, Double.parseDouble(sqrtOp.execute(0.0)), 0.001, "sqrt(0) = 0");
    }

    @Test
    void testFractionalSqrt() {
        assertEquals(0.5, Double.parseDouble(sqrtOp.execute(0.25)), 0.001, "sqrt(0.25) = 0.5");
        assertEquals(0.2, Double.parseDouble(sqrtOp.execute(0.04)), 0.001, "sqrt(0.04) = 0.2");
    }

    @Test
    void testLargeNumberSqrt() {
        assertEquals(10.0, Double.parseDouble(sqrtOp.execute(100.0)), 0.001, "sqrt(100) = 10");
        assertEquals(100.0, Double.parseDouble(sqrtOp.execute(10000.0)), 0.001, "sqrt(10000) = 100");
    }

    @Test
    void testNegativeNumberSqrt() {
        assertThrows(IllegalArgumentException.class, () -> sqrtOp.execute(-1.0), "sqrt(-1) throws IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> sqrtOp.execute(-4.0), "sqrt(-4) throws IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> sqrtOp.execute(-0.5), "sqrt(-0.5) throws IllegalArgumentException");
    }
}
