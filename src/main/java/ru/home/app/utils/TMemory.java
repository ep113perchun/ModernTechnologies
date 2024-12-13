package ru.home.app.utils;

/**
 * Перечисление для состояния памяти.
 */
class MemoryState {
    public static final String OFF = "_Off";
    public static final String ON = "_On";
}

/**
 * Класс TMemory представляет память для хранения числового значения
 * и управления состоянием памяти (включена/выключена).
 *
 * @param <T> тип данных для хранения в памяти, ограничен числовыми типами.
 */
class TMemory<T extends Number> {
    private T FNumber;

    private String FState;

    /**
     * Конструктор, инициализирующий память заданным числовым значением и устанавливающий состояние "Выключена".
     *
     * @param initialValue начальное значение для хранения в памяти.
     */
    public TMemory(T initialValue) {
        this.FNumber = initialValue;
        this.FState = MemoryState.OFF;
    }

    /**
     * Метод для записи значения в память и изменения состояния на "Включена".
     *
     * @param value значение, которое нужно записать в память.
     */
    public void store(T value) {
        this.FNumber = value;
        this.FState = MemoryState.ON;
    }

    /**
     * Метод для добавления значения к уже существующему в памяти числу.
     * Выбрасывает исключение, если память выключена.
     *
     * @param value значение, которое нужно добавить к существующему в памяти числу.
     * @throws IllegalStateException если память находится в состоянии "Выключена".
     */
    public void add(T value) {
        if (MemoryState.ON.equals(this.FState)) {
            this.FNumber = (T) (Double) (this.FNumber.doubleValue() + value.doubleValue());
        } else {
            throw new IllegalStateException("Memory is OFF. Cannot perform addition.");
        }
    }

    /**
     * Метод для очистки памяти и перевода ее в состояние "Выключена".
     * Значение в памяти устанавливается в 0, в зависимости от типа.
     */
    public void clear() {
        if (FNumber instanceof Double) {
            FNumber = (T) (Double) 0.0;
        } else if (FNumber instanceof Integer) {
            FNumber = (T) (Integer) 0;
        } else if (FNumber instanceof Float) {
            FNumber = (T) (Float) 0.0f;
        } else if (FNumber instanceof Long) {
            FNumber = (T) (Long) 0L;
        }
        FState = MemoryState.OFF;
    }

    /**
     * Метод для получения текущего состояния памяти (ON/OFF).
     *
     * @return текущее состояние памяти.
     */
    public String getMemoryState() {
        return this.FState;
    }

    /**
     * Метод для чтения текущего значения числа из памяти.
     *
     * @return текущее значение, хранящееся в памяти.
     */
    public T readNumber() {
        return this.FNumber;
    }
}