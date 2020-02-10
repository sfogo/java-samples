package com.vnet.problems;

import com.vnet.common.Sets;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NETest {
    @Test
    public void testGetPaths32() {
        final NEPaths paths = new NEPaths();
        final List<List<NEPaths.Point>> list = paths.getPaths(3, 2);
        Assert.assertEquals(list.size(), Sets.C(5,2));
    }
}
