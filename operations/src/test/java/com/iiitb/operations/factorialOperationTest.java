package com.iiitb.operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;



class factorialOperationTest {

    private final factorialOperation factorialOp = new factorialOperation();

    @Test
    void testSmallPositiveFactorials() {
        assertEquals("2", factorialOp.execute(BigInteger.valueOf(2L)));
        assertEquals("6", factorialOp.execute(BigInteger.valueOf(3L)));
        assertEquals("24", factorialOp.execute(BigInteger.valueOf(4L)));
        assertEquals("120", factorialOp.execute(BigInteger.valueOf(5L)));
    }

    @Test
    void testMediumFactorials() {
        assertEquals("720", factorialOp.execute(BigInteger.valueOf(6L)));
        assertEquals("5040", factorialOp.execute(BigInteger.valueOf(7L)));
        assertEquals("40320", factorialOp.execute(BigInteger.valueOf(8L)));
        assertEquals("3628800", factorialOp.execute(BigInteger.valueOf(10L)));
    }

    @Test
    void testLargerFactorials() {
        assertEquals("479001600", factorialOp.execute(BigInteger.valueOf(12L)));
        assertEquals("1307674368000", factorialOp.execute(BigInteger.valueOf(15L)));
    }

    @Test
    void testNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> factorialOp.execute(BigInteger.valueOf(-1L)));
        assertThrows(IllegalArgumentException.class, () -> factorialOp.execute(BigInteger.valueOf(-5L)));
    }


    @Test
    void testEdgeCaseFactorials() {
        assertEquals("1", factorialOp.execute(BigInteger.valueOf(0)));
        assertEquals("1", factorialOp.execute(BigInteger.valueOf(1)));
    }
}
