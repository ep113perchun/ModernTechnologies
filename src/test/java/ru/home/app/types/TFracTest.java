package ru.home.app.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TFracTest {

    @Test
    void copy() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("5/3", temp.copy().toString());
    }

    @Test
    void addUp() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("29/12", temp.addUp(new TFrac("6/8")).toString());
    }

    @Test
    void subtract() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("11/12", temp.subtract(new TFrac("6/8")).toString());
    }

    @Test
    void multiplyBy() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("5/4", temp.multiplyBy(new TFrac("6/8")).toString());
    }

    @Test
    void divideBy() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("20/9", temp.divideBy(new TFrac("6/8")).toString());
    }

    @Test
    void squared() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("25/9", temp.squared().toString());
    }

    @Test
    void reverse() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("3/5", temp.reverse().toString());
    }

    @Test
    void minus() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("-5/3", temp.minus().toString());
    }

    @Test
    void isEqually() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertTrue(temp.isEqually(new TFrac(5, 3)));
    }

    @Test
    void isMore() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertTrue(temp.isMore(new TFrac(4, 3)));
    }

    @Test
    void takeNumeratorNumber() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals(5, temp.takeNumeratorNumber());
    }

    @Test
    void takeDenominatorNumber() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals(3, temp.takeDenominatorNumber());
    }

    @Test
    void takeNumeratorString() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("5", temp.takeNumeratorString());
    }

    @Test
    void takeDenominatorString() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("3", temp.takeDenominatorString());
    }

    @Test
    void takeFracString() throws Exception {
        TFrac temp = new TFrac("5/3");
        assertEquals("5/3", temp.takeFracString());
    }
}