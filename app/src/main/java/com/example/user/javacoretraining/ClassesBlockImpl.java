package com.example.user.javacoretraining;

import com.example.user.javacoretraining.classes.ClassesBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ClassesBlockImpl implements ClassesBlock {
}

/*
  I

  Создать класс с двумя переменными. Добавить функцию вывода на экран
  и функцию изменения этих переменных. Добавить функцию, которая находит
  сумму значений этих переменных, и функцию, которая находит наибольшее
  значение из этих двух переменных.
 */
class Task1 {

    private int val1;
    private int val2;

    public void setValues(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public void printValues() {
        System.out.println("value 1 = " + val1);
        System.out.println("value 2 = " + val2);
    }

    public int sum() {
        return val1 + val2;
    }

    public int max() {
        return Math.max(val1, val2);
    }
}

/*
  II

  Создать класс, содержащий динамический массив и количество элементов в нем.
  Добавить конструктор, который выделяет память под заданное количество элементов.
  Добавить методы, позволяющие заполнять массив случайными числами,
  переставлять в данном массиве элементы в случайном порядке, находить количество
  различных элементов в массиве, выводить массив на экран.
 */
class Task2 {

    private final int MAX_VALUE = 100;

    private ArrayList<Integer> array;
    private int size;

    public Task2(int size) {
        this.size = size;
        array = new ArrayList<>(size);
    }

    public int getSize() {
        return array.size();
    }

    public void initArray() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(i, random.nextInt(MAX_VALUE));
        }
    }

    public void shuffleArray() {
        Collections.shuffle(array);
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println("array[" + i + "] = " + array.get(i));
        }
    }

    public int findUniqueNumbersCount() {
        Collections.sort(array);

        Integer num = null;
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (array.get(i).equals(num))
                count++;
            else
                num = array.get(i);
        }

        return count;
    }
}

/*
  III

  Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
  вычисления площади, периметра и точки пересечения медиан.
  Описать свойства для получения состояния объекта.
 */
class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Triangle {

    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // площадь
    public double getArea() {
        return Math.abs((a.getX() - c.getX()) * (b.getY() - a.getY()) - (a.getX() - b.getX()) * (c.getY() - a.getY())) /2;
    }

    // точка пересечения медиан
    public Point getCentroid(){
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;

        return new Point(x, y);
    }
}