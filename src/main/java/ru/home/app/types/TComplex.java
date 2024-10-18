package ru.home.app.types;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TComplex implements Number{
    private double a; // Действительная часть
    private double b; // Мнимая часть

    /**
     * Конструктор для создания комплексного числа с действительной и мнимой частями.
     *
     * @param a действительная часть
     * @param b мнимая часть
     */
    public TComplex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Конструктор, который принимает строку в формате "a + i*b".
     *
     * @param str строковое представление комплексного числа
     * @throws IllegalArgumentException если строка имеет неверный формат
     */
    public TComplex(String str) throws IllegalArgumentException {
        str = str.replaceAll("\\s", "");

        String regex = "([+-]?\\d*\\.?\\d+)\\+i\\*([+-]?\\d*\\.?\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            this.a = Double.parseDouble(matcher.group(1));
            this.b = Double.parseDouble(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Неверный формат строки.");
        }
    }

    /**
     * Возвращает копию текущего комплексного числа.
     *
     * @return копия комплексного числа
     */
    @Override
    public TComplex copy() {
        return new TComplex(this.a, this.b);
    }

    /**
     * Складывает текущее комплексное число с другим комплексным числом.
     *
     * @param value комплексное число для сложения
     * @return результат сложения
     */
    @Override
    public TComplex add(Number value) {
        TComplex other = (TComplex) value;
        return new TComplex(this.a + other.a, this.b + other.b);
    }

    /**
     * Вычитает из текущего комплексного числа другое комплексное число.
     *
     * @param value комплексное число для вычитания
     * @return результат вычитания
     */
    @Override
    public TComplex subtract(Number value) {
        TComplex other = (TComplex) value;
        return new TComplex(this.a - other.a, this.b - other.b);
    }

    /**
     * Умножает текущее комплексное число на другое комплексное число.
     *
     * @param value комплексное число для умножения
     * @return результат умножения
     */
    @Override
    public TComplex multiply(Number value) {
        TComplex other = (TComplex) value;
        double real = this.a * other.a - this.b * other.b;
        double imaginary = this.a * other.b + this.b * other.a;
        return new TComplex(real, imaginary);
    }

    /**
     * Делит текущее комплексное число на другое комплексное число.
     *
     * @param value комплексное число для деления
     * @return результат деления
     */
    @Override
    public TComplex divide(Number value) {
        TComplex other = (TComplex) value;
        double denominator = other.a * other.a + other.b * other.b;
        double real = (this.a * other.a + this.b * other.b) / denominator;
        double imaginary = (this.b * other.a - this.a * other.b) / denominator;
        return new TComplex(real, imaginary);
    }

    /**
     * Возвращает строковое представление комплексного числа в формате "a + i*b".
     *
     * @return строковое представление комплексного числа
     */
    @Override
    public String toString() {
        return a + " + i*" + b;
    }

    /**
     * Возвращает модуль комплексного числа.
     *
     * @return модуль числа
     */
    public double mod() {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * Возвращает аргумент комплексного числа в радианах.
     *
     * @return угол в радианах
     */
    public double argRad() {
        return Math.atan2(b, a);
    }

    /**
     * Возвращает аргумент комплексного числа в градусах.
     *
     * @return угол в градусах
     */
    public double argDeg() {
        return Math.toDegrees(argRad());
    }

    /**
     * Возвращает вещественную часть числа.
     *
     * @return вещественная часть
     */
    public double getRe() {
        return this.a;
    }

    /**
     * Возвращает мнимую часть числа.
     *
     * @return мнимая часть
     */
    public double getIm() {
        return this.b;
    }

    /**
     * Проверяет равенство двух комплексных чисел.
     *
     * @param other другое комплексное число
     * @return true если числа равны, иначе false
     */
    public boolean equals(TComplex other) {
        return this.a == other.a && this.b == other.b;
    }

    /**
     * Проверяет неравенство двух комплексных чисел.
     *
     * @param other другое комплексное число
     * @return true если числа не равны, иначе false
     */
    public boolean notEquals(TComplex other) {
        return !this.equals(other);
    }
}
