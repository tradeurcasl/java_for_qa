package po.srqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import po.stqa.pft.sandbox.Point;

public class PointsTests {

    @Test
    public void testCoordinates1() {
        Point firstPoint = new Point();
        firstPoint.Coordinates(0, 0);
        Point secondPoint = new Point();
        secondPoint.Coordinates(1, 0);
        Assert.assertEquals(firstPoint.distance(secondPoint), 1.0);
    }

    @Test
    public void testCoordinates2() {
        Point firstPoint = new Point();
        firstPoint.Coordinates(1, 0);
        Point secondPoint = new Point();
        secondPoint.Coordinates(1, 0);
        Assert.assertEquals(firstPoint.distance(secondPoint), 0.0);
    }

    @Test
    public void testCoordinates3() {
        Point firstPoint = new Point();
        firstPoint.Coordinates(2, 1);
        Point secondPoint = new Point();
        secondPoint.Coordinates(1, 1);
        Assert.assertEquals(firstPoint.distance(secondPoint), 1.0);
    }

    @Test
    public void testCoordinates4() {
        Point firstPoint = new Point();
        firstPoint.Coordinates(0, -1);
        Point secondPoint = new Point();
        secondPoint.Coordinates(0, 1);
        Assert.assertEquals(firstPoint.distance(secondPoint), 2.0);
    }

}

