package com.example.user.javacoretraining.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        return (double) (firstValue + secondValue) / 2;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {
        return firstValue*2 + secondValue-3 + thirdValue*thirdValue;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {
        return value > 3 ? value + 10 : value - 10;
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers(int value) {
        if (value < 10)
            return value;

        String strValue = Integer.toString(value);
        String regexp = "^(\\d{1})(\\d{0,3})(\\d{1})$";
        Pattern pattern = Pattern.compile(regexp);
        String resStr = "";
        int resValue = 0;

        Matcher matcher = pattern.matcher(strValue);

        if (matcher.matches()) {
            resStr = matcher.group(3) + matcher.group(2) + matcher.group(1);
            resValue = Integer.parseInt(resStr);
        } else
            return 0;

        return resValue;
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) {
        if (value < 10)
            return value;

        String strValue = Integer.toString(value);
        char[] chars = strValue.toCharArray();
        StringBuilder resStr = new StringBuilder();

        if (chars.length > 5)
            return 0;

        for (char aChar : chars) {
            if (aChar % 2 == 0) {
                resStr.append(0);
            } else {
                resStr.append(aChar);
            }
        }

        return Integer.parseInt(resStr.toString());
    }
}
