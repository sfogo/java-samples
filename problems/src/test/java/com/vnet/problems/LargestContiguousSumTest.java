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

}
