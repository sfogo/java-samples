package com.vnet.problems;

import com.vnet.common.Sets;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NorthEastPathsTest {
    private NorthEastPaths paths = new NorthEastPaths();

    @Test
    public void testPath44() {
        Assert.assertEquals(paths.count(4, 4), Sets.C(8, 4));
    }

    @Test
    public void testPath22() {
        Assert.assertEquals(paths.count(2, 2), Sets.C(4, 2));
    }

    @Test
    public void testTwoWays() {
        Assert.assertEquals(paths.count(4,4), paths.count2(4, 4));
    }

    @Test
    public void testTwoWays40() {
        Assert.assertEquals(paths.count(4,0), paths.count2(4, 0));
    }

    @Test
    public void testPath40() {
        Assert.assertEquals(paths.count(4, 0), 1);
    }
}
