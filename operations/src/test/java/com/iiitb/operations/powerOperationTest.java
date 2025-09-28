package com.iiitb.operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class powerOperationTest {

    private final powerOperation powerOp = new powerOperation();

    @Test
    void testPositiveBasePowerOperation() {
        assertEquals(8.0, powerOp.execute(2.0, 3.0).doubleValue(), 0.001, "2^3 = 8");
        assertEquals(25.0, powerOp.execute(5.0, 2.0).doubleValue(), 0.001, "5^2 = 25");
        assertEquals(1.0, powerOp.execute(10.0, 0.0).doubleValue(), 0.001, "10^0 = 1");
    }

    @Test
    void testNegativeBasePowerOperation() {
        assertEquals(-8.0, powerOp.execute(-2.0, 3.0).doubleValue(), 0.001, "(-2)^3 = -8");
        assertEquals(9.0, powerOp.execute(-3.0, 2.0).doubleValue(), 0.001, "(-3)^2 = 9");
    }

    @Test
    void testNegativeExponentPowerOperation() {
        assertEquals(0.25, powerOp.execute(2.0, -2.0).doubleValue(), 0.001, "2^(-2) = 0.25");
        assertEquals(0.25, powerOp.execute(4.0, -1.0).doubleValue(), 0.001, "4^(-1) = 0.25");
    }

    @Test
    void testFractionalExponentPowerOperation() {
        assertEquals(3.0, powerOp.execute(9.0, 0.5).doubleValue(), 0.001, "9^(0.5) = 3");
        assertEquals(2.0, powerOp.execute(8.0, 1.0 / 3.0).doubleValue(), 0.001, "8^(1/3) = 2");
    }

    @Test
    void testZeroPowerOperation() {
        assertEquals(0.0, powerOp.execute(0.0, 2.0).doubleValue(), 0.001, "0^2 = 0");
        assertEquals(1.0, powerOp.execute(5.0, 0.0).doubleValue(), 0.001, "5^0 = 1");
    }

    @Test
    void testOnePowerOperation() {
        assertEquals(1.0, powerOp.execute(1.0, 100.0).doubleValue(), 0.001, "1^100 = 1");
        assertEquals(1.0, powerOp.execute(1.0, -50.0).doubleValue(), 0.001, "1^(-50) = 1");
    }

    @Test
    void testLargeNumberPowerOperation() {
        assertEquals(1024.0, powerOp.execute(2.0, 10.0).doubleValue(), 0.001, "2^10 = 1024");
    }
}
