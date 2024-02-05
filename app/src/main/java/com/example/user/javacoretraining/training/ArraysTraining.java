package com.example.user.javacoretraining.training;

import java.util.Arrays;

/**
 * Набор тренингов по работе с массивами в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ArraysTrainingTest.
 */
public class ArraysTraining {

    /**
     * Метод должен сортировать входящий массив
     * по возрастранию пузырьковым методом
     *
     * @param valuesArray массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] valuesArray) {
        int tmp;

        for (int i = 0; i < valuesArray.length; i++) {
            for (int j = 0; j < valuesArray.length - i - 1; j++) {
                if (valuesArray[j] > valuesArray[j + 1]) {
                    tmp = valuesArray[j + 1];
                    valuesArray[j + 1] = valuesArray[j];
                    valuesArray[j] = tmp;
                }
            }
        }

        return valuesArray;
    }

    /**
     * Метод должен возвращать максимальное
     * значение из введенных. Если входящие числа
     * отсутствуют - вернуть 0
     *
     * @param values входящие числа
     * @return максимальное число или 0
     */
    public int maxValue(int... values) {
        int max = 0;

        for (int val : values) {
            if (val > max)
                max = val;
        }

        return max;
    }

    /**
     * Переставить элементы массива
     * в обратном порядке
     *
     * @param array массив для преобразования
     * @return входящий массив в обратном порядке
     */
    public int[] reverse(int[] array) {
        int[] arResult = new int[array.length];
        int j = 0;

        for (int i = array.length - 1; i > -1; i--) {
            arResult[j++] = array[i];
        }

        return arResult;
    }

    /**
     * Метод должен вернуть массив,
     * состоящий из чисел Фибоначчи
     *
     * @param numbersCount количество чисел Фибоначчи,
     *                     требуемое в исходящем массиве.
     *                     Если numbersCount < 1, исходный
     *                     массив должен быть пуст.
     * @return массив из чисел Фибоначчи
     */
    public int[] fibonacciNumbers(int numbersCount) {
        if (numbersCount < 1)
            return new int[]{};

        if (numbersCount == 1)
            return new int[]{1};

        if (numbersCount == 2)
            return new int[]{1, 1};

        int[] arResult = new int[numbersCount];
        arResult[0] = 1;
        arResult[1] = 1;

        for (int i = 2; i < numbersCount; i++) {
            arResult[i] = arResult[i-2] + arResult[i-1];
        }

        return arResult;
    }

    /**
     * В данном массиве найти максимальное
     * количество одинаковых элементов.
     *
     * @param array массив для выборки
     * @return количество максимально встречающихся
     * элементов
     */
    public int maxCountSymbol(int[] array) {
        if (array.length == 0)
            return 0;

        int maxCount = 1;
        int tmpCount = 1;

        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                tmpCount++;
            } else {
                if (tmpCount > maxCount) {
                    maxCount = tmpCount;
                }
                tmpCount = 1;
            }
        }

        if (tmpCount > maxCount) {
            maxCount = tmpCount;
        }

        return maxCount;
    }
}
