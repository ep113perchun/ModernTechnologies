package ru.home.app.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TProcTest {

    private TProc<Integer> proc;

    @BeforeEach
    public void setUp() {
        proc = new TProc<>(0); // Начальное значение
    }

    @Test
    public void testAddOperation() {
        proc.setLopRes(2);
        proc.setRop(3);
        proc.setOperation(TOprtn.ADD);
        proc.runOperation();
        assertEquals(5, proc.getLopRes());
    }

    @Test
    public void testSubOperation() {
        proc.setLopRes(5);
        proc.setRop(3);
        proc.setOperation(TOprtn.SUB);
        proc.runOperation();
        assertEquals(2, proc.getLopRes());
    }

    @Test
    public void testMulOperation() {
        proc.setLopRes(2);
        proc.setRop(3);
        proc.setOperation(TOprtn.MUL);
        proc.runOperation();
        assertEquals(6, proc.getLopRes());
    }

    @Test
    public void testDvdOperation() {
        proc.setLopRes(6);
        proc.setRop(3);
        proc.setOperation(TOprtn.DVD);
        proc.runOperation();
        assertEquals(2, proc.getLopRes());
    }

    @Test
    public void testDvdByZero() {
        proc.setLopRes(6);
        proc.setRop(0);
        proc.setOperation(TOprtn.DVD);
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            proc.runOperation();
        });
        assertTrue(exception.getMessage().contains("Деление на ноль!"));
    }

    @Test
    public void testSqrFunction() {
        proc.setRop(4);
        proc.runFunction(TFunc.SQR);
        assertEquals(16, proc.getRop());
    }

    @Test
    public void testRevByZero() {
        proc.setRop(0);
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            proc.runFunction(TFunc.REV);
        });
        assertTrue(exception.getMessage().contains("Деление на ноль!"));
    }
}