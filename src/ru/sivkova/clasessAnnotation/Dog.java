package ru.sivkova.clasessAnnotation;

import ru.sivkova.annotations.Mode;
import ru.sivkova.annotations.ToString;
import ru.sivkova.annotations.Validate;

/**
 * Класс, представляющий собаку.
 * </p>
 * Класс помечен двумя аннотациями:
 * <ul>
 *      <li> {@link ToString} - для использования в механизме формирования строкового представления. </li>
 *      <li> {@link Validate} - список классов, которые проверяются через механизм валидации. </li>
 * </ul>
 * </p>
 * @see ToString
 * @see Validate
 */
@ToString
@Validate({String.class, Integer.class})
public class Dog {
    /**
     * Кличка собаки - включена в строковое представление по умолчанию.
     */
    private String name;

    /**
     * Порода собаки - включена в строковое представление по умолчанию.
     */
    private String breed;

    /**
     * Возраст собаки - включен в строковое представление.
     */
    @ToString(Mode.NO)
    private int age;

    /**
     * Цвет собаки - включен в строковое представление по умолчанию.
     */
    private String color;

    /**
     * Возвращает имя собаки.
     *
     * @return имя собаки
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает породу собаки.
     *
     * @return порода собаки
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Возвращает возраст собаки.
     *
     * @return возраст собаки в годах
     */
    public int getAge() {
        return age;
    }

    /**
     * Возвращает цвет собаки.
     *
     * @return цвет собаки
     */
    public String getColor() {
        return color;
    }

    /**
     * Создает объект Dog с указанными параметрами.
     *
     * @param name кличка собаки
     * @param breed порода собаки
     * @param age возраст собаки в годах
     * @param color цвет собаки
     */
    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }
    /**
     * Создает объект Dog со значениями по умолчанию.
     */
    public Dog() {
        this.name = "Шарик";
        this.breed = "Лабрадор";
        this.age = 8;
        this.color = "Коричневый";
    }

    /**
     * Собака лает.
     */
    public void bark() {
        System.out.println(name + " говорит: Гав-гав!");
    }

    /**
     * Возвращает строковое представление объекта Dog.
     * <p>
     * Формат: "Собака {Имя = 'name', Порода = 'breed', Возраст = age лет, Цвет = 'color'}"
     * </p>
     *
     * @return строковое представление объекта Dog.
     */
    @Override
    public String toString() {
        return "Собака {Имя = '" + name + "', Порода = '" + breed + "', Возраст = " + age + " лет, Цвет = '" + color + "'}";
    }
}
