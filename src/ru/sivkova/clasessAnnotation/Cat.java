package ru.sivkova.clasessAnnotation;

import ru.sivkova.annotations.Default;
import ru.sivkova.annotations.Two;

/**
 * Класс, представляющий кота с возможностью мяукать и играть.
 * <p>
 * Класс помечен двумя аннотациями:
 * <ul>
 *      <li> {@link Default} - как класс по умолчанию. </li>
 *      <li> {@link Two}, где
 *      <ul>
 *          <li> first = имя кота. </li>
 *          <li> second = некоторое числовое представление (например возраст кота).</li>
 *      </ul> </li>
 * </ul>
 * </p>
 * @see Default
 * @see Two
 */
@Default(Cat.class)
@Two(first = "Снежок", second = 3)
public class Cat {
    private String name;
    private int age;
    private String color;

    /**
     * Возвращает имя кота.
     *
     * @return имя кота
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает возраст кота.
     *
     * @return возраст кота в годах
     */
    public int getAge() {
        return age;
    }

    /**
     * Возвращает цвет кота.
     *
     * @return цвет кота
     */
    public String getColor() {
        return color;
    }

    /**
     * Создает объект Cat с указанными параметрами.
     *
     * @param name имя кота
     * @param age возраст кота в годах
     * @param color цвет кота
     */
    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * Создает объект Cat со значениями по умолчанию.
     * <p>
     * Значения по умолчанию:
     * <ul>
     *     <li>Имя: "Барсик"</li>
     *     <li>Возраст: 2 года</li>
     *     <li>Цвет: "серый"</li>
     * </ul>
     * </p>
     */
    public Cat() {
        this.name = "Барсик";
        this.age = 2;
        this.color = "Рыжий";
    }

    /**
     * Кот мяукает.
     * <p>
     * Выводит сообщение с именем кота и его мяуканьем.
     * </p>
     */
    public void meow() {
        System.out.println(name + " говорит: Мяу-мяу!");
    }

    /**
     * Кот играет.
     * <p>
     * Выводит сообщение, что кот играет.
     * </p>
     */
    public void play() {
        System.out.println(name + " играет с мышкой!");
    }

    /**
     * Возвращает строковое представление объекта Cat.
     * <p>
     * Формат: "Кот [Имя], [Возраст] года/лет, цвет: [Цвет]"
     * </p>
     * @return строковое представление объекта Cat
     */
    @Override
    public String toString() {
        return "Кот " + name + ", " + age + " года" + ", цвет: " + color;
    }
}
