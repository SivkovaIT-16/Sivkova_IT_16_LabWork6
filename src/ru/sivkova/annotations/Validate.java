package ru.sivkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки классов или аннотаций,
 * которые будут входить в механизм валидации.
 *
 * </p>
 * Массив строк {@code value} может использоваться для указания
 * конкретных имен классов или аннотаций, которые будут включены
 * в проверку или обработку аннотации.
 * </p>
 */
@Target( {ElementType.TYPE, ElementType.ANNOTATION_TYPE} )
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * Массив классов, которые будут проверяться или использоваться
     * в механизме валидации.
     *
     * @return массив классов, включенных в данную аннотацию.
     */
    Class<?>[] value();
}