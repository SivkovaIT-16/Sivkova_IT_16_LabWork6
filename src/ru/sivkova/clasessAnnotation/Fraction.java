package ru.sivkova.clasessAnnotation;

import ru.sivkova.annotations.Cache;
import ru.sivkova.validator.Validator;

/**
 * Класс, представляющий обыкновенную дробь.
 * <p>
 * Класс помечен аннотацией {@link Cache} - список областей, которые кэшируются.
 * </p>
 * @see Cache
 */
@Cache({"numerator", "denominator", "doubleValues"})
public class Fraction {
    private int numerator;
    private int denominator;
    private Double doubleValue;

    /**
     * Возвращает числитель дроби.
     *
     * @return числитель дроби
     */
    public int getNumerator() {

        return numerator;
    }

    /**
     * Возвращает знаменатель дроби.
     *
     * @return знаменатель дроби
     */
    public int getDenominator() {

        return denominator;
    }

    /**
     * Возвращает вещественное значение дроби с внутренним кэшированием.
     *
     * @return вещественное значение дроби
     */
    public double getDoubleValue() {
        if (doubleValue == null) {
            doubleValue = (double) numerator / denominator;
        }
        return doubleValue;
    }

    /**
     * Устанавливает дробь и сбрасывает внутренний кэш.
     *
     * @param numerator числитель
     * @param denominator знаменатель
     * @throws IllegalArgumentException если знаменатель равен нулю
     */
    public void setFraction(int numerator, int denominator) {
        Validator.validateDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;
        this.doubleValue = null;
        simplification();
    }

    //Конструкторы
    /**
     * Конструктор по умолчанию (дробь 2/3).
     */
    public Fraction() {
        this.numerator = 2;
        this.denominator = 3;
    }

    /**
     * Конструктор с параметрами.
     *
     * @param numerator числитель
     * @param denominator знаменатель
     * @throws IllegalArgumentException если знаменатель равен нулю
     */
    public Fraction(int numerator, int denominator) {
        Validator.validateDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;
        simplification();
    }

    /**
     * Возвращает строковое представление дроби.
     *
     * @return строковое представление в формате "числитель/знаменатель"
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    //Арифметические операции
    /**
     * Сумма дробей.
     *
     * @param fraction дробь для сложения
     * @return новая дробь - результат сложения
     * @throws IllegalArgumentException если дробь равна null
     */
    public Fraction sum(Fraction fraction) {
        Validator.validateFractionNull(fraction);
        int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

     /**
     * Сумма дроби и целого числа.
     *
     * @param number целое число
     * @return новая дробь - результат сложения
     */
    public Fraction sum(int number) {
        return sum(new Fraction(number, 1));
    }

    /**
     * Разность дробей.
     *
     * @param fraction дробь для вычитания
     * @return новая дробь - результат вычитания
     * @throws IllegalArgumentException если дробь равна null
     */
    public Fraction difference(Fraction fraction) {
        Validator.validateFractionNull(fraction);
        int newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Разность дроби и целого числа.
     *
     * @param number целое число
     * @return новая дробь - результат вычитания
     */

    public Fraction difference(int number) {
        return difference(new Fraction(number, 1));
    }

    /**
     * Произведение дробей.
     *
     * @param fraction дробь для умножения
     * @return новая дробь - результат умножения
     * @throws IllegalArgumentException если дробь равна null
     */
    public Fraction composition(Fraction fraction) {
        Validator.validateFractionNull(fraction);
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Произведение дроби и целого числа.
     *
     * @param number целое число
     * @return новая дробь - результат умножения
     */
    public Fraction composition(int number) {
        return composition(new Fraction(number, 1));
    }

    /**
     * Деление дробей.
     *
     * @param fraction дробь-делитель
     * @return новая дробь - результат деления
     * @throws IllegalArgumentException если дробь равна null
     * @throws IllegalArgumentException если числитель дроби-делителя равен нулю
     */
    public Fraction division(Fraction fraction) {
        Validator.validateFraction(fraction);
        Validator.validateFraction(fraction);
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = this.denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Деление дроби на целое число.
     *
     * @param number целое число
     * @return новая дробь - результат деления
     * @throws IllegalArgumentException если число равно нулю
     */
    public Fraction division(int number) {
        Validator.validateNumber(number);
        return division(new Fraction(number, 1));
    }

    /**
     * Упрощает дробь: переносит знак в числитель и сокращает дробь.
     * <p>
     * Метод вызывается автоматически при создании дроби и при изменении её значений.
     * </p>
     */
    private void simplification(){
        //Знак в числителе
        if (denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }

        //Сокращение дроби
        int shorten = NOD(numerator, denominator);
        numerator /= shorten;
        denominator /= shorten;

    }

    /**
     * Вычисляет наибольший общий делитель (НОД) двух чисел.
     * <p>
     * Используется алгоритм Евклида.
     * </p>
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель чисел a и b
     */
    private int NOD(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
