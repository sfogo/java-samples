package com.vnet.common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FibonacciTest {
    final Fibonacci fibonacci = new Fibonacci();

    @Test
    public void test0() {
        Assert.assertEquals(fibonacci.iterative(0), 1);
        Assert.assertEquals(fibonacci.iterative(0), fibonacci.recursive(0));
    }

    @Test
    public void test1() {
        Assert.assertEquals(fibonacci.iterative(1), 1);
        Assert.assertEquals(fibonacci.iterative(1), fibonacci.recursive(1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(fibonacci.iterative(2), 2);
        Assert.assertEquals(fibonacci.iterative(2), fibonacci.recursive(2));
    }

    @Test
    public void testN() {
        Assert.assertEquals(fibonacci.iterative(9), 55);
        Assert.assertEquals(fibonacci.iterative(9), fibonacci.recursive(9));
    }
}
