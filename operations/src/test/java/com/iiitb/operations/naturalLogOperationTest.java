package com.iiitb.operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class naturalLogOperationTest {

    private final naturalLogOperation naturalLogOp = new naturalLogOperation();

    @Test
    void testSpecialValueNaturalLog() {
        assertEquals(0.0, naturalLogOp.execute(1.0).doubleValue(), 0.001, "ln(1) = 0");
        assertEquals(1.0, naturalLogOp.execute(Math.E).doubleValue(), 0.001, "ln(e) = 1");
        assertEquals(2.0, naturalLogOp.execute(Math.E * Math.E).doubleValue(), 0.001, "ln(e^2) = 2");
    }

    @Test
    void testPositiveNumberNaturalLog() {
        assertEquals(0.693147180, naturalLogOp.execute(2.0).doubleValue(), 0.001, "ln(2) ≈ 0.693");
        assertEquals(2.302585092, naturalLogOp.execute(10.0).doubleValue(), 0.001, "ln(10) ≈ 2.302");
        assertEquals(1.609437912, naturalLogOp.execute(5.0).doubleValue(), 0.001, "ln(5) ≈ 1.609");
    }

    @Test
    void testFractionalNaturalLog() {
        assertEquals(-0.693147180, naturalLogOp.execute(0.5).doubleValue(), 0.001, "ln(0.5) ≈ -0.693");
        assertEquals(-2.302585092, naturalLogOp.execute(0.1).doubleValue(), 0.001, "ln(0.1) ≈ -2.302");
        assertEquals(-1.386294361, naturalLogOp.execute(0.25).doubleValue(), 0.001, "ln(0.25) ≈ -1.386");
    }

    @Test
    void testLargeNumberNaturalLog() {
        assertEquals(4.605170185, naturalLogOp.execute(100.0).doubleValue(), 0.001, "ln(100) ≈ 4.605");
        assertEquals(6.907755278, naturalLogOp.execute(1000.0).doubleValue(), 0.001, "ln(1000) ≈ 6.907");
    }

    @Test
    void testVerySmallPositiveNaturalLog() {
        assertEquals(-4.605170185, naturalLogOp.execute(0.01).doubleValue(), 0.001, "ln(0.01) ≈ -4.605");
        assertEquals(-6.907755278, naturalLogOp.execute(0.001).doubleValue(), 0.001, "ln(0.001) ≈ -6.907");
    }

    @Test
    void testZeroNaturalLog() {
        assertThrows(IllegalArgumentException.class, () -> naturalLogOp.execute(0.0), "ln(0) throws IllegalArgumentException");
    }

    @Test
    void testNegativeNaturalLog() {
        assertThrows(IllegalArgumentException.class, () -> naturalLogOp.execute(-1.0), "ln(-1) throws IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> naturalLogOp.execute(-5.0), "ln(-5) throws IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> naturalLogOp.execute(-0.5), "ln(-0.5) throws IllegalArgumentException");
    }
}
