package ru.home.app.types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TComplexTest {

    @Test
    public void testConstructorAndToString() {
        TComplex c1 = new TComplex(6, 3);
        assertEquals("6.0 + i*3.0", c1.toString());

        TComplex c2 = new TComplex("6 + i*3");
        assertEquals("6.0 + i*3.0", c2.toString());
    }

    @Test
    public void testAdd() {
        TComplex c1 = new TComplex(2, 1);
        TComplex c2 = new TComplex(2, 1);
        TComplex result = c1.add(c2);
        new TComplex(4, 2).equals(result);
    }

    @Test
    public void testSubtract() {
        TComplex c1 = new TComplex(5, 3);
        TComplex c2 = new TComplex(2, 1);
        TComplex result = c1.subtract(c2);
        new TComplex(3, 2).equals(result);
    }

    @Test
    public void testMultiply() {
        TComplex c1 = new TComplex(3, 2);
        TComplex c2 = new TComplex(1, 7);
        TComplex result = c1.multiply(c2);
        new TComplex(-11, 23).equals(result);
    }

    @Test
    public void testDivide() {
        TComplex c1 = new TComplex(4, 2);
        TComplex c2 = new TComplex(3, -1);
        TComplex result = c1.divide(c2);
        new TComplex(1, 1).equals(result);
    }

    @Test
    public void testMod() {
        TComplex c = new TComplex(3, 4);
        assertEquals(5.0, c.mod(), 1e-9);
    }

    @Test
    public void testArgRad() {
        TComplex c = new TComplex(1, 1);
        assertEquals(Math.PI / 4, c.argRad(), 1e-9);
    }

    @Test
    public void testArgDeg() {
        TComplex c = new TComplex(1, 1);
        assertEquals(45, c.argDeg(), 1e-9);
    }

    @Test
    public void testEqualsAndNotEquals() {
        TComplex c1 = new TComplex(3, 4);
        TComplex c2 = new TComplex(3, 4);
        TComplex c3 = new TComplex(4, 3);
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertTrue(c1.notEquals(c3));
    }
}
