package ru.sivkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки классов, данные которых могут быть закэшированы.
 * <p>
 * Массив строк в параметре {@code value} может использоваться для указания
 * конкретных имён кэшей, связанных с данным классом.
 * </p>
 */
@Target(value = ElementType.TYPE) @Retention(value= RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Набор имён кэшей или ключевых пространств,
     * в рамках которых должен работать данный класс.
     *
     * <p>
     * Если значение не указано, используется конфигурация по умолчанию.
     * </p>
     *
     * @return массив строковых идентификаторов кэшей.
     */
    String[] value() default {};
}