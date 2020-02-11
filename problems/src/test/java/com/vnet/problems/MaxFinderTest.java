package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxFinderTest {
    private final MaxFinder finder = new MaxFinder();

    @Test
    public void testMaxOfTenValues() {
        final int[] a = new int[] {1,2,3,-1,17,137,5,11};
        Assert.assertEquals(finder.getMaxValue(a), 137);
        Assert.assertEquals(finder.scanForMaxValue(a), 137);
        Assert.assertEquals(finder.getMaxPosition(a), finder.scanForMaxPosition(a));
    }

    @Test
    public void testBoth() {
        final int[] a = Helper.createIntArray(100, 0, 50);
        Assert.assertEquals(finder.getMaxValue(a), finder.scanForMaxValue(a));
    }

    @Test
    public void testOne() {
        final int[] a = new int[] {7};
        Assert.assertEquals(finder.getMaxPosition(a), 0);
        Assert.assertEquals(finder.scanForMaxPosition(a), 0);
    }

    @Test
    public void testTwo() {
        final int[] a = new int[] {0,7};
        Assert.assertEquals(finder.getMaxPosition(a), 1);
        Assert.assertEquals(finder.scanForMaxPosition(a), 1);
    }

    @Test
    public void testThree() {
        final int[] a = new int[] {0,7,6};
        Assert.assertEquals(finder.getMaxPosition(a), 1);
        Assert.assertEquals(finder.scanForMaxPosition(a), 1);
    }
}
