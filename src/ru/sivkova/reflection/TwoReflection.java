package ru.sivkova.reflection;

import ru.sivkova.annotations.Two;

/**
 * Класс, выводящий значения, указанные в аннотации {@link Two}
 */
public class TwoReflection {
    /**
     * Выводит значения полей, указанных в аннотации {@link Two}
     * над переданным объектом.
     * <p>
     * Выполняет проверку корректности значений аннотации:
     * <ul>
     *     <li>Свойство {@code first} не может быть null или пустой строкой</li>
     *     <li>Свойство {@code second} не может быть отрицательным числом</li>
     * </ul>
     * </p>
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Two}
     * @throws IllegalArgumentException если:
     *                                  <ul>
     *                                    <li>переданный объект null</li>
     *                                    <li>аннотация @Two не найдена над классом объекта</li>
     *                                    <li>свойство first равно null или пустой строке</li>
     *                                    <li>свойство second отрицательное число</li>
     *                                  </ul>
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

        String firstValue = annotation.first();
        int secondValue = annotation.second();

        if (firstValue == null || firstValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Свойство 'first' аннотации @Two не может быть null или пустой строкой");
        }

        if (secondValue < 0) {
            throw new IllegalArgumentException("Свойство 'second' аннотации @Two не может быть отрицательным. Значение: " + secondValue);
        }

        System.out.println(firstValue + " " + secondValue);
    }
}
