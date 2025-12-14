package ru.sivkova.reflection;

import ru.sivkova.annotations.Cache;

import java.util.Arrays;

/**
 * Класс, выводящий список всех кэшируемых областей,
 * указанных в аннотации {@link Cache}.
 */
public class CacheReflection {
    /**
     * Выводит в консоль список областей, указанных в аннотации {@link Cache},
     * расположенных над классом переданного объекта.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Cache}
     * @throws IllegalArgumentException если:
     *                                 <ul>
     *                                    <li>переданный объект null</li>
     *                                    <li>аннотация @Cache не найдена над классом объекта</li>
     *                                    <li>Список кэшируемых областей пуст</li>
     *                                 </ul>
     * @see Cache
     */
    public static void showCache(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Переданный объект не может быть null");
        }

        Class <?> myClass = object.getClass();
        Cache cache = myClass.getAnnotation(Cache.class);

        if (cache == null) {
            throw new IllegalArgumentException("Аннотация @Cache не найдена.");
        }

        String[] areas = cache.value();

        if (areas.length == 0) {
            throw new IllegalArgumentException("Список кэшируемых областей пуст.");
        } else {
            System.out.println("Кэшируемые области: " + Arrays.toString(areas));
        }
    }
}
