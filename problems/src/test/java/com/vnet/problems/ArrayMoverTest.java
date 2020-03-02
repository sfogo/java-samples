package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayMoverTest {
    final ArrayMover mover = new ArrayMover();

    @Test
    public void testShiftLeft() {
        final int[] values = new int[] {0,1,0,3,12};
        mover.shiftLeft(3, 2, values);
        Assert.assertEquals(values[0], 0);
        Assert.assertEquals(values[1], 1);
        Assert.assertEquals(values[2], 3);
        Assert.assertEquals(values[3], 12);
        Assert.assertEquals(values[4], 12);
    }

    @Test
    public void testShiftLeftFromIndex1() {
        final int[] values = new int[] {0,1,0,3,12};
        mover.shiftLeft(1, 4, values);
        Assert.assertEquals(values[0], 1);
        Assert.assertEquals(values[1], 0);
        Assert.assertEquals(values[2], 3);
        Assert.assertEquals(values[3], 12);
        Assert.assertEquals(values[4], 12);
    }

    @Test
    public void testMoveZeros() {
        final int[] values = new int[] {0,1,0,3,12};
        mover.moveZerosToEnd(values);
        Assert.assertEquals(values[0], 1);
        Assert.assertEquals(values[1], 3);
        Assert.assertEquals(values[2], 12);
        Assert.assertEquals(values[3], 0);
        Assert.assertEquals(values[4], 0);
    }

    @Test
    public void testMoveTwo() {
        final int[] values = new int[] {0,1,0};
        mover.moveZerosToEnd(values);
        Assert.assertEquals(values[0], 1);
        Assert.assertEquals(values[1], 0);
        Assert.assertEquals(values[2], 0);
    }

    @Test
    public void testWithZerosOnly() {
        final int[] values = new int[] {0,0,0,0};
        mover.moveZerosToEnd(values);
        Assert.assertEquals(values[0], 0);
        Assert.assertEquals(values[1], 0);
        Assert.assertEquals(values[2], 0);
        Assert.assertEquals(values[3], 0);
    }

    @Test
    public void test789() {
        final int[] values = new int[] {0,7,8,0,0,0,9};
        mover.moveZerosToEnd(values);
        Assert.assertEquals(values[0], 7);
        Assert.assertEquals(values[1], 8);
        Assert.assertEquals(values[2], 9);
        for (int i=3; i<values.length; i++) {
            Assert.assertEquals(values[i], 0);
        }
    }

    @Test
    public void testMoveSevensToEnd() {
        final int[] values = new int[] {7,7,8,7,0,0,9};
        mover.moveValueToEnd(values, 7);
        Assert.assertEquals(values[0], 8);
        Assert.assertEquals(values[1], 0);
        Assert.assertEquals(values[2], 0);
        Assert.assertEquals(values[3], 9);
        Assert.assertEquals(values[4], 7);
        Assert.assertEquals(values[5], 7);
        Assert.assertEquals(values[6], 7);
    }
}
