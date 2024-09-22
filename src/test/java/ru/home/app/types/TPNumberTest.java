package ru.home.app.types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TPNumberTest {

    @Test
    void testConstructorWithValidValues() {
        TPNumber tp = new TPNumber(5.25, 10, 2);
        assertEquals(5.25, tp.getNumber());
        assertEquals(10, tp.getBase());
        assertEquals(2, tp.getPrecision());
    }

    @Test
    void testConstructorThrowsOnInvalidBase() {
        assertThrows(IllegalArgumentException.class, () -> new TPNumber(5.25, 17, 2));
    }

    @Test
    void testConstructorThrowsOnNegativePrecision() {
        assertThrows(IllegalArgumentException.class, () -> new TPNumber(5.25, 10, -1));
    }

    @Test
    void testAdd() {
        TPNumber tp1 = new TPNumber(5.0, 10, 2);
        TPNumber tp2 = new TPNumber(3.0, 10, 2);
        TPNumber result = tp1.add(tp2);
        assertEquals(8.0, result.getNumber());
    }

    @Test
    void testAddThrowsOnIncompatibleNumbers() {
        TPNumber tp1 = new TPNumber(5.0, 10, 2);
        TPNumber tp2 = new TPNumber(3.0, 2, 2);
        assertThrows(IllegalArgumentException.class, () -> tp1.add(tp2));
    }

    @Test
    void testSubtract() {
        TPNumber tp1 = new TPNumber(5.0, 10, 2);
        TPNumber tp2 = new TPNumber(3.0, 10, 2);
        TPNumber result = tp1.subtract(tp2);
        assertEquals(2.0, result.getNumber());
    }

    @Test
    void testMultiply() {
        TPNumber tp1 = new TPNumber(5.0, 10, 2);
        TPNumber tp2 = new TPNumber(3.0, 10, 2);
        TPNumber result = tp1.multiply(tp2);
        assertEquals(15.0, result.getNumber());
    }

    @Test
    void testDivide() {
        TPNumber tp1 = new TPNumber(10.0, 10, 2);
        TPNumber tp2 = new TPNumber(2.0, 10, 2);
        TPNumber result = tp1.divide(tp2);
        assertEquals(5.0, result.getNumber());
    }

    @Test
    void testDivideByZeroThrows() {
        TPNumber tp1 = new TPNumber(10.0, 10, 2);
        TPNumber tp2 = new TPNumber(0.0, 10, 2);
        assertThrows(IllegalArgumentException.class, () -> tp1.divide(tp2));
    }

    @Test
    void testReciprocal() {
        TPNumber tp = new TPNumber(4.0, 10, 2);
        TPNumber result = tp.reciprocal();
        assertEquals(0.25, result.getNumber());
    }

    @Test
    void testReciprocalThrowsOnZero() {
        TPNumber tp = new TPNumber(0.0, 10, 2);
        assertThrows(IllegalArgumentException.class, () -> tp.reciprocal());
    }

    @Test
    void testSquare() {
        TPNumber tp = new TPNumber(4.0, 10, 2);
        TPNumber result = tp.square();
        assertEquals(16.0, result.getNumber());
    }

    @Test
    void testGetFormattedNumber() {
        TPNumber tp = new TPNumber(5.12345, 10, 3);
        assertEquals("5,123", tp.getFormattedNumber());
    }
}
