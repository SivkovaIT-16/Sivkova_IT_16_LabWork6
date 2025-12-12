package ru.sivkova.reflection;

import ru.sivkova.annotations.Invoke;

import java.lang.reflect.Method;

/**
 * Класс, который выполняет все методы объекта,
 * помеченные аннотацией {@link Invoke}.
 */
public class InvokeReflection {
    /**
     * Вызывает все методы объекта, помеченные аннотацией {@link Invoke}
     * <p>
     *     Для каждого метода:
     *     <ul>
     *         <li> Делает метод доступным через {@code setAccessible(true)}</li>
     *         <li> Вызывает метод через {@code Method.invoke(object)}</li>
     *         <li> При возникновении исключения выводит сообщение в консоль</li>
     *     </ul>
     * </p>
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Invoke}
     * @throws IllegalArgumentException если переданный объект пуст.
     * @see Invoke
     */
    public static void showInvoke(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Переданный объект не может быть null");
        }
        Class<?> myClass = object.getClass();
        for (Method method : myClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.setAccessible(true);
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    System.out.println("Ошибка вызова метода: " + e.getMessage());
                }
            }
        }
    }
}
