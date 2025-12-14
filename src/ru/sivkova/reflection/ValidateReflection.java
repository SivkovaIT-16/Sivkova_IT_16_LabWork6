package ru.sivkova.reflection;

import ru.sivkova.annotations.Validate;

/**
 * Класс, выводящий имена классов, указанных в аннотации {@link Validate}.
 */
public class ValidateReflection {
    /**
     * Выводит имена классов, указанных в аннотации {@link Validate}
     * над переданным объектом.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Validate}
     * @throws IllegalArgumentException если:
     *                                  <ul>
     *                                    <li>переданный объект null</li>
     *                                    <li>аннотация @Validate не найдена над классом объекта</li>
     *                                    <li>аннотация @Validate содержит пустой массив классов</li>
     *                                  </ul>
     * @see Validate
     */
    public static void showValidation(Object object) {
        if (object == null) {
            System.out.println("Объект не может быть null");
            return;
        }

        Class <?> myClass = object.getClass();
        Validate annotation = myClass.getAnnotation(Validate.class);

        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Validate не найдена.");
        }
        Class<?>[] classes = annotation.value();

        if (classes.length == 0) {
            throw new IllegalArgumentException("Аннотация @Validate должна содержать как минимум один класс.");
        }

        for (Class<?> current : classes) {
            System.out.println(current.getSimpleName());
        }
    }
}
