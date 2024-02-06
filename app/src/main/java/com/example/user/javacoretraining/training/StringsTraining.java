package com.example.user.javacoretraining.training;

import java.util.Arrays;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {
        StringBuilder sb = new StringBuilder();
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 1)
                sb.append(chars[i]);
        }

        return sb.toString();
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {
        char[] chars = text.toCharArray();
        int textLength = chars.length;

        if (textLength == 0)
            return new int[]{};

        char lastSymbol = chars[textLength - 1];
        int[] result = new int[textLength - 2];
        int n = 0;

        for (int i = 0; i < textLength - 1; i++) {
            if (chars[i] == lastSymbol)
                result[n++] = i;
        }

        return Arrays.copyOf(result, n);
    }

    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {
        int result = 0;

        for (char aChar : text.toCharArray()) {
            if (Character.isDigit(aChar))
                result++;
        }

        return result;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {
        String[] digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();

        for (char aChar : text.toCharArray()) {
            if (Character.isDigit(aChar)) {
                sb.append(digits[aChar-48]); // ASCII value of '0' is 48
            }
            else
                sb.append(aChar);
        }

        return sb.toString();
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {
        StringBuilder sb = new StringBuilder();

        for (char aChar : text.toCharArray()) {
            if (Character.isUpperCase(aChar))
                sb.append(Character.toLowerCase(aChar));
            else
                sb.append(Character.toUpperCase(aChar));
        }

        return sb.toString();
    }

}
