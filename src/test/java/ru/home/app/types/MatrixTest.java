package ru.home.app.types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testConstructorValidMatrix() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);
        assertNotNull(matrix);
    }

    @Test
    void testConstructorThrowsOnNullMatrix() {
        assertThrows(IllegalArgumentException.class, () -> new Matrix(null));
    }

    @Test
    void testAdd() {
        int[][] data1 = {{1, 2, 7}, {3, 4, 6}};
        int[][] data2 = {{5, 6, 2}, {7, 8, 9}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        Matrix result = matrix1.add(matrix2);

        assertArrayEquals(new int[][]{{6, 8, 9}, {10, 12, 15}}, result.getMatrix());
    }

    @Test
    void testAddThrowsOnDifferentSizes() {
        int[][] data1 = {{1, 2}};
        int[][] data2 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        assertThrows(IllegalArgumentException.class, () -> matrix1.add(matrix2));
    }

    @Test
    void testSubtract() {
        int[][] data1 = {{5, 6}, {7, 8}};
        int[][] data2 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        Matrix result = matrix1.subtract(matrix2);

        assertArrayEquals(new int[][]{{4, 4}, {4, 4}}, result.getMatrix());
    }

    @Test
    void testSubtractThrowsOnDifferentSizes() {
        int[][] data1 = {{1, 2}};
        int[][] data2 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        assertThrows(IllegalArgumentException.class, () -> matrix1.subtract(matrix2));
    }

    @Test
    void testMultiply() {
        int[][] data1 = {{1, 2}, {3, 4}};
        int[][] data2 = {{5, 6}, {7, 8}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        Matrix result = matrix1.multiply(matrix2);

        assertArrayEquals(new int[][]{{19, 22}, {43, 50}}, result.getMatrix());
    }

    @Test
    void testMultiplyThrowsOnIncompatibleSizes() {
        int[][] data1 = {{1, 2}};
        int[][] data2 = {{1, 2}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix2));
    }

    @Test
    void testEquals() {
        int[][] data1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data1);

        assertEquals(matrix1, matrix2);
    }

    @Test
    void testTranspose() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);

        Matrix result = matrix.transpose();

        assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, result.getMatrix());
    }

    @Test
    void testMinElement() {
        int[][] data = {{5, 2}, {3, 8}};
        Matrix matrix = new Matrix(data);

        int min = matrix.minElement();

        assertEquals(2, min);
    }

    @Test
    void testToString() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);

        String str = matrix.toString();

        assertEquals("[[1, 2], [3, 4]]", str);
    }

    @Test
    void testGetElement() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);

        int element = matrix.getElement(1, 1);

        assertEquals(4, element);
    }

    @Test
    void testGetElementThrowsOnInvalidIndex() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);

        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getElement(2, 1));
    }

    @Test
    void getRows() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);

        assertEquals(2, matrix.getRows());
    }

    @Test
    void getCols() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);

        assertEquals(2, matrix.getCols());
    }
}
