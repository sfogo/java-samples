package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LargestContiguousSumTest {

    private final LargestContiguousSum lcs = new LargestContiguousSum();
    private final int[] sample = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    private final int[] sampleAll = new int[] {4,-1,2,1};

    @Test
    public void test02() {
        Assert.assertEquals(lcs.get(sample), 6);
    }

    @Test
    public void test03() {
        final int[] numbers = new int[] {-1, -3, -4};
        Assert.assertEquals(lcs.get(numbers), -1);
    }

    @Test
    public void test04() {
        final int[] numbers = new int[] {-7, -3, -4};
        Assert.assertEquals(lcs.get(numbers), -3);
    }

    @Test
    public void test05() {
        final int[] numbers = new int[] {1, 4, 9, 16};
        Assert.assertEquals(lcs.get(numbers), 30);
    }

    @Test
    public void test06() {
        Assert.assertEquals(lcs.get(sampleAll), 6);
    }

    @Test
    public void testWI1() {
        final LargestContiguousSum.Result result = lcs.getWithIndices(new int[] {7});
        Assert.assertEquals(result.getMax(), 7);
        Assert.assertEquals(result.getStart(), 0);
        Assert.assertEquals(result.getEnd(), 0);
    }

    @Test
    public void testWI2() {
        final LargestContiguousSum.Result result = lcs.getWithIndices(new int[] {7,8});
        Assert.assertEquals(result.getMax(), 15);
        Assert.assertEquals(result.getStart(), 0);
        Assert.assertEquals(result.getEnd(), 1);
    }

    @Test
    public void testWI3() {
        final LargestContiguousSum.Result result = lcs.getWithIndices(new int[] {7,-2, 8});
        Assert.assertEquals(result.getMax(), 13);
        Assert.assertEquals(result.getStart(), 0);
        Assert.assertEquals(result.getEnd(), 2);
    }

    @Test
    public void testWIS() {
        final LargestContiguousSum.Result result = lcs.getWithIndices(sample);
        Assert.assertEquals(result.getMax(), 6);
        Assert.assertEquals(result.getStart(), 3);
        Assert.assertEquals(result.getEnd(), 6);
    }

    @Test
    public void testWISAll() {
        final LargestContiguousSum.Result result = lcs.getWithIndices(sampleAll);
        Assert.assertEquals(result.getMax(), 6);
        Assert.assertEquals(result.getStart(), 0);
        Assert.assertEquals(result.getEnd(), 3);
    }
}
