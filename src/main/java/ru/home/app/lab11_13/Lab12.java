package ru.home.app.lab11_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс для выполнения различных вычислений и операций с массивами.
 */
public class Lab12 {

    /**
     * Находит минимальный элемент в списке и возвращает его значение и индекс.
     *
     * @param vec список целых чисел
     * @return массив, содержащий минимальное значение и его индекс, или {Double.POSITIVE_INFINITY, -1} если список пуст
     */
    public static double[] findMin(List<Integer> vec) {
        if (vec.isEmpty()) {
            return new double[]{Double.POSITIVE_INFINITY, -1};
        }
        double minVal = vec.getFirst();
        int index = 0;
        for (int i = 1; i < vec.size(); i++) {
            if (vec.get(i) < minVal) {
                minVal = vec.get(i);
                index = i;
            }
        }
        return new double[]{minVal, index};
    }

    /**
     * Сортирует список методом пузырька.
     *
     * @param vec список целых чисел для сортировки
     */
    public static void bubbleSort(List<Integer> vec) {
        for (int i = 0; i < vec.size() - 1; i++) {
            for (int j = vec.size() - 1; j > i; j--) {
                if (vec.get(j) < vec.get(j - 1)) {
                    Collections.swap(vec, j, j - 1);
                }
            }
        }
    }

    /**
     * Выполняет бинарный поиск элемента в отсортированном списке.
     *
     * @param vec отсортированный список целых чисел
     * @param target целевое значение для поиска
     * @return индекс целевого значения, или -1 если оно не найдено
     */
    public static int binarySearch(List<Integer> vec, int target) {
        int left = 0, right = vec.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (vec.get(mid) == target) {
                return mid;
            } else if (vec.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Находит минимальный элемент в двумерном списке и возвращает его значение и координаты.
     *
     * @param matrix двумерный список целых чисел
     * @return массив, содержащий минимальное значение и его координаты, или {Double.POSITIVE_INFINITY, -1, -1} если список пуст
     */
    public static double[] findMin2D(List<List<Integer>> matrix) {
        if (matrix.isEmpty() || matrix.getFirst().isEmpty()) {
            return new double[]{Double.POSITIVE_INFINITY, -1, -1};
        }
        double minVal = matrix.getFirst().getFirst();
        int indexI = 0, indexJ = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) < minVal) {
                    minVal = matrix.get(i).get(j);
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        return new double[]{minVal, indexI, indexJ};
    }

    /**
     * Выполняет реверс списка.
     *
     * @param vec список целых чисел для реверса
     */
    public static void reverseList(List<Integer> vec) {
        Collections.reverse(vec);
    }

    /**
     * Выполняет циклический сдвиг списка на заданное количество позиций.
     *
     * @param vec список целых чисел для сдвига
     * @param positions количество позиций для сдвига
     */
    public static void cyclicShift(List<Integer> vec, int positions) {
        int size = vec.size();
        positions %= size;
        Collections.rotate(vec, positions);
    }

    /**
     * Заменяет значения в списке.
     *
     * @param arr список целых чисел
     * @param oldValue значение, которое нужно заменить
     * @param newValue новое значение для замены
     */
    public static void replaceValue(List<Integer> arr, int oldValue, int newValue) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == oldValue) {
                arr.set(i, newValue);
            }
        }
    }

    /**
     * Основная вычислительная функция с различными формулами и выводом результатов.
     *
     * @param udot значение удвоенного ресурса
     * @param u1 значение ресурса u1
     * @param u2 значение ресурса u2
     * @param N1 значение N1
     * @param N2 значение N2
     */
    public static void calc(double udot, double u1, double u2, double N1, double N2) {
        double S = 10;
        double V = (N1 + N2) * Math.log(u1 + u2) / Math.log(2);
        double Vdot = (2 + udot) * Math.log(2 + udot) / Math.log(2);
        double Lgalka = (2 / u1) * (u2 / N2);

        System.out.println("1. Информация, связанная с u1 и u2: " + (u1 * Math.log(u1) / Math.log(2) + u2 * Math.log(u2) / Math.log(2)));
        System.out.println("2. Объём информации Vdot: " + Vdot);
        System.out.println("3. Суммарный объём информации V: " + V);
        System.out.println("4. Отношение объёмов Vdot к V: " + (Vdot / V));
        System.out.println("5. Значение выражения Lгалка: " + Lgalka);
        System.out.println("6. Расширенное значение с учётом Lгалка и V: " + ((2 / u1) * (u2 / N2) * (N1 + N2) * Math.log(u1 + u2) / Math.log(2)));
        System.out.println("7. Квадратный коэффициент на основе V и Vdot: " + (V * V / (S * Vdot)));
        System.out.println("8. Комбинированное выражение для объёмов u1, u2: " + ((u1 * N2 * (u1 * Math.log(u1) / Math.log(2) + u2 * Math.log(u2) / Math.log(2)) * Math.log(u1 + u2) / Math.log(2)) / (2 * S * u2)));
        System.out.println("9. Комбинированное значение для u1, u2 и N: " + ((u1 * N2 * (N1 + N2) * Math.log(u1 + u2) / Math.log(2)) / (2 * S * u2)));
        System.out.println("10. Квадрат Lгалка умноженный на V: " + (Lgalka * Lgalka * V));
        System.out.println("11. Квадрат Vdot, делённый на V: " + (Vdot * Vdot / V));
    }

    public static void main(String[] args) {
        calc(3, 6, 4, 6, 6);
    }
}