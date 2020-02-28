package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KnapSackTest {
    private final KnapSack sack = new KnapSack();

    @Test
    public void testOne() {
        final KnapSack.Item[] items = new KnapSack.Item[4];
        items[0] = new KnapSack.Item("Apple", 2, 4);
        items[1] = new KnapSack.Item("Orange", 3, 5);
        items[2] = new KnapSack.Item("Banana", 1, 3);
        items[3] = new KnapSack.Item("Melon", 4, 7);
        Assert.assertEquals(sack.maximize(5, items), 10);
    }
}
