package po.stqa.pft.sandbox;

import javax.sound.midi.Soundbank;

public class Points {

    public static void main(String[] args) {

        Coordinates c = new Coordinates(2, 4,-1,6.5);
        System.out.println("расстояние между точками = " + distance(c));
    }

    public static double distance (Coordinates c) {
        return Math.sqrt((c.x2-c.x1)*(c.x2-c.x1)+(c.y2-c.y1)*(c.y2-c.y1));
    }
}
