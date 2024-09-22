package ru.home.app.lab123;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Lab1Test {
    /**
     * Тестирует метод sumArrays на массивах одинаковой длины.
     * Ожидается корректный результат суммирования.
     */
    @Test
    public void testSumArraysEqualLength() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] expected = {5, 7, 9};
        assertArrayEquals(expected, Lab1.sumArrays(a, b));
    }

    /**
     * Тестирует метод sumArrays на массивах разной длины.
     * Ожидается выброс исключения IllegalArgumentException.
     */
    @Test
    public void testSumArraysDifferentLength() {
        int[] a = {1, 2};
        int[] b = {3, 4, 5};
        assertThrows(IllegalArgumentException.class, () -> Lab1.sumArrays(a, b));
    }

    /**
     * Тестирует метод shiftArrayLeft с положительным сдвигом.
     * Проверяет правильность циклического сдвига массива влево на 2 позиции.
     */
    @Test
    public void testShiftArrayLeft() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] expected = {3.0, 4.0, 5.0, 1.0, 2.0};
        Lab1.shiftArrayLeft(arr, 2);
        assertArrayEquals(expected, arr);
    }

    /**
     * Тестирует метод shiftArrayLeft при сдвиге на 0 позиций.
     * Ожидается, что массив останется без изменений.
     */
    @Test
    public void testShiftArrayLeftZeroShift() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] expected = {1.0, 2.0, 3.0, 4.0, 5.0};
        Lab1.shiftArrayLeft(arr, 0);
        assertArrayEquals(expected, arr);
    }

    /**
     * Тестирует метод shiftArrayLeft с отрицательным сдвигом.
     * Проверяет правильность циклического сдвига массива вправо на 2 позиции.
     */
    @Test
    public void testShiftArrayLeftNegativeShift() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] expected = {4.0, 5.0, 1.0, 2.0, 3.0};
        Lab1.shiftArrayLeft(arr, -2);
        assertArrayEquals(expected, arr);
    }

    /**
     * Тестирует метод findSequence на массиве, в котором есть искомая последовательность.
     * Ожидается возврат корректного индекса начала последовательности.
     */
    @Test
    public void testFindSequenceFound() {
        int[] vec = {1, 2, 3, 4, 5};
        int[] seq = {3, 4};
        assertEquals(2, Lab1.findSequence(vec, seq));
    }

    /**
     * Тестирует метод findSequence на массиве, в котором нет искомой последовательности.
     * Ожидается возврат -1.
     */
    @Test
    public void testFindSequenceNotFound() {
        int[] vec = {1, 2, 3, 4, 5};
        int[] seq = {6, 7};
        assertEquals(-1, Lab1.findSequence(vec, seq));
    }

    /**
     * Тестирует метод findSequence с пустой последовательностью.
     * Ожидается возврат 0, так как пустая последовательность всегда считается найденной в начале массива.
     */
    @Test
    public void testFindSequenceEmptySequence() {
        int[] vec = {1, 2, 3, 4, 5};
        int[] seq = {};
        assertEquals(0, Lab1.findSequence(vec, seq));
    }

    /**
     * Тестирует метод findSequence, когда длина последовательности больше длины массива.
     * Ожидается выброс исключения IllegalArgumentException.
     */
    @Test
    public void testFindSequenceEmptyVector() {
        int[] vec = {};
        int[] seq = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> Lab1.findSequence(vec, seq));
    }
}
