package ru.home.app.utils;
import java.util.Optional;

/**
 * Перечисление для двухоперандных операций
 */
enum TOprtn {
    NONE,
    ADD,
    SUB,
    MUL,
    DVD
}

/**
 * Перечисление для однооперандных операций
 */
enum TFunc {
    NONE,
    REV,  // инверсия 1/x
    SQR   // возведение в квадрат
}

class TProc<T extends Number> {
    private T lop_res;  // Левый операнд и результат
    private T rop;      // Правый операнд
    private TOprtn operation = TOprtn.NONE; // Текущая операция

    public TProc(T initialValue) {
        this.lop_res = initialValue;
        this.rop = initialValue;
    }

    /**
     * Сброс процессора
     */
    public void reset() {
        lop_res = (T) (Number) 0;
        rop = (T) (Number) 0;
        operation = TOprtn.NONE;
    }

    /**
     * Установка левого операнда
     * @param value значение для левого операнда
     */
    public void setLopRes(T value) {
        this.lop_res = value;
    }

    /**
     * Установка правого операнда
     * @param value значение для правого операнда
     */
    public void setRop(T value) {
        this.rop = value;
    }

    /**
     * Установка операции
     * @param oprtn операция, которую нужно выполнить
     */
    public void setOperation(TOprtn oprtn) {
        this.operation = oprtn;
    }

    /**
     * Выполнение операции
     */
    public void runOperation() {
        switch (operation) {
            case ADD:
                lop_res = castResult(lop_res.doubleValue() + rop.doubleValue());
                break;
            case SUB:
                lop_res = castResult(lop_res.doubleValue() - rop.doubleValue());
                break;
            case MUL:
                lop_res = castResult(lop_res.doubleValue() * rop.doubleValue());
                break;
            case DVD:
                if (rop.doubleValue() != 0) {
                    lop_res = castResult(lop_res.doubleValue() / rop.doubleValue());
                } else {
                    throw new ArithmeticException("Деление на ноль!");
                }
                break;
            default:
                break;
        }
        operation = TOprtn.NONE;
    }

    /**
     * Выполнение функции
     * @param func функция, которую нужно выполнить
     */
    public void runFunction(TFunc func) {
        switch (func) {
            case SQR:
                rop = castResult(rop.doubleValue() * rop.doubleValue());
                break;
            case REV:
                if (rop.doubleValue() != 0) {
                    rop = castResult(1.0 / rop.doubleValue());
                } else {
                    throw new ArithmeticException("Деление на ноль!");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Приведение результата операции к исходному типу T.
     * @param result результат операции в виде double
     * @return результат, приведенный к типу T
     */
    @SuppressWarnings("unchecked")
    private T castResult(double result) {
        if (lop_res instanceof Integer) {
            return (T) Integer.valueOf((int) result);
        } else if (lop_res instanceof Double) {
            return (T) Double.valueOf(result);
        } else if (lop_res instanceof Float) {
            return (T) Float.valueOf((float) result);
        } else if (lop_res instanceof Long) {
            return (T) Long.valueOf((long) result);
        } else {
            throw new UnsupportedOperationException("Тип не поддерживается");
        }
    }

    /**
     * Получение состояния процессора
     * @return текущая операция
     */
    public TOprtn getState() {
        return operation;
    }

    /**
     * Получение текущего результата (левая часть)
     * @return значение левого операнда
     */
    public T getLopRes() {
        return lop_res;
    }

    /**
     * Получение правого операнда
     * @return значение правого операнда
     */
    public T getRop() {
        return rop;
    }
}