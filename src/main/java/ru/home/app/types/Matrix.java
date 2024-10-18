package ru.home.app.types;

import java.util.Arrays;

public class Matrix {
    private final int[][] matrix;
    private final int rows;
    private final int cols;

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Конструктор матрицы.
     *
     * @param matrix  исходный двухмерный массив, представляющий матрицу.
     * @throws IllegalArgumentException если матрица нулевая, пустая или не квадратная.
     */
    public Matrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Матрица не должна быть пустой.");
        }
        this.rows = matrix.length;
        this.cols = matrix[0].length;

        for (int[] row : matrix) {
            if (row.length != cols) {
                throw new IllegalArgumentException("Количество столбцов в каждой строке должно совпадать.");
            }
        }

        this.matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, cols);
        }
    }

    /**
     * Метод для сложения двух матриц.
     *
     * @param other матрица для сложения.
     * @return новая матрица, полученная как сумма this и other.
     * @throws IllegalArgumentException если размеры матриц не совпадают.
     */
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для сложения.");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Метод для вычитания одной матрицы из другой.
     *
     * @param other матрица для вычитания.
     * @return новая матрица, полученная как разность this и other.
     * @throws IllegalArgumentException если размеры матриц не совпадают.
     */
    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для вычитания.");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Метод для умножения матриц.
     *
     * @param other матрица для умножения.
     * @return новая матрица, результат умножения.
     * @throws IllegalArgumentException если количество столбцов первой матрицы
     *                                  не совпадает с количеством строк второй матрицы.
     */
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно совпадать с количеством строк второй матрицы.");
        }

        int[][] result = new int[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    /**
     * Метод проверки равенства матриц.
     *
     * @param obj объект для сравнения с текущей матрицей.
     * @return true, если матрицы равны, false в противном случае.
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matrix other)) return false;

        return Arrays.deepEquals(this.matrix, other.matrix);
    }

    /**
     * Метод для транспонирования матрицы.
     *
     * @return новая транспонированная матрица.
     */
    public Matrix transpose() {
        if (rows != cols) {
            throw new IllegalArgumentException("Матрица должна быть квадратной.");
        }

        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return new Matrix(transposed);
    }

    /**
     * Метод для нахождения минимального элемента в матрице.
     *
     * @return минимальный элемент матрицы.
     */
    public int minElement() {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    /**
     * Преобразование матрицы в строку.
     *
     * @return строковое представление матрицы в формате {{1,2,3}, {4,5,6}, {7,8,9}}.
     */
    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }

    /**
     * Метод для получения элемента по индексу.
     *
     * @param i индекс строки.
     * @param j индекс столбца.
     * @return значение элемента с индексами i, j.
     * @throws IndexOutOfBoundsException если индексы находятся вне допустимого диапазона.
     */
    public int getElement(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException("Индексы находятся вне допустимого диапазона.");
        }
        return matrix[i][j];
    }

    /**
     *Возвращает число строк в матрице
     *
     * @return количество строк
     */
    public int getRows() {
        return rows;
    }

    /**
     *Возвращает число столбцов в матрице
     *
     * @return количество столбцов
     */
    public int getCols() {
        return cols;
    }
}

