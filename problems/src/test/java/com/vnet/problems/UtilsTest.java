package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UtilsTest {
    private final Utils helper = new Utils();

    @Test
    public void testOne() {
        final List<Integer> values = new LinkedList<Integer>() {{
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(9);
        }};

        final int pos = helper.sortedListedInsertPosition(values, 8);
        Assert.assertEquals(pos, 8);
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(helper.sortedListedInsertPosition(new LinkedList<>(), 8), 0);
    }

    @Test
    public void testEnd() {
        Assert.assertEquals(helper.sortedListedInsertPosition(new LinkedList<Integer>() {{add(0);}}, 8), 1);
    }
}