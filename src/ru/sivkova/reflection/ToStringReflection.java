package ru.sivkova.reflection;

import ru.sivkova.annotations.Mode;
import ru.sivkova.annotations.ToString;

import java.lang.reflect.Field;

/**
 * Класс, формирующий строковое представление объекта,
 * который определен аннотацией {@link ToString} и режимами {@link Mode}.
 */
public class ToStringReflection {
    /**
     * Выводит в консоль строковое представление переданного объекта.
     * <p>
     * Правила формирования строки:
     * <ul>
     *     <li> Если класс помечен аннотацией {@link ToString} со значением по умолчанию ({@link Mode#YES}),
     *     то все поля объекта включатся в строку</li>
     *      <li> Поля, помеченные {@link ToString} со значением {@link Mode#NO}, пропускаются</li>
     *      <li> Каждое поле выводится в формате {@code имя_поля = значение}</li>
     * </ul>
     * </p>
     * Если доступ к полю запрещен будет выброшено {@link RuntimeException}.
     *
     * @param obj Объект, класс которого должен быть проверен на наличие аннотации {@link ToString}
     * @throws IllegalArgumentException если переданный объект пуст.
     * @see ToString
     * @see Mode
     */
    public static void showToString(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> myClass = obj.getClass();
        ToString annotation = myClass.getAnnotation(ToString.class);

        if (annotation != null && annotation.value() == Mode.NO) {
            System.out.println(myClass.getSimpleName() + " {скрыто}");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(myClass.getSimpleName());
        stringBuilder.append(" { ");

        if (annotation == null || annotation.value().equals(Mode.YES)) {
            Field[] fields = myClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                ToString fieldAnnotation = field.getAnnotation(ToString.class);
                if (fieldAnnotation != null && fieldAnnotation.value() == Mode.NO) {
                    continue;
                }
                try {
                    stringBuilder.append(field.getName()).
                            append(" = ").
                            append(field.get(obj)).
                            append(" ");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        stringBuilder.append(" }");
        String result = stringBuilder.toString();

        System.out.println(result);
    }
}
