package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");

        double l = 6.0;
        System.out.println("Площадь квадрата со стороной " + l + "=  " + area(l));

        double a = 7.9;
        double b = 4;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));

    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody);
    }

    public static double area(double len) {
        return len * len;
    }

    public static double area(double a, double b) {
        return a * b;
    }
}