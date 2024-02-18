package com.example.user.javacoretraining;

import androidx.annotation.NonNull;

import java.util.List;

/*
  Написать простое лямбда-выражение в переменной myClosure,
  лямбда-выражение должно выводить в консоль фразу "I love Java".
  Вызвать это лямбда-выражение. Далее написать функцию,
  которая будет запускать заданное лямбда-выражение заданное количество раз.
  Объявить функцию так: public void repeatTask (int times, Runnable task).
  Функция должна запускать times раз лямбда-выражение task.
  Используйте эту функцию для печати "I love Java" 10 раз.
 */
public class Practice {

    Runnable myClosure = () -> System.out.println("I love Java");

    public void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }
}

/*
  Создать интерфейс Shape с двумя методами perimeter и area,
  выводящими периметр и площадь фигуры соответственно,
  после чего реализовать и использовать для вывода периметра и площади следующие классы,
  реализующие интерфейс Shape:

  Rectangle - прямоугольник с двумя свойствами: ширина и длина
  Square - квадрат с одним свойством: длина стороны
  Circle - круг с одним свойством: диаметр круга
 */
interface Shape {

    double perimeter();

    double area();
}

class Rectangle implements Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }
}

class TriangleShape implements Shape {

    private final double side1;
    private final double side2;
    private final double side3;


    public TriangleShape(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

/*
  Условия: есть начальная позиция на двумерной плоскости,
  можно осуществлять последовательность шагов по четырем направлениям up, down, left, right.
  Размерность каждого шага равна 1.

  Задание:
  Создать enum Directions с возможными направлениями движения
  Создать метод, принимающий координаты и одно из направлений
  и возвращающий координаты после перехода по направлению
  Создать метод, осуществляющий несколько переходов от первоначальных координат
  и выводящий координаты после каждого перехода.
  Для этого внутри метода следует определить переменную location
  с начальными координатами (0,0) и массив направлений,
  содержащий элементы [up, up, left, down, left, down, down, right, right, down, right],
  и програмно вычислить какие будут координаты у переменной location
  после выполнения этой последовательности шагов.
  Для вычисленеия результата каждого перемещения следует использовать
  созданный ранее метод перемещения на один шаг.
 */
enum Directions {
    UP, DOWN, LEFT, RIGHT
}

class Position {

    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @NonNull
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Surface {

    public static Position makeOneStep(Position from, Directions dir) {
        switch (dir) {
            case UP:
                return new Position(from.getX(), from.getY() + 1);
            case DOWN:
                return new Position(from.getX(), from.getY() - 1);
            case RIGHT:
                return new Position(from.getX() + 1, from.getY());
            case LEFT:
                return new Position(from.getX() - 1, from.getY());
            default:
                return from;
        }
    }

    public static Position makeSteps(Position from, List<Directions> dirs) {
        Position location = from;
        for (int i = 0; i < dirs.size(); i++) {
            location = makeOneStep(location, dirs.get(i));
            System.out.println("New position is: " + location);
        }
        return location;
    }
}