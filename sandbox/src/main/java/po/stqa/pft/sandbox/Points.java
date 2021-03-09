package po.stqa.pft.sandbox;

public class Points {

    public static void main(String[] args) {

        Point firstPoint = new Point();
        firstPoint.Coordinates(2.8, 4);
        Point secondPoint = new Point();
        secondPoint.Coordinates(-1, 6.5);
        System.out.println("расстояние между точками = " + firstPoint.distance(secondPoint));
    }

}
