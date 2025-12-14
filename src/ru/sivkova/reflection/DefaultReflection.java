package ru.sivkova.reflection;

import ru.sivkova.annotations.Default;

public class DefaultReflection {
    /**
     * Выводит в консоль имя класса, указанного аннотацией {@link Default},
     * расположенного над классом переданного объекта.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Default}.
     * @throws IllegalArgumentException, если аннотация {@link Default} отсутствует или переданный объект null.
     * @see Default
     */
    public static void showDefault(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Переданный объект не может быть null");
        }

        Class<?> myClass = object.getClass();
        Default aDefault = myClass.getAnnotation(Default.class);

        if (aDefault == null) {
            throw new IllegalArgumentException("Аннотация @Default не найдена.");
        }
        System.out.println("Класс по умолчанию: " + aDefault.value().getSimpleName());
    }
}