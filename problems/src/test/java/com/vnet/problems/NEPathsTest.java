package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NEPathsTest {
    @Test
    public void testGetPaths() {
        final NEPaths paths = new NEPaths();
        final List<List<NEPaths.Point>> list = paths.getPaths(5, 4);
        Assert.assertEquals(list.size(), 126);

        for (final List<NEPaths.Point> path : list) {
            // 10 = 1 + 5 + 4
            Assert.assertEquals(path.size(), 10);
//            String p = null;
//            for (final NEPaths.Point point : path) {
//                if (p == null) {
//                    p = point.toString();
//                } else {
//                    p = p + " " + point.toString();
//                }
//            }
//            System.out.println(p);
        }
    }
}
