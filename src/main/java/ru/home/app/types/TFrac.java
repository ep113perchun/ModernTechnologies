package ru.home.app.types;

/**
 * Класс TFrac представляет собой дробь (рациональное число) и поддерживает
 * основные арифметические операции с дробями.
 */
public class TFrac implements Number {
    private int numerator;  // числитель дроби
    private int denominator; // знаменатель дроби

    /**
     * Конструктор, создающий дробь с указанным числителем и знаменателем.
     *
     * @param numerator   числитель дроби
     * @param denominator знаменатель дроби
     * @throws Exception если знаменатель равен нулю
     */
    public TFrac(int numerator, int denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("ERROR: Denominator == 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /**
     * Конструктор, создающий дробь из строкового представления формата "numerator/denominator".
     *
     * @param frac строка, представляющая дробь
     * @throws Exception если знаменатель равен нулю или строка имеет неверный формат
     */
    public TFrac(String frac) throws Exception {
        String[] words = frac.split("/");
        this.numerator = Integer.parseInt(words[0]);
        this.denominator = Integer.parseInt(words[1]);

        if (denominator == 0) {
            throw new Exception("ERROR: Denominator == 0");
        }
        simplify();
    }

    /**
     * Возвращает строковое представление дроби в формате "numerator/denominator".
     *
     * @return строковое представление дроби
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Упрощает дробь, сокращая её на наибольший общий делитель (НОД).
     */
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Вычисляет наибольший общий делитель (НОД) двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return НОД a и b
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Возвращает копию текущей дроби.
     *
     * @return копия дроби
     * @throws Exception если знаменатель дроби равен нулю
     */
    @Override
    public TFrac copy() throws Exception {
        return new TFrac(numerator, denominator);
    }

    /**
     * Складывает текущую дробь с другой дробью.
     *
     * @param value объект класса Number, с которым выполняется сложение
     * @return результат сложения в виде нового объекта TFrac
     * @throws Exception если знаменатель равен нулю
     */
    @Override
    public TFrac add(Number value) throws Exception {
        if (value instanceof TFrac tFrac) {
            TFrac temp = new TFrac(
                    this.numerator * tFrac.denominator + this.denominator * tFrac.numerator,
                    this.denominator * tFrac.denominator
            );
            temp.simplify();
            return temp;
        } else {
            throw new IllegalArgumentException("Incompatible type for addition");
        }
    }

    /**
     * Вычитает из текущей дроби другую дробь.
     *
     * @param value объект класса Number, который вычитается
     * @return результат вычитания в виде нового объекта TFrac
     * @throws Exception если знаменатель равен нулю
     */
    @Override
    public TFrac subtract(Number value) throws Exception {
        if (value instanceof TFrac tFrac) {
            TFrac temp = new TFrac(
                    this.numerator * tFrac.denominator - this.denominator * tFrac.numerator,
                    this.denominator * tFrac.denominator
            );
            temp.simplify();
            return temp;
        } else {
            throw new IllegalArgumentException("Incompatible type for subtraction");
        }
    }

    /**
     * Умножает текущую дробь на другую дробь.
     *
     * @param value объект класса Number для умножения
     * @return результат умножения в виде нового объекта TFrac
     * @throws Exception если знаменатель равен нулю
     */
    @Override
    public TFrac multiply(Number value) throws Exception {
        if (value instanceof TFrac frac) {
            return new TFrac(
                    this.numerator * frac.numerator,
                    this.denominator * frac.denominator
            );
        } else {
            throw new IllegalArgumentException("Incompatible type for multiplication");
        }
    }

    /**
     * Делит текущую дробь на другую дробь.
     *
     * @param value объект класса Number для деления
     * @return результат деления в виде нового объекта TFrac
     * @throws Exception если знаменатель или числитель равен нулю
     */
    @Override
    public TFrac divide(Number value) throws Exception {
        if (value instanceof TFrac frac) {
            if (frac.numerator == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return new TFrac(
                    this.numerator * frac.denominator,
                    this.denominator * frac.numerator
            );
        } else {
            throw new IllegalArgumentException("Incompatible type for division");
        }
    }

    /**
     * Возвращает квадрат текущей дроби.
     *
     * @return новая дробь, представляющая квадрат текущей
     * @throws Exception если знаменатель равен нулю
     */
    public TFrac squared() throws Exception {
        int newNumerator = numerator * numerator;
        int newDenominator = denominator * denominator;
        return new TFrac(newNumerator, newDenominator);
    }

    /**
     * Возвращает обратную дробь (перевёрнутую).
     *
     * @return новая дробь, являющаяся обратной текущей
     * @throws Exception если числитель равен нулю
     */
    public TFrac reverse() throws Exception {
        return new TFrac(denominator, numerator);
    }

    /**
     * Возвращает отрицательную дробь (инвертирует знак числителя).
     *
     * @return новая дробь с инвертированным числителем
     * @throws Exception если знаменатель равен нулю
     */
    public TFrac minus() throws Exception {
        return new TFrac(-this.numerator, this.denominator);
    }

    /**
     * Проверяет равенство текущей дроби с другой дробью.
     *
     * @param value другая дробь для сравнения
     * @return true, если дроби равны; иначе false
     */
    public boolean isEqually(TFrac value) {
        this.simplify();
        value.simplify();
        return this.numerator == value.numerator && this.denominator == value.denominator;
    }

    /**
     * Проверяет, больше ли текущая дробь, чем другая дробь.
     *
     * @param value другая дробь для сравнения
     * @return true, если текущая дробь больше; иначе false
     */
    public boolean isMore(TFrac value) {
        return this.numerator * value.denominator > value.numerator * this.denominator;
    }

    /**
     * Возвращает числитель дроби.
     *
     * @return числитель дроби
     */
    public int takeNumeratorNumber() {
        return numerator;
    }

    /**
     * Возвращает знаменатель дроби.
     *
     * @return знаменатель дроби
     */
    public int takeDenominatorNumber() {
        return denominator;
    }

    /**
     * Возвращает числитель дроби в виде строки.
     *
     * @return строковое представление числителя
     */
    public String takeNumeratorString() {
        return numerator + "";
    }

    /**
     * Возвращает знаменатель дроби в виде строки.
     *
     * @return строковое представление знаменателя
     */
    public String takeDenominatorString() {
        return denominator + "";
    }

    /**
     * Возвращает строковое представление дроби в формате "numerator/denominator".
     *
     * @return строковое представление дроби
     */
    public String takeFracString() {
        return numerator + "/" + denominator;
    }
}
