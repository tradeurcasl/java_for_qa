package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");

        Squares s = new Squares(7);
        System.out.println("Площадь квадрата со стороной " + s.l + "=  " + s.area());

        Rectangles r = new Rectangles(7, 8);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody);
    }
}
