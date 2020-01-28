package com.vnet.common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilsTest {
    @Test
    public void testPercentage() {
        Assert.assertEquals(Utils.percentage(1, 3, 2), "33.33%");
    }
}
