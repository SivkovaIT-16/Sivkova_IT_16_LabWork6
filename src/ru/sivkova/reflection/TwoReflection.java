package ru.sivkova.reflection;

import ru.sivkova.annotations.Two;

/**
 * Класс, выводящий значения, указанные в аннотации {@link Two}
 */
public class TwoReflection {
    /**
     * Выводит значения полей, указанных в аннотации {@link Two}
     * над переданным объектом.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Two}
     * @throws IllegalArgumentException если аннотация @Cache не найдена над классом объекта или переданный объект null.
     * @see Two
     */
    public static void showTwo(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }
        Class <?> myClass = object.getClass();
        Two annotation = myClass.getAnnotation(Two.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Two не найдена.");
        }
        System.out.println(annotation.first() + " " + annotation.second());
    }
}
