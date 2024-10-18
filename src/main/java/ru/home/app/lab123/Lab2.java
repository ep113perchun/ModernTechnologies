package ru.home.app.lab123;

public class Lab2 {

    /**
     * Возвращает максимальное значение между двумя целыми числами.
     *
     * @param a первое целое число
     * @param b второе целое число
     * @return максимальное значение между a и b
     */
    public static int maxOfTwo(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Вычисляет сумму элементов двумерного массива, индексы которых суммируются до максимального индекса столбца.
     * Для элемента (i, j) проверяется условие i + j = cols - 1.
     *
     * @param A двумерный массив целых чисел
     * @return сумма элементов, индексы которых удовлетворяют условию
     */
    public static double sumByIndexSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int maxColIndex = cols - 1; // Максимальный индекс по столбцам
        double sum = 0;

        for (int i = 0; i < rows; i++) {
            int j = maxColIndex - i;
            if (j >= 0 && j < cols) { // Проверка на границы массива
                sum += A[i][j];
            }
        }

        return sum;
    }

    /**
     * Находит минимальное значение элементов двумерного массива, которые расположены на или выше побочной диагонали.
     * Побочная диагональ включает элементы, для которых выполняется i + j >= cols - 1.
     *
     * @param A двумерный массив вещественных чисел
     * @return минимальное значение элементов на или выше побочной диагонали
     */
    public static double findMinAboveAntiDiagonal(double[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        double minValue = Double.MAX_VALUE; // Инициализируем минимальное значение

        // Перебираем элементы на и выше побочной диагонали
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i + j >= cols - 1) { // Проверяем, находится ли элемент на или выше побочной диагонали
                    if (A[i][j] < minValue) {
                        minValue = A[i][j];
                    }
                }
            }
        }
        return minValue;
    }
}

