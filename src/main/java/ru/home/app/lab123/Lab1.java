package ru.home.app.lab123;

public class Lab1 {

    /**
     * Суммирует элементы двух массивов одинаковой длины.
     *
     * @param a первый массив
     * @param b второй массив
     * @return массив, содержащий суммы соответствующих элементов массивов a и b
     * @throws IllegalArgumentException если массивы имеют разную длину
     */
    public static int[] sumArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Массивы должны быть одинаковой длины.");
        }

        int[] c = new int[a.length];
        for (int i = 0;
             i < a.length;
             i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    /**
     * Выполняет циклический сдвиг элементов массива влево на указанное число позиций.
     * Если shift отрицательный, сдвиг происходит вправо.
     *
     * @param arr массив вещественных чисел
     * @param shift количество позиций для сдвига
     */
    public static void shiftArrayLeft(double[] arr, int shift) {
        int length = arr.length;

        if (shift < 0) {
            shift = length + (shift % length);
        } else if (shift == 0) {
            return;
        } else {
            shift = shift % length;
        }

        double[] temp = new double[shift];

        // Копируем первые элементы
        System.arraycopy(arr, 0, temp, 0, shift);

        // Сдвигаем массив
        System.arraycopy(arr, shift, arr, 0, length - shift);

        // Вставляем в конец
        System.arraycopy(temp, 0, arr, length - shift, shift);
    }

    /**
     * Ищет первую позицию вхождения последовательности в массив.
     * Возвращает индекс начала последовательности или -1, если последовательность не найдена.
     *
     * @param vec исходный массив
     * @param seq последовательность для поиска
     * @return индекс начала вхождения последовательности, или -1, если последовательность не найдена
     * @throws IllegalArgumentException если длина последовательности больше длины массива
     */
    public static int findSequence(int[] vec, int[] seq) {
        if (seq.length > vec.length) {
            throw new IllegalArgumentException("Длина последовательности больше длины массива");
        }

        for (int i = 0; i <= vec.length - seq.length; i++) {
            boolean found = true;
            for (int j = 0; j < seq.length; j++) {
                if (vec[i + j] != seq[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}

