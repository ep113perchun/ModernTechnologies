package ru.home.app.lab11_13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс ProgramMetrics содержит методы для моделирования и анализа метрик программы,
 * таких как длина программы, дисперсия, стандартное отклонение и другие параметры.
 * Также включает методы для анализа уникальных операторов и операндов в тексте программы.
 */
public class ProgramMetrics {

    /**
     * Моделирует процесс выборки элементов с возвратом для операторов и операндов.
     *
     * @param nOperators количество операторов в словаре программы
     * @param nOperands количество операндов в словаре программы
     * @return количество выборок, необходимых для того, чтобы получить все элементы в словаре хотя бы по одному разу
     */
    public static int simulateProgram(int nOperators, int nOperands) {
        List<Integer> vocabulary = new ArrayList<>();
        for (int i = 0; i < nOperators + nOperands; i++) {
            vocabulary.add(i);
        }

        Set<Integer> used = new HashSet<>();
        Random random = new Random();
        int numExtractions = 0;

        while (used.size() < vocabulary.size()) {
            int ticket = vocabulary.get(random.nextInt(vocabulary.size()));  // Выбор случайного элемента (оператор/операнд)
            used.add(ticket);
            numExtractions++;
        }

        return numExtractions;
    }

    /**
     * Вычисляет теоретические значения длины программы, дисперсии, стандартного отклонения и относительной ошибки.
     *
     * @param nOperators количество операторов в словаре программы
     * @param nOperands количество операндов в словаре программы
     * @return массив значений {ожидаемая длина, дисперсия, стандартное отклонение, относительная ошибка}
     */
    public static double[] calculateTheoreticalValues(int nOperators, int nOperands) {
        int totalVocabulary = nOperators + nOperands;

        // Математическое ожидание длины программы
        double expectedLength = 0.9 * totalVocabulary * (Math.log(totalVocabulary) / Math.log(2));

        // Дисперсия
        double variance = (Math.PI * Math.PI) * totalVocabulary / 6;

        // Среднеквадратическое отклонение
        double stdDev = Math.sqrt(variance);

        // Относительная ожидаемая погрешность
        double delta = 1 / (2 * Math.log(totalVocabulary) / Math.log(2));

        return new double[]{expectedLength, variance, stdDev, delta};
    }

    /**
     * Выполняет эксперименты для различных размеров словаря программы и выводит результаты
     * моделирования и теоретические значения метрик.
     */
    public static void runExperiments() {
        int[] vocabularies = {16, 32, 64, 128};  // Значения для различных словарей программы

        for (int totalVocabulary : vocabularies) {
            int nOperators = totalVocabulary / 2;
            int nOperands = totalVocabulary / 2;

            // Моделирование написания программы
            List<Integer> simulatedLengths = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                simulatedLengths.add(simulateProgram(nOperators, nOperands));
            }
            double avgSimulatedLength = simulatedLengths.stream().mapToInt(Integer::intValue).average().orElse(0);
            double varianceSimulated = simulatedLengths.stream().mapToDouble(len -> Math.pow(len - avgSimulatedLength, 2)).sum() / simulatedLengths.size();
            double stdDevSimulated = Math.sqrt(varianceSimulated);

            // Теоретические значения
            double[] theoreticalValues = calculateTheoreticalValues(nOperators, nOperands);
            double expectedLength = theoreticalValues[0];
            double varianceTheoretical = theoreticalValues[1];
            double stdDevTheoretical = theoreticalValues[2];
            double deltaTheoretical = theoreticalValues[3];

            // Вывод результатов для текущего словаря программы
            System.out.println("Размер словаря: " + totalVocabulary);
            System.out.println("Средняя длина программы (моделирование): " + avgSimulatedLength);
            System.out.println("Дисперсия длины программы (моделирование): " + varianceSimulated);
            System.out.println("Среднеквадратическое отклонение (моделирование): " + stdDevSimulated);
            System.out.println("Ожидаемая длина программы (теоретическое значение): " + expectedLength);
            System.out.println("Дисперсия (теоретическое значение): " + varianceTheoretical);
            System.out.println("Среднеквадратическое отклонение (теоретическое значение): " + stdDevTheoretical);
            System.out.println("Относительная ожидаемая погрешность (теоретическое значение): " + deltaTheoretical);
            System.out.println("-".repeat(50));
        }
    }

    /**
     * Анализирует код программы и подсчитывает уникальные операторы и операнды.
     *
     * @param code текст программы
     * @return массив, где первый элемент — количество уникальных операндов, второй — количество уникальных операторов
     */
    public static int[] countUniqueOperatorsOperands(String code) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/", "=", "==", ">", "<", ">=", "<="));
        Set<String> operands = new HashSet<>();

        String[] tokens = code.split("\\s+");  // Разбиение кода на отдельные элементы

        for (String token : tokens) {
            if (operators.contains(token)) {
                operands.add(token);
            }
        }

        return new int[]{operands.size(), operators.size()};
    }

    /**
     * Расчет длины программы на основе количества уникальных операторов и операндов в коде.
     *
     * @param code текст программы
     */
    public static void calculateCodeLength(String code) {
        int[] uniqueCounts = countUniqueOperatorsOperands(code);
        int uniqueOperators = uniqueCounts[0];
        int uniqueOperands = uniqueCounts[1];

        // Рассчитываем длину программы по формуле
        double estimatedLength = 0.9 * (uniqueOperators + uniqueOperands) * (Math.log(uniqueOperators + uniqueOperands) / Math.log(2));

        System.out.println("Уникальные операторы: " + uniqueOperators + ", Уникальные операнды: " + uniqueOperands);
        System.out.println("Оценочная длина программы на основе кода: " + estimatedLength);
    }

    /**
     * Главный метод программы.
     * Выполняет моделирование и анализирует уникальные операторы и операнды в текущем коде.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Запуск экспериментов
        runExperiments();

        // Анализ собственного кода программы
        try {
            String codeText = Files.readString(Paths.get("ProgramMetrics.java"));
            calculateCodeLength(codeText);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}