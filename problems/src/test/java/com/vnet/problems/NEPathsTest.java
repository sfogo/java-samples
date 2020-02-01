package com.vnet.problems;

import com.vnet.common.Sets;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NEPathsTest {
    @Test
    public void testGetPaths() {
        final NEPaths paths = new NEPaths();
        final List<List<NEPaths.Point>> list = paths.getPaths(5, 4);
        Assert.assertEquals(list.size(), 126);
        // 10 = 1 + 5 + 4
        log(list, 10);
    }

    @Test
    public void testGetPaths22() {
        final NEPaths paths = new NEPaths();
        final List<List<NEPaths.Point>> list = paths.getPaths(2, 2);
        Assert.assertEquals(list.size(), Sets.C(4,2));
        // 5 = 1 + 2 + 2
        log(list, 5);
    }

    private void log(final List<List<NEPaths.Point>> list, final int len) {
        int i=1;
        for (final List<NEPaths.Point> path : list) {
            Assert.assertEquals(path.size(), len);
            String p = null;
            for (final NEPaths.Point point : path) {
                if (p == null) {
                    p = point.toString();
                } else {
                    p = p + " " + point.toString();
                }
            }
            System.out.println(p + " : " + i++);
        }
    }
}
