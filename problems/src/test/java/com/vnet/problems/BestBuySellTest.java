package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BestBuySellTest {
    private final BestBuySell bbs = new BestBuySell();

    @Test
    public void testOne() {
        final int[] values = new int[] {7, 1, 5, 3, 6, 4};
        Assert.assertEquals(bbs.get(values), 5);
        Assert.assertEquals(bbs.get(values), bbs.get2(values));
    }

    @Test
    public void testTwo() {
        final int[] values = new int[] {100, 180, 260, 310, 40, 535, 695};
        Assert.assertEquals(bbs.get(values), 655);
        Assert.assertEquals(bbs.get(values), bbs.get2(values));
    }
}
