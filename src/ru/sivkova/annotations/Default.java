package ru.sivkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания класса по умолчанию.
 * <p>
 * Может применяться к типам(классам) и полям. Обработчик во время
 * программы считывает значение свойства {@code value} и выводит имя
 * указанного класса по умолчанию.
 * </p>
 */
@Target( {ElementType.TYPE, ElementType.FIELD} )
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Default {
    /**
     * Класс, который считается как значение по умолчанию.
     *
     * @return Тип(класс), указанный как значение по умолчанию.
     */
    Class<?> value();
}