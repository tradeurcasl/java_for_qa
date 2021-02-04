package po.srqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import po.stqa.pft.sandbox.Coordinates;

public class PointsTests {

    @Test
    public void testCoordinates1() {
        Coordinates c = new Coordinates(0,0,1,0);
        Assert.assertEquals(c.distance(), 1.0);
    }

    @Test
    public void testCoordinates2() {
        Coordinates c = new Coordinates(1,0,1,0);
        Assert.assertEquals(c.distance(), 0.0);
    }

    @Test
    public void testCoordinates3() {
        Coordinates c = new Coordinates(2,1,1,1);
        Assert.assertEquals(c.distance(), 1.0);
    }

    @Test
    public void testCoordinates4() {
        Coordinates c = new Coordinates(0,-1,0,1);
        Assert.assertEquals(c.distance(), 2.0);
    }

}

