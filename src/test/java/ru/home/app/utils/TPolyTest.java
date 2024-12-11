package ru.home.app.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class TPolyTest {

    @Test
    public void testConstructorAndToString() {
        TPoly p1 = new TPoly(Arrays.asList(new TPoly.Term(3, 2), new TPoly.Term(1, 0))); // 3x^2 + 1
        TPoly p2 = new TPoly();
        assertEquals("3x^2 + 1", p1.toString());
        assertEquals("0", p2.toString());
    }

    @Test
    public void testAddition() {
        TPoly p1 = new TPoly(Arrays.asList(new TPoly.Term(3, 2), new TPoly.Term(1, 0))); // 3x^2 + 1
        TPoly p2 = new TPoly(Arrays.asList(new TPoly.Term(2, 2), new TPoly.Term(1, 1))); // 2x^2 + x
        TPoly p3 = p1.add(p2); // (3+2)x^2 + x + 1
        TPoly p4 = p1.add(new TPoly()); // p1 + 0 = p1

        assertEquals(5, p3.coefficient(2));
        assertEquals(1, p3.coefficient(1));
        assertEquals(1, p3.coefficient(0));

        assertEquals(3, p4.coefficient(2));
        assertEquals(1, p4.coefficient(0));
    }

    @Test
    public void testDifferentiation() {
        TPoly p = new TPoly(Arrays.asList(
                new TPoly.Term(3, 3),
                new TPoly.Term(2, 1),
                new TPoly.Term(5, 0)
        )); // 3x^3 + 2x + 5
        TPoly dp = p.differentiate(); // 9x^2 + 2

        assertEquals(9, dp.coefficient(2));
        assertEquals(0, dp.coefficient(1));
        assertEquals(2, dp.coefficient(0));
    }

    @Test
    public void testEvaluate() {
        TPoly p = new TPoly(Arrays.asList(
                new TPoly.Term(3, 2),
                new TPoly.Term(1, 0)
        )); // 3x^2 + 1

        assertEquals(13, p.evaluate(2)); // 3*2^2 + 1 = 13
        assertEquals(1, p.evaluate(0));  // 3*0^2 + 1 = 1
        assertEquals(4, p.evaluate(-1)); // 3*(-1)^2 + 1 = 4
    }
}