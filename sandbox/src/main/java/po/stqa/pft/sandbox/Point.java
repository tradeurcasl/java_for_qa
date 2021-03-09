package po.stqa.pft.sandbox;

public class Point {

    public double x;
    public double y;

    public void Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point newPoint) {
        return Math.sqrt((newPoint.x-this.x)*(newPoint.x-this.x)+(newPoint.y-this.y)*(newPoint.y-this.y));
    }



}