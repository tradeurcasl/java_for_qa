package po.stqa.pft.sandbox;

public class Points {

    public static void main(String[] args) {

        Coordinates c = new Coordinates(2.8, 4,-1,6.5);
        System.out.println("расстояние между точками = " + c.distance());
    }

}
