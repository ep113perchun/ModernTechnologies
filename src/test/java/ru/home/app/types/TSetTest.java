package ru.home.app.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TSetTest {
    private TSet s;

    @BeforeEach
    void setUp() {
        s = new TSet();
    }

    @Test
    void testAdd() {
        s.add(1);
        assertTrue(s.contains(1));
    }

    @Test
    void testRemove() {
        s.add(1);
        s.remove(1);
        assertFalse(s.contains(1));
    }

    @Test
    void testClear() {
        s.add(1);
        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    void testUnion() {
        TSet s1 = new TSet();
        TSet s2 = new TSet();
        s1.add(1);
        s2.add(2);
        Set<Object> result = s1.union(s2);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    @Test
    void testIntersection() {
        TSet s1 = new TSet();
        TSet s2 = new TSet();
        s1.add(1);
        s1.add(2);
        s2.add(2);
        Set<Object> result = s1.intersection(s2);
        assertEquals(Set.of(2), result);
    }

    @Test
    void testDifference() {
        TSet s1 = new TSet();
        TSet s2 = new TSet();
        s1.add(1);
        s1.add(2);
        s2.add(2);
        Set<Object> result = s1.difference(s2);
        assertEquals(Set.of(1), result);
    }

    @Test
    void testCount() {
        s.add(1);
        s.add(2);
        assertEquals(2, s.count());
    }

    @Test
    void testGetElement() {
        s.add(1);
        s.add(2);
        assertTrue(Set.of(1, 2).contains(s.getElement(0)));
        assertTrue(Set.of(1, 2).contains(s.getElement(1)));
    }

    @Test
    void testGetElementOutOfBounds() {
        s.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> s.getElement(2));
    }
}