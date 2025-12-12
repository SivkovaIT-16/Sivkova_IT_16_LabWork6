package ru.sivkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки методов, которые будут автоматически
 * вызваны через механизм рефлексии {@link ru.sivkova.annotations.Reflections.InvokeReflection#showInvoke(Object)}.
 * <p>
 * Может применяться к методам. Аннотация доступна во время исполнения(RetentionPolicy.RUNTIME).
 * </p>
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Invoke {
}
