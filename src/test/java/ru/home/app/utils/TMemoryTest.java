package ru.home.app.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TMemoryTest {

    private TMemory<Integer> memory;

    @BeforeEach
    void setUp() {
        // Инициализируем память перед каждым тестом
        memory = new TMemory<>(0);
    }

    @Test
    void testInitialState() {
        // Тестирование начального состояния памяти (должно быть OFF и значение по умолчанию)
        assertEquals(MemoryState.OFF, memory.getMemoryState());
        assertEquals(0, memory.readNumber());
    }

    @Test
    void testStoreOperation() {
        // Тестирование операции записи в память
        memory.store(10);
        assertEquals(10, memory.readNumber());
        assertEquals(MemoryState.ON, memory.getMemoryState());
    }

    @Test
    void testClearOperation() {
        // Тестирование операции очистки памяти
        memory.store(10);
        memory.clear();
        assertEquals(0, memory.readNumber());
        assertEquals(MemoryState.OFF, memory.getMemoryState());
    }

    @Test
    void testAddWhenOff() {
        // Проверка, вызывает ли добавление исключение, если память выключена
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            memory.add(5);
        });

        assertTrue(exception.getMessage().contains("Memory is OFF"));
    }
}