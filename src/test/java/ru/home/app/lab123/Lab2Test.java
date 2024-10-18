package ru.home.app.lab123;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Lab2Test {

    /**
     * Тестирует метод maxOfTwo, проверяя случай, когда первое число больше второго.
     */
    @Test
    public void testMaxOfTwoFirstGreater() {
        assertEquals(5, Lab2.maxOfTwo(5, 3));
    }

    /**
     * Тестирует метод maxOfTwo, проверяя случай, когда второе число больше первого.
     */
    @Test
    public void testMaxOfTwoSecondGreater() {
        assertEquals(7, Lab2.maxOfTwo(4, 7));
    }

    /**
     * Тестирует метод maxOfTwo, проверяя случай, когда оба числа равны.
     */
    @Test
    public void testMaxOfTwoEqual() {
        assertEquals(10, Lab2.maxOfTwo(10, 10));
    }

    /**
     * Тестирует метод sumByIndexSum на квадратной матрице.
     * Проверяется корректность суммы элементов на индексе i + j = cols - 1.
     */
    @Test
    public void testSumByIndexSumSquareMatrix() {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // A[0][2] + A[1][1] + A[2][0] = 3 + 5 + 7 = 15
        assertEquals(15.0, Lab2.sumByIndexSum(A));
    }

    /**
     * Тестирует метод sumByIndexSum на прямоугольной (неквадратной) матрице.
     */
    @Test
    public void testSumByIndexSumNonSquareMatrix() {
        int[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        // A[0][3] + A[1][2] + A[2][1] = 4 + 7 + 10 = 21
        assertEquals(21.0, Lab2.sumByIndexSum(A));
    }

    /**
     * Тестирует метод sumByIndexSum на матрице, состоящей из одной строки.
     */
    @Test
    public void testSumByIndexSumSingleRowMatrix() {
        int[][] A = {
                {5, 6, 7, 8}
        };
        // A[0][3] = 8
        assertEquals(8.0, Lab2.sumByIndexSum(A));
    }

    /**
     * Тестирует метод sumByIndexSum на матрице, состоящей из одного столбца.
     */
    @Test
    public void testSumByIndexSumSingleColumnMatrix() {
        int[][] A = {
                {1},
                {2},
                {3},
                {4}
        };
        // Только A[0][0] = 1
        assertEquals(1.0, Lab2.sumByIndexSum(A));
    }

    /**
     * Тестирует метод findMinAboveAntiDiagonal на квадратной матрице.
     * Проверяется, что минимальное значение на или выше побочной диагонали возвращается корректно.
     */
    @Test
    public void testFindMinAboveAntiDiagonalSquareMatrix() {
        double[][] A = {
                {3.0, 2.0, 1.0},
                {6.0, 5.0, 4.0},
                {9.0, 8.0, 7.0}
        };
        // Элементы на и выше побочной диагонали: {1.0, 5.0, 4.0, 9.0, 8.0}
        // Минимальное значение = 1.0
        assertEquals(1.0, Lab2.findMinAboveAntiDiagonal(A));
    }

    /**
     * Тестирует метод findMinAboveAntiDiagonal на неквадратной матрице.
     * Проверяется корректность поиска минимального значения.
     */
    @Test
    public void testFindMinAboveAntiDiagonalNonSquareMatrix() {
        double[][] A = {
                {10.0, 9.0, 8.0, 7.0},
                {6.0, 5.0, 4.0, 3.0},
                {2.0, 1.0, 0.0, -1.0}
        };
        // Элементы на и выше побочной диагонали: {7.0, 4.0, 3.0, 0.0, -1.0}
        // Минимальное значение = -1.0
        assertEquals(-1.0, Lab2.findMinAboveAntiDiagonal(A));
    }

    /**
     * Тестирует метод findMinAboveAntiDiagonal на матрице, где все элементы одинаковы.
     * Проверяется, что возвращается корректное минимальное значение.
     */
    @Test
    public void testFindMinAboveAntiDiagonalAllSameValues() {
        double[][] A = {
                {5.0, 5.0, 5.0},
                {5.0, 5.0, 5.0},
                {5.0, 5.0, 5.0}
        };
        // Все элементы на и выше побочной диагонали равны 5.0
        // Минимальное значение = 5.0
        assertEquals(5.0, Lab2.findMinAboveAntiDiagonal(A));
    }
}

