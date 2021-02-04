package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquaresTests {

    @Test
    public void testArea() {
        Squares s = new Squares(6);
        Assert.assertEquals(s.area(), 36.0);
    }
}
