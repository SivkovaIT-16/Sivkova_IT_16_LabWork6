package ru.sivkova.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sivkova.annotations.Invoke;
import ru.sivkova.clasessAnnotation.Counter;

import java.lang.reflect.Method;

/**
 * Класс, проверяющий корректность вызова методов, отмеченных аннотацией {@link Invoke}.
 * @see Invoke
 * @see Counter
 */
public class TestInvoke {
    private Counter counter;
    /**
     * Подготовка тестируемого экземпляра класса перед каждым тестом.
     * Используется аннотация {@link BeforeEach} для инициализации объекта {@link Counter}
     * перед выполнением каждого тестового метода.
     */
    @BeforeEach
    void setUp() {
        counter = new Counter();
    }

    /**
     * Проверяет поиск методов с аннотацией {@link Invoke} через Reflection API.
     * <p>
     * Тест использует механизм рефлексии для получения всех методов класса {@link Counter}
     * и подсчёта количества методов, помеченных аннотацией {@link Invoke}.
     * Ожидается, что будет найдено ровно 3 метода с данной аннотацией:
     * {@link Counter#increment()}, {@link Counter#reset()}, {@link Counter#printCount()}.
     * </p>
     * @throws AssertionError если количество найденных методов с аннотацией не равно 3
     */
    @Test
    void testFindMethodsWithInvokeAnnotation() {
        Method[] methods = counter.getClass().getDeclaredMethods();

        int count = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                count++;
            }
        }

        if (count != 3) {
            throw new AssertionError("Ожидалось 3 метода с @Invoke, найдено: " + count);
        } else {
            System.out.println("Поиск методов с аннотацией @Invoke выполнен корректно.\n" +
                    "Найдено " + count + " из 3 методов.");
        }
    }

    /**
     * Проверяет, что все методы, помеченные аннотацией {@link Invoke},
     * выполняются без исключений при вызове через механизм рефлексии.
     * <p>
     * Тест использует Reflection API для получения всех методов класса {@link Counter},
     * фильтрует методы с аннотацией {@link Invoke} и вызывает каждый из них.
     * Успешное выполнение теста означает, что ни один из аннотированных методов
     * не выбрасывает исключений при вызове.
     * </p>
     * @throws AssertionError если любой из методов с аннотацией {@link Invoke}
     *                        выбрасывает исключение при вызове
     */
    @Test
    void testInvokeMethodsExecuteWithoutExceptions() {
        Method[] methods = counter.getClass().getDeclaredMethods();

        System.out.println("Проверка вызова всех методов.");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.invoke(counter);
                } catch (Exception e) {
                    throw new AssertionError("Метод " + method.getName() + " выбросил исключение: " + e.getMessage());
                }
            }
        }
    }
    /**
     * Проверяет, что методы с аннотацией {@link Invoke} изменяют состояние объекта
     * в соответствии с ожиданиями и возвращают корректные значения.
     * <p>
     * Начальное значение счётчика установлено на 5.
     * </p>
     * @throws AssertionError если:
     *                        <ul>
     *                          <li>метод {@link Counter#increment()} не увеличивает счётчик на 1</li>
     *                          <li>метод {@link Counter#reset()} не сбрасывает счётчик в 0</li>
     *                          <li>любой из методов выбрасывает исключение при вызове</li>
     *                        </ul>
     */
    @Test
    void testInvokeMethodsChangeObjectState() {
        counter.setCount(5);
        int initialCount = counter.getCount();

        System.out.println("Проверка, что возвращаемые значения соответствуют ожиданиям.");

        try {
            Method printCountMethod = counter.getClass().getMethod("printCount");
            printCountMethod.invoke(counter);
        } catch (Exception e) {
            throw new AssertionError("Ошибка при вызове printCount(): " + e.getMessage());
        }
        try {
            Method incrementMethod = counter.getClass().getMethod("increment");
            incrementMethod.invoke(counter);
        } catch (Exception e) {
            throw new AssertionError("Ошибка при вызове increment(): " + e.getMessage());
        }

        if (counter.getCount() != initialCount + 1) {
            throw new AssertionError("Метод increment() должен увеличить счётчик на 1");
        }

        try {
            Method resetMethod = counter.getClass().getMethod("reset");
            resetMethod.invoke(counter);
        } catch (Exception e) {
            throw new AssertionError("Ошибка при вызове reset(): " + e.getMessage());
        }

        // Проверяем побочный эффект
        if (counter.getCount() != 0) {
            throw new AssertionError("Метод reset() должен сбросить счётчик в 0");
        }
    }
}
