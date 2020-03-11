package com.vnet.problems;

import com.vnet.common.VException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NextGreaterTest {
    private final NextGreater nextGreater = new NextGreater();
    @Test
    public void testOne() {
        final int n = nextGreater.get(1432);
        Assert.assertEquals(n, 2134);
    }

    @Test(expectedExceptions = VException.class)
    public void testNone() {
        nextGreater.get(54321);
    }

    @Test(expectedExceptions = VException.class)
    public void testSingleDigit() {
        nextGreater.get(9);
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(nextGreater.get(1234), 1243);
        Assert.assertEquals(nextGreater.get(534976), 536479);
        Assert.assertEquals(nextGreater.get(218765), 251678);
    }
}
