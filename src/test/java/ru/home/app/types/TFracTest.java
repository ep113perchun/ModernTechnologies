package ru.home.app.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TFracTest {

    @Test
    public void testConstructorValid() throws Exception {
        TFrac frac = new TFrac(3, 4);
        assertEquals("3/4", frac.toString());
    }

    @Test
    public void testConstructorStringValid() throws Exception {
        TFrac frac = new TFrac("5/8");
        assertEquals("5/8", frac.toString());
    }

    @Test
    public void testConstructorZeroDenominator() {
        Exception exception = assertThrows(Exception.class, () -> {
            new TFrac(1, 0);
        });
        assertEquals("ERROR: Denominator == 0", exception.getMessage());
    }

    @Test
    public void testConstructorStringZeroDenominator() {
        Exception exception = assertThrows(Exception.class, () -> {
            new TFrac("1/0");
        });
        assertEquals("ERROR: Denominator == 0", exception.getMessage());
    }

    @Test
    public void testAddition() throws Exception {
        TFrac frac1 = new TFrac(1, 2);
        TFrac frac2 = new TFrac(1, 3);
        TFrac result = frac1.add(frac2);
        assertEquals("5/6", result.toString());
    }

    @Test
    public void testSubtraction() throws Exception {
        TFrac frac1 = new TFrac(3, 4);
        TFrac frac2 = new TFrac(1, 4);
        TFrac result = frac1.subtract(frac2);
        assertEquals("1/2", result.toString());
    }

    @Test
    public void testMultiplication() throws Exception {
        TFrac frac1 = new TFrac(2, 3);
        TFrac frac2 = new TFrac(3, 4);
        TFrac result = frac1.multiply(frac2);
        assertEquals("1/2", result.toString());
    }

    @Test
    public void testDivision() throws Exception {
        TFrac frac1 = new TFrac(3, 4);
        TFrac frac2 = new TFrac(2, 3);
        TFrac result = frac1.divide(frac2);
        assertEquals("9/8", result.toString());
    }

    @Test
    public void testDivisionByZeroNumerator() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            TFrac frac1 = new TFrac(1, 2);
            TFrac frac2 = new TFrac(0, 1);
            frac1.divide(frac2);
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    public void testSquared() throws Exception {
        TFrac frac = new TFrac(2, 3);
        TFrac result = frac.squared();
        assertEquals("4/9", result.toString());
    }

    @Test
    public void testReverse() throws Exception {
        TFrac frac = new TFrac(2, 3);
        TFrac result = frac.reverse();
        assertEquals("3/2", result.toString());
    }

    @Test
    public void testMinus() throws Exception {
        TFrac frac = new TFrac(2, 3);
        TFrac result = frac.minus();
        assertEquals("-2/3", result.toString());
    }

    @Test
    public void testIsEqually() throws Exception {
        TFrac frac1 = new TFrac(2, 3);
        TFrac frac2 = new TFrac(4, 6);
        assertTrue(frac1.isEqually(frac2));
    }

    @Test
    public void testIsMore() throws Exception {
        TFrac frac1 = new TFrac(3, 4);
        TFrac frac2 = new TFrac(2, 4);
        assertTrue(frac1.isMore(frac2));
    }

    @Test
    public void testTakeNumeratorNumber() throws Exception {
        TFrac frac = new TFrac(3, 5);
        assertEquals(3, frac.takeNumeratorNumber());
    }

    @Test
    public void testTakeDenominatorNumber() throws Exception {
        TFrac frac = new TFrac(3, 5);
        assertEquals(5, frac.takeDenominatorNumber());
    }

    @Test
    public void testTakeNumeratorString() throws Exception {
        TFrac frac = new TFrac(7, 9);
        assertEquals("7", frac.takeNumeratorString());
    }

    @Test
    public void testTakeDenominatorString() throws Exception {
        TFrac frac = new TFrac(7, 9);
        assertEquals("9", frac.takeDenominatorString());
    }

    @Test
    public void testTakeFracString() throws Exception {
        TFrac frac = new TFrac(7, 9);
        assertEquals("7/9", frac.takeFracString());
    }
}
