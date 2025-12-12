package ru.sivkova.validator;

import ru.sivkova.clasessAnnotation.Fraction;

import java.util.Scanner;

public class Validator {
    private static Scanner scanner = new Scanner(System.in);

    public static int checkInteger() {
        int number;
        String str;
        while (true) {
            str = scanner.nextLine();
            try {
                number = Integer.parseInt(str);
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено неверное число.");
                System.out.print("Введите целое число: ");
            }
        }
        return number;
    }

    public static String checkString() {
        String str;
        boolean valid;

        while (true) {
            str = scanner.nextLine();
            if (str != null) {
                str = str.trim();
            }

            // Проверка на пустую строку после trim()
            if (str == null || str.isEmpty()) {
                System.out.println("Ошибка. Строка не может быть пустой.");
                System.out.print("Введите новое значение: ");
                continue;
            }

            valid = true;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!Character.isLetter(ch) && ch != ' ' && ch != '-' && ch != '.') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                System.out.println();
                return str;
            } else {
                System.out.println("Ошибка. Строка должна состоять только из букв, пробелов, '-' или '.'.");
                System.out.print("Введите новое значение: ");
            }
        }
    }
    public static void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
    }

    public static void validateFractionNull(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("Дробь не может быть null");
        }
    }
    public static void validateFraction(Fraction fraction) {
        if (fraction.getNumerator() == 0) {
            throw new ArithmeticException("Деление на нулевую дробь.");
        }
    }

    public static void validateNumber(int number) {
        if (number == 0) {
            throw new ArithmeticException("Деление на ноль.");
        }
    }
}
