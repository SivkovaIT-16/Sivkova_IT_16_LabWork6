package ru.sivkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, для управления тем, должно ли поле или класс участвовать
 * в формировании строкового представления объекта.
 *
 * <p>
 * Может применяться к типам (классам) и полям.
 * Обработчик во время выполнения программы анализирует
 * свойства {@code value} и включает поле или класс в строковое
 * представление объекта если указано {@link Mode#YES}
 * </p>
 */
@Target( {ElementType.TYPE, ElementType.FIELD} )
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Определяет, нужно ли включать объект в строковое представление.
     *
     * @return значение режима - YES или NO.
     */
    Mode value() default Mode.YES;
}
