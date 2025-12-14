import ru.sivkova.clasessAnnotation.Cat;
import ru.sivkova.clasessAnnotation.Counter;
import ru.sivkova.clasessAnnotation.Dog;
import ru.sivkova.clasessAnnotation.Fraction;
import ru.sivkova.reflection.*;
import ru.sivkova.validator.Validator;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        do {
            System.out.println("Введите номер задачи:\n" +
                    "0.Завершить программу.\n" +
                    "1.Аннотация @Invoke.\n" +
                    "2.Аннотация @Default.\n" +
                    "3.Аннотация @ToString.\n" +
                    "4.Аннотация @Validate.\n" +
                    "5.Аннотация @Two.\n" +
                    "6.Аннотация @Cache.\n" +
                    "7.Тест @Invoke.\n" +
                    "8.Тест @Two.");
            n = scanner.nextInt();
            scanner.nextLine();
            switch (n) {
                case 0: {
                    System.out.println("Программа завершена.");
                    break;
                }
                case 1: {
                    Counter counter = new Counter();
                    int m;
                    do {
                        m = inputInvoke();
                        switch (m) {
                            case 0:
                                System.out.println("Программа \"Аннотация Invoke\" завершена.");
                                break;
                            case 1:
                                try {
                                InvokeReflection.showInvoke(counter);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            case 2:
                                System.out.print("Введите значение для установки: ");
                                try {
                                    int value = Integer.parseInt(scanner.nextLine());
                                    counter.setCount(value);
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка: введите целое число!");
                                }
                                break;
                            case 3:
                                System.out.print("Введите число для добавления: ");
                                try {
                                    int value = Integer.parseInt(scanner.nextLine());
                                    counter.add(value);
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка: введите целое число!");
                                }
                                break;
                            default:
                                System.out.println("Введен неверный номер действия.");
                                break;
                        }
                    } while(m != 0);
                    System.out.println();
                    break;
                }
                case 2: {
                    try{
                        System.out.println("Класс Cat.");
                        Cat cat = new Cat();
                        cat.meow();
                        cat.play();
                        DefaultReflection.showDefault(cat);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    try{
                        System.out.println("Класс Counter.");
                        Counter counter = new Counter();
                        DefaultReflection.showDefault(counter);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    try {
                        Dog dog = new Dog();
                        dog.bark();
                        System.out.println("Стандартный toString(): " + dog);
                        System.out.print("Аннотированный toString(): ");
                        ToStringReflection.showToString(dog);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case 4: {
                    try {
                        System.out.println("Класс Dog.");
                        Dog dog = new Dog("Бобик", "Овчарка", 5, "Чёрный");
                        dog.bark();
                        ValidateReflection.showValidation(dog);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    try{
                        System.out.println("Класс Cat.");
                        Cat cat = new Cat("Мурзик", 4, "Чёрный");
                        cat.meow();
                        cat.play();
                        ValidateReflection.showValidation(cat);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.print("Введите имя кота: ");
                    String name = Validator.checkString();
                    System.out.print("Введите возраст кота: ");
                    int age = Validator.checkInteger();
                    System.out.print("Введите цвет кота: ");
                    String color = Validator.checkString();
                    try {
                        Cat cat = new Cat(name, age, color);
                        System.out.println("Создан кот: " + cat);
                        TwoReflection.showTwo(cat);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case 6: {
                    try {
                        Fraction fraction = new Fraction(3,4);
                        System.out.println("Класс Fraction.");
                        CacheReflection.showCache(fraction);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    try {
                        Counter counter = new Counter();
                        System.out.println("Класс Counter.");
                        CacheReflection.showCache(counter);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    try {
                        Cat cat = new Cat();
                        System.out.println("Класс Cat.");
                        CacheReflection.showCache(cat);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case 7: {
                    System.out.println("Для запуска тестирования аннотации @Invoke нужно перейти в ru/sivkova/tests/TestInvoke.\n");
                    break;
                }
                case 8: {
                    System.out.println("Для запуска тестирования аннотации @Two нужно перейти в ru/sivkova/tests/TestTwo.\n");
                    break;
                }
                default: {
                    System.out.println("Введен неверный номер задания.");
                    break;
                }
            }
        } while (n != 0);
    }

    private static int inputInvoke() {
        int m;
        System.out.println("Введите номер действия:\n" +
                "0.Завершить программу.\n" +
                "1.Автоматически вызвать все методы с @Invoke.\n" +
                "2.Установить значение счётчика.\n" +
                "3.Добавить значение.");
        m = scanner.nextInt();
        scanner.nextLine();
        return m;
    }
}