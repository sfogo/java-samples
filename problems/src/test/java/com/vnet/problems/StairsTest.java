package com.vnet.problems;

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
        for (int i=1; i<=10; i++) {
            System.out.println(String.format("%d : %d", i, stairs.climb(i)));
        }
    }
}
