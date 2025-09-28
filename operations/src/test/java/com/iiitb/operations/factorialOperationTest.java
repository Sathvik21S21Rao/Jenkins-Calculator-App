package com.iiitb.operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;



class factorialOperationTest {

    private final factorialOperation factorialOp = new factorialOperation();

    @Test
    void testSmallPositiveFactorials() {
        assertEquals(BigInteger.valueOf(2L), factorialOp.execute(BigInteger.valueOf(2L)));
        assertEquals(BigInteger.valueOf(6L), factorialOp.execute(BigInteger.valueOf(3L)));
        assertEquals(BigInteger.valueOf(24L), factorialOp.execute(BigInteger.valueOf(4L)));
        assertEquals(BigInteger.valueOf(120L), factorialOp.execute(BigInteger.valueOf(5L)));
    }

    @Test
    void testMediumFactorials() {
        assertEquals(BigInteger.valueOf(720L), factorialOp.execute(BigInteger.valueOf(6L)));
        assertEquals(BigInteger.valueOf(5040L), factorialOp.execute(BigInteger.valueOf(7L)));
        assertEquals(BigInteger.valueOf(40320L), factorialOp.execute(BigInteger.valueOf(8L)));
        assertEquals(BigInteger.valueOf(3628800L), factorialOp.execute(BigInteger.valueOf(10L)));
    }

    @Test
    void testLargerFactorials() {
        assertEquals(BigInteger.valueOf(479001600L), factorialOp.execute(BigInteger.valueOf(12L)));
        assertEquals(BigInteger.valueOf(1307674368000L), factorialOp.execute(BigInteger.valueOf(15L)));
    }

    @Test
    void testNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> factorialOp.execute(BigInteger.valueOf(-1L)));
        assertThrows(IllegalArgumentException.class, () -> factorialOp.execute(BigInteger.valueOf(-5L)));
    }


    @Test
    void testEdgeCaseFactorials() {
        assertEquals(BigInteger.ONE, factorialOp.execute(BigInteger.valueOf(0)));
        assertEquals(BigInteger.ONE, factorialOp.execute(BigInteger.valueOf(1)));
    }
}
