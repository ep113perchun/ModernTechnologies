package ru.home.app.types;

public class TPNumber {
    private final double n;
    private final int b;
    private final int c;

    /**
     * Конструктор, принимающий вещественное число, основание системы счисления и точность.
     *
     * @param a вещественное число
     * @param b основание системы счисления (2..16)
     * @param c точность представления (>= 0)
     * @throws IllegalArgumentException если основание системы счисления не в диапазоне [2..16] или точность < 0
     */
    public TPNumber(double a, int b, int c) {
        if (b < 2 || b > 16) {
            throw new IllegalArgumentException("Основание системы счисления должно быть в диапазоне [2..16].");
        }
        if (c < 0) {
            throw new IllegalArgumentException("Точность представления должна быть неотрицательной.");
        }
        this.n = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Конструктор, принимающий строковое представление числа, основание и точность.
     *
     * @param a строка с числовым значением
     * @param b строка, представляющая основание системы счисления (2..16)
     * @param c строка, представляющая точность (>= 0)
     * @throws IllegalArgumentException если основание или точность не соответствуют условиям
     */
    public TPNumber(String a, String b, String c) {
        this(Double.parseDouble(a), Integer.parseInt(b), Integer.parseInt(c));
    }

    /**
     * Метод для сложения двух P-ичных чисел с одинаковым основанием и точностью.
     *
     * @param d другое P-ичное число для сложения
     * @return новое P-ичное число, результат сложения
     */
    public TPNumber add(TPNumber d) {
        checkCompatibility(d);
        return new TPNumber(this.n + d.n, this.b, this.c);
    }

    /**
     * Метод для умножения двух P-ичных чисел с одинаковым основанием и точностью.
     *
     * @param d другое P-ичное число для умножения
     * @return новое P-ичное число, результат умножения
     */
    public TPNumber multiply(TPNumber d) {
        checkCompatibility(d);
        return new TPNumber(this.n * d.n, this.b, this.c);
    }

    /**
     * Метод для вычитания двух P-ичных чисел с одинаковым основанием и точностью.
     *
     * @param d другое P-ичное число для вычитания
     * @return новое P-ичное число, результат вычитания
     */
    public TPNumber subtract(TPNumber d) {
        checkCompatibility(d);
        return new TPNumber(this.n - d.n, this.b, this.c);
    }

    /**
     * Метод для деления двух P-ичных чисел с одинаковым основанием и точностью.
     * Предусловие: поле n числа d не должно быть равно 0.
     *
     * @param d другое P-ичное число для деления
     * @return новое P-ичное число, результат деления
     * @throws IllegalArgumentException если d равно 0
     */
    public TPNumber divide(TPNumber d) {
        checkCompatibility(d);
        if (d.n == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return new TPNumber(this.n / d.n, this.b, this.c);
    }

    /**
     * Метод для обращения числа (1/n).
     *
     * @return новое P-ичное число, результат обращения
     * @throws IllegalArgumentException если значение n равно 0
     */
    public TPNumber reciprocal() {
        if (this.n == 0) {
            throw new IllegalArgumentException("Обратное для нуля не существует.");
        }
        return new TPNumber(1 / this.n, this.b, this.c);
    }

    /**
     * Метод для возведения числа в квадрат.
     *
     * @return новое P-ичное число, результат возведения в квадрат
     */
    public TPNumber square() {
        return new TPNumber(this.n * this.n, this.b, this.c);
    }

    /**
     * Возвращает значение числа n.
     *
     * @return значение числа n
     */
    public double getNumber() {
        return this.n;
    }

    /**
     * Возвращает строковое представление числа n в системе счисления b с точностью c.
     *
     * @return строковое представление числа
     */
    public String getFormattedNumber() {
        String format = "%." + c + "f";
        return String.format(format, this.n);
    }

    /**
     * Возвращает основание системы счисления b.
     *
     * @return основание системы счисления
     */
    public int getBase() {
        return this.b;
    }

    /**
     * Возвращает строковое представление основания системы счисления b.
     *
     * @return строка, представляющая основание системы счисления
     */
    public String getBaseAsString() {
        return Integer.toString(this.b);
    }

    /**
     * Возвращает точность c.
     *
     * @return точность
     */
    public int getPrecision() {
        return this.c;
    }

    /**
     * Возвращает строковое представление точности c.
     *
     * @return строка, представляющая точность
     */
    public String getPrecisionAsString() {
        return Integer.toString(this.c);
    }

    /**
     * Проверка совместимости двух P-ичных чисел (одинаковые основания и точность).
     *
     * @param d другое P-ичное число
     * @throws IllegalArgumentException если числа имеют разные основания или точность
     */
    private void checkCompatibility(TPNumber d) {
        if (this.b != d.b || this.c != d.c) {
            throw new IllegalArgumentException("Числа должны иметь одинаковое основание и точность.");
        }
    }
}

