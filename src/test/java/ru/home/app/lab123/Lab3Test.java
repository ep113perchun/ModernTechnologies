package ru.home.app.lab123;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Lab3Test {

    /**
     * Тест проверяет, что первый аргумент является максимальным.
     */
    @Test
    public void testMaxOfThreeFirstIsMax() {
        assertEquals(10, Lab3.maxOfThree(10, 5, 7));
    }

    /**
     * Тест проверяет, что второй аргумент является максимальным.
     */
    @Test
    public void testMaxOfThreeSecondIsMax() {
        assertEquals(15, Lab3.maxOfThree(10, 15, 7));
    }

    /**
     * Тест проверяет, что третий аргумент является максимальным.
     */
    @Test
    public void testMaxOfThreeThirdIsMax() {
        assertEquals(20, Lab3.maxOfThree(10, 5, 20));
    }

    /**
     * Тест проверяет, что максимальное значение возвращается при равенстве всех трёх аргументов.
     */
    @Test
    public void testMaxOfThreeAllEqual() {
        assertEquals(10, Lab3.maxOfThree(10, 10, 10));
    }

    /**
     * Тест проверяет, что метод возвращает чётные цифры в обратном порядке.
     */
    @Test
    public void testReverseEvenDigitsWithEvenDigits() {
        assertEquals(42, Lab3.reverseEvenDigits(12345));
    }

    /**
     * Тест проверяет, что метод возвращает 0, если в числе нет чётных цифр.
     */
    @Test
    public void testReverseEvenDigitsWithNoEvenDigits() {
        assertEquals(0, Lab3.reverseEvenDigits(13579));
    }

    /**
     * Тест проверяет, что метод правильно обрабатывает число, содержащее только чётные цифры.
     */
    @Test
    public void testReverseEvenDigitsAllEvenDigits() {
        assertEquals(8642, Lab3.reverseEvenDigits(2468));
    }

    /**
     * Тест проверяет, что метод возвращает 0 при входном значении 0.
     */
    @Test
    public void testReverseEvenDigitsWithZero() {
        assertEquals(0, Lab3.reverseEvenDigits(0));
    }

    /**
     * Тест проверяет, что метод находит минимальную цифру в обычном числе.
     */
    @Test
    public void testFindMinDigitRegularNumber() {
        assertEquals(2, Lab3.findMinDigit(62543));
    }

    /**
     * Тест проверяет, что метод корректно работает с однозначными числами.
     */
    @Test
    public void testFindMinDigitWithSingleDigit() {
        assertEquals(4, Lab3.findMinDigit(4));
    }

    /**
     * Тест проверяет, что метод корректно работает с числами, где все цифры одинаковы.
     */
    @Test
    public void testFindMinDigitWithAllSameDigits() {
        assertEquals(7, Lab3.findMinDigit(77777));
    }

    /**
     * Тест проверяет, что метод корректно находит минимальную цифру, если в числе есть 0.
     */
    @Test
    public void testFindMinDigitWithZeroInMiddle() {
        assertEquals(0, Lab3.findMinDigit(90876));
    }

    /**
     * Тест проверяет сумму нечётных элементов под главной диагональю в матрице, содержащей нечётные числа.
     */
    @Test
    public void testSumOddBelowMainDiagonalWithOddNumbers() {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(7, Lab3.sumOddBelowMainDiagonal(A));
    }

    /**
     * Тест проверяет, что метод возвращает 0, если в матрице под главной диагональю нет нечётных чисел.
     */
    @Test
    public void testSumOddBelowMainDiagonalWithNoOddNumbers() {
        int[][] A = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        assertEquals(0, Lab3.sumOddBelowMainDiagonal(A));
    }

    /**
     * Тест проверяет матрицу, состоящую из одного элемента.
     */
    @Test
    public void testSumOddBelowMainDiagonalSingleElementMatrix() {
        int[][] A = {
                {5}
        };
        assertEquals(0, Lab3.sumOddBelowMainDiagonal(A));
    }

    /**
     * Тест проверяет работу метода с матрицей, содержащей как чётные, так и нечётные числа под главной диагональю.
     */
    @Test
    public void testSumOddBelowMainDiagonalMixedOddAndEven() {
        int[][] A = {
                {2, 3, 4},
                {1, 5, 6},
                {7, 8, 9}
        };
        assertEquals(8, Lab3.sumOddBelowMainDiagonal(A));
    }
}

