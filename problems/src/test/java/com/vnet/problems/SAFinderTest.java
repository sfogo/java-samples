package com.vnet.problems;

import com.vnet.common.VException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SAFinderTest {
    private final SAFinder finder = new SAFinder();

    @Test
    public void test1Yes() {
        Assert.assertEquals(finder.findAny(7, new int[] {7}), 0);
    }

    @Test(expectedExceptions = VException.class)
    public void test1No() {
        finder.findAny(11, new int[] {7});
    }

    @Test(expectedExceptions = VException.class)
    public void test2No() {
        finder.findAny(11, new int[] {7,13});
    }

    @Test
    public void test2First() {
        Assert.assertEquals(finder.findAny(7, new int[] {7,11}), 0);
    }

    @Test
    public void test2Last() {
        Assert.assertEquals(finder.findAny(11, new int[] {7,11}), 1);
    }

    @Test
    public void testMultiple() {
        Assert.assertEquals(finder.findAny(11, new int[] {1,3,7,11,11,11,17,17,31}), 4);
    }

    @Test
    final void test2Ways() {
        final int[] values = new int[] {1,5,11,13,17,101};
        Assert.assertEquals(
                finder.findAny(17, values),
                finder.findAny(17, values, 0, values.length));
    }

    @Test
    final void test2Ways2() {
        final int[] values = new int[] {1,5,11,13,17,101};
        Assert.assertEquals(
                finder.findAny(17, values),
                finder.findAny(17, values, 2, 4));
    }

    @Test
    final void test2Ways3() {
        final int[] values = new int[] {1,5,11,13,17,101};
        Assert.assertEquals(
                finder.findAny(17, values),
                finder.findAny(17, values, 0, 5));
    }
}
