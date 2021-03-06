package com.vnet.problems;

import com.vnet.common.Fibonacci;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StairsTest {
    private final Stairs stairs = new Stairs();

    @Test
    public void test4() {
        Assert.assertEquals(stairs.climb(4), 5);
    }

    @Test
    public void test6() {
        Assert.assertEquals(stairs.climb(5), 8);
    }

    @Test
    public void testCountPaths() {
        final List<List<Integer>> paths = stairs.getClimbPaths(6);
        Assert.assertEquals(paths.size(), 13);
        for (final List<Integer> path : paths) {
            System.out.println(path);
        }
    }

    @Test
    public void show10() {
        final Fibonacci fibonacci = new Fibonacci();
        for (int i=1; i<=10; i++) {
            final int nb = stairs.climb(i);
            System.out.println(String.format("%d : %d", i, nb));
            Assert.assertEquals(nb, fibonacci.iterative(i));
        }
    }
}
