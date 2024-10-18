package ru.home.app.lab123;

public class Lab3 {

    /**
     * Находит максимальное значение среди трёх целых чисел.
     *
     * @param a первое число
     * @param b второе число
     * @param c третье число
     * @return максимальное из трёх чисел
     */
    public static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    /**
     * Формирует число из чётных разрядов исходного числа, расположенных в обратном порядке.
     *
     * @param a исходное целое число
     * @return новое число, состоящее из чётных разрядов исходного числа в обратном порядке
     */
    public static int reverseEvenDigits(int a) {
        int b = 0;
        int multiplier = 1;

        while (a != 0) {
            int digit = a % 10;
            if (digit % 2 == 0) {
                b = b * 10 + digit;
            }
            a /= 10;
        }
        return b;
    }

    /**
     * Находит минимальную цифру числа.
     *
     * @param a исходное целое число
     * @return минимальная цифра числа
     */
    public static int findMinDigit(int a) {
        int minDigit = 9; // Максимально возможная цифра

        while (a != 0) {
            int digit = a % 10;
            if (digit < minDigit) {
                minDigit = digit;
            }
            a /= 10;
        }
        return minDigit;
    }

    /**
     * Находит сумму нечётных элементов, расположенных ниже главной диагонали двумерного массива.
     *
     * @param A двумерный массив целых чисел
     * @return сумма нечётных элементов под главной диагональю
     */
    public static int sumOddBelowMainDiagonal(int[][] A) {
        int sum = 0;
        int n = A.length;

        for (int i = 1; i < n; i++) { // Элементы под главной диагональю (i > j)
            for (int j = 0; j < i; j++) {
                if (A[i][j] % 2 != 0) {
                    sum += A[i][j];
                }
            }
        }
        return sum;
    }
}

