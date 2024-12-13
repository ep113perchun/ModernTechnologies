package ru.home.app.editors;

public class TEditor {
    private static final String REAL_IMAG_SEPARATOR = ", i*"; // Разделитель действительной и мнимой частей
    private static final String ZERO_REPRESENTATION = "0" + REAL_IMAG_SEPARATOR + "0"; // Представление комплексного нуля

    /**
    Строка для хранения текущего представления комплексного числа
     **/
    private String complexString;

    /**
    Конструктор
     **/
    public TEditor() {
        this.complexString = ZERO_REPRESENTATION;
    }

    /**
    Геттер для строкового представления комплексного числа
     **/
    public String getComplexString() {
        return complexString;
    }

    /**
    Сеттер для строкового представления комплексного числа
     **/
    public void setComplexString(String newValue) {
        this.complexString = newValue;
    }

    /**
    Проверяет, является ли число комплексным нулем
     **/
    public boolean isZero() {
        return this.complexString.equals(ZERO_REPRESENTATION);
    }

    /**
    Добавляет или убирает знак '-' перед действительной частью
     **/
    public String addSign() {
        if (this.complexString.startsWith("-")) {
            this.complexString = this.complexString.substring(1); // Убираем знак
        } else {
            this.complexString = "-" + this.complexString; // Добавляем знак
        }
        return this.complexString;
    }

    /**
    Добавляет цифру к текущей строке
     **/
    public String addDigit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("Цифра должна быть числом от 0 до 9");
        }
        this.complexString += digit;
        return this.complexString;
    }

    /**
    Добавляет ноль в строку
     **/
    public String addZero() {
        this.complexString += "0";
        return this.complexString;
    }

    /**
    Удаляет последний символ в строке
     **/
    public String backspace() {
        if (!this.complexString.isEmpty()) {
            this.complexString = this.complexString.substring(0, this.complexString.length() - 1);
        }
        return this.complexString;
    }

    /**
    Устанавливает строковое представление на комплексный ноль
     **/
    public String clear() {
        this.complexString = ZERO_REPRESENTATION;
        return this.complexString;
    }

    /**
    Редактирует строку на основе команды
     **/
    public String edit(int command) {
        return switch (command) {
            case 1 -> // Добавить знак
                    addSign();
            case 2 -> {
                int digit = getDigitFromInput(); // Метод для ввода цифры (создан ниже)
                yield addDigit(digit); // Метод для ввода цифры (создан ниже)
            }
            case 3 -> // Добавить ноль
                    addZero();
            case 4 -> // Забой символа
                    backspace();
            case 5 -> // Очистить строку
                    clear();
            default -> throw new IllegalArgumentException("Недопустимая команда редактирования");
        };
    }

    /**
    Метод для запроса цифры у пользователя
     **/
    private int getDigitFromInput() {
        // Используем Scanner для получения цифры от пользователя
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите цифру от 0 до 9: ");
        int digit = scanner.nextInt();
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("Цифра должна быть числом от 0 до 9");
        }
        return digit;
    }
}
