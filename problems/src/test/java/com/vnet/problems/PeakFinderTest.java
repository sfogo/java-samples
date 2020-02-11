package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PeakFinderTest {
    private final PeakFinder finder = new PeakFinder();

    @Test
    public void testOneValue() {
        Assert.assertEquals(finder.findAny(new int[] {7}), 0);
    }

    @Test
    public void testMiddlePeak() {
        Assert.assertEquals(finder.findAny(new int[] {1,7,13,11,8}), 2);
    }

    @Test
    public void testPeak() {
        Assert.assertEquals(finder.findAny(new int[] {1,5,8,9,13,11,10,5,4,1,6,7,12,9}), 4);
    }
}
