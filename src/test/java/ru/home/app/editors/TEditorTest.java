package ru.home.app.editors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TEditorTest {

    @Test
    void getComplexString() {
        TEditor editor = new TEditor();
        assertEquals("0, i*0", editor.getComplexString(), "По умолчанию строка должна быть представлением комплексного нуля.");
    }

    @Test
    void setComplexString() {
        TEditor editor = new TEditor();
        editor.setComplexString("5, i*2");
        assertEquals("5, i*2", editor.getComplexString(), "Метод setComplexString должен корректно обновлять строку.");
    }

    @Test
    void isZero() {
        TEditor editor = new TEditor();
        assertTrue(editor.isZero(), "По умолчанию комплексное число должно быть равно нулю.");

        editor.setComplexString("5, i*3");
        assertFalse(editor.isZero(), "Число '5, i*3' не является нулем.");
    }

    @Test
    void addSign() {
        TEditor editor = new TEditor();
        String result = editor.addSign();
        assertEquals("-0, i*0", result, "После добавления знака строка должна начинаться с '-'.");

        result = editor.addSign();
        assertEquals("0, i*0", result, "После повторного вызова знак '-' должен быть убран.");
    }

    @Test
    void addDigit() {
        TEditor editor = new TEditor();
        String result = editor.addDigit(5);
        assertEquals("0, i*05", result, "После добавления цифры 5 строка должна измениться.");
    }

    @Test
    void addDigit_invalid() {
        TEditor editor = new TEditor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            editor.addDigit(10);  // Неверная цифра
        });
        assertEquals("Цифра должна быть числом от 0 до 9", exception.getMessage(), "Должно выброситься исключение при вводе цифры вне диапазона.");
    }

    @Test
    void addZero() {
        TEditor editor = new TEditor();
        String result = editor.addZero();
        assertEquals("0, i*00", result, "После добавления нуля строка должна измениться.");
    }

    @Test
    void backspace() {
        TEditor editor = new TEditor();
        editor.setComplexString("5, i*3");
        String result = editor.backspace();
        assertEquals("5, i*", result, "После удаления последнего символа строка должна уменьшиться на 1 символ.");

        result = editor.backspace();
        assertEquals("5, i", result, "После удаления еще одного символа строка должна уменьшиться на 1 символ.");
    }

    @Test
    void clear() {
        TEditor editor = new TEditor();
        editor.setComplexString("5, i*3");
        String result = editor.clear();
        assertEquals("0, i*0", result, "Метод clear должен сбрасывать строку на представление комплексного нуля.");
    }

    @Test
    void edit_addSign() {
        TEditor editor = new TEditor();
        String result = editor.edit(1);  // Добавление знака
        assertEquals("-0, i*0", result, "Команда 1 должна добавить знак '-' перед строкой.");
    }

    @Test
    void edit_addDigit() {
        TEditor editor = new TEditor();
        editor.setComplexString("0, i*0");
        String result = editor.addDigit(3);
        assertEquals("0, i*03", result, "Команда добавления цифры должна добавить цифру к строке.");
    }

    @Test
    void edit_addZero() {
        TEditor editor = new TEditor();
        String result = editor.edit(3);  // Добавление нуля
        assertEquals("0, i*00", result, "Команда 3 должна добавить ноль к строке.");
    }

    @Test
    void edit_backspace() {
        TEditor editor = new TEditor();
        editor.setComplexString("5, i*3");
        String result = editor.edit(4);  // Удаление последнего символа
        assertEquals("5, i*", result, "Команда 4 должна удалить последний символ строки.");
    }

    @Test
    void edit_clear() {
        TEditor editor = new TEditor();
        editor.setComplexString("5, i*3");
        String result = editor.edit(5);  // Очистка строки
        assertEquals("0, i*0", result, "Команда 5 должна очистить строку до значения '0, i*0'.");
    }

    @Test
    void edit_invalidCommand() {
        TEditor editor = new TEditor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            editor.edit(99);  // Неверная команда
        });
        assertEquals("Недопустимая команда редактирования", exception.getMessage(), "Должно выброситься исключение для недопустимой команды.");
    }
}