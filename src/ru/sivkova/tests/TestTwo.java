package ru.sivkova.tests;

import org.junit.jupiter.api.Test;
import ru.sivkova.annotations.Two;
import ru.sivkova.reflection.TwoReflection;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Класс, проверяющий корректность обработки аннотации {@link Two}
 * при некорректно заданных свойствах.
 *
 * @see Two
 * @see TwoReflection
 */
public class TestTwo {
    /**
     * Вспомогательный класс с некорректными значениями аннотации {@link Two}.
     * <p>
     * Свойства аннотации заданы некорректно:
     * <ul>
     *     <li>{@code first = ""} - пустая строка</li>
     *     <li>{@code second = -1} - отрицательное число</li>
     * </ul>
     * </p>
     */
    @Two(first = "", second = -1)
    private static class InvalidTwoClass {

    }

    /**
     * Проверяет чтение некорректных значений аннотации {@link Two} через Reflection API.
     */
    @Test
    void testReadInvalidTwoAnnotationValues() {
        InvalidTwoClass invalidObject = new InvalidTwoClass();
        Two annotation = invalidObject.getClass().getAnnotation(Two.class);

        if (annotation == null) {
            throw new AssertionError("Аннотация @Two должна присутствовать на классе");
        }

        if (!"".equals(annotation.first())) {
            throw new AssertionError("Свойство first должно быть пустой строкой");
        }

        if (annotation.second() != -1) {
            throw new AssertionError("Свойство second должно быть -1");
        }
    }

    /**
     * Проверяет, что метод {@link TwoReflection#showTwo(Object)}
     * выбрасывает {@link IllegalArgumentException} при некорректных значениях аннотации.
     *
     * @see TwoReflection#showTwo(Object)
     */
    @Test
    void testInvalidTwoAnnotationThrowsException() {
        InvalidTwoClass invalidObject = new InvalidTwoClass();

        assertThrows(IllegalArgumentException.class, () -> TwoReflection.showTwo(invalidObject),
                "Метод showTwo() должен выбрасывать IllegalArgumentException при некорректных значениях аннотации");
    }
}
