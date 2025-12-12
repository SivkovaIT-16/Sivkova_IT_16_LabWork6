package ru.sivkova.clasessAnnotation;

import ru.sivkova.annotations.Cache;
import ru.sivkova.annotations.Invoke;

/**
 * Класс, предоставляющий счётчик.
 * <p>
 * <ul>
 *      <li> Класс помечен аннотацией {@link Cache} - список областей, которые кэшируются. </li>
 *      <li> Несколько методов класса помечены аннотацией {@link Invoke}. </li>
 * </ul>
 * </p>
 * @see Invoke
 * @see Cache
 */
@Cache()
public class Counter {
    private int count;

    /**
     * Возвращает текущее значение счётчика.
     *
     * @return текущее значение счётчика
     */
    public int getCount() {
        return count;
    }

    /**
     * Устанавливает значение счётчика.
     *
     * @param count новое значение счётчика
     */
    public void setCount(int count) {
        this.count = count;
        System.out.println("Счётчик установлен на: " + count);
    }

    /**
     * Создает объект Counter с нулевым значением счётчика по умолчанию.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Увеличивает значение счётчика на единицу.
     * <p>
     * Метод помечен аннотацией {@link Invoke}, чтобы его можно было вызвать через механизм рефлексии.
     * </p>
     */
    @Invoke
    public void increment() {
        count++;
        System.out.println("Счётчик увеличен до: " + count);
    }

    /**
     * Сбрасывает значение счётчика в ноль.
     * <p>
     * Метод помечен аннотацией {@link Invoke}, чтобы его можно было вызвать через механизм рефлексии.
     * </p>
     */
    @Invoke
    public void reset() {
        count = 0;
        System.out.println("Счётчик сброшен на: " + count);
    }

    /**
     * Увеличивает значение счётчика на указанное число.
     * <p>
     * Этот метод НЕ помечен аннотацией {@link Invoke} и не будет
     * автоматически вызван обработчиком.
     * </p>
     *
     * @param value значение, на которое нужно увеличить счётчик
     */
    public void add(int value) {
        count += value;
        System.out.println("Счётчик увеличен на " + value + ": " + count);
    }

    /**
     * Выводит текущее значение счётчика в консоль.
     * <p>
     * Метод помечен аннотацией {@link Invoke}, чтобы его можно было вызвать через механизм рефлексии.
     * </p>
     */
    @Invoke
    public void printCount() {
        System.out.println("Текущее состояние счётчика: " + count);
    }
}
