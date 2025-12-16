package ru.sivkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, предназначенная для указания двух значений:
 * строкового {@link #first()} и целочисленного {@link #second()}
 * <p>
 * Может быть применена к классам. Доступна во время выполнения (RetentionPolicy.RUNTIME).
 * </p>
 */
@Target(value = ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Строковое значение, которое будет храниться в аннотации.
     *
     * @return строковое значение.
     */
    String first();

    /**
     * Целочисленное значение, которое будет храниться в аннотации.
     *
     * @return целочисленное значение.
     */
    int second();
}
