package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListLeetsTest {
    final LinkedListLeets solution = new LinkedListLeets();

    @Test
    public void testCycle() {
        final ListNode a = new ListNode(3);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(0);
        final ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        Assert.assertTrue(solution.hasCycle(a));
        Assert.assertEquals(solution.getCycleStart(a).intValue(), 1);
    }

    @Test
    public void testOneItem() {
        final ListNode a = new ListNode(3);
        a.next = a;
        Assert.assertTrue(solution.hasCycle(a));
    }

    @Test
    public void testAnotherCycle() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        final ListNode d = new ListNode(4);
        final ListNode e = new ListNode(5);
        final ListNode f = new ListNode(6);
        final ListNode g = new ListNode(7);
        final ListNode h = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = e;
        Assert.assertTrue(solution.hasCycle(a));
        Assert.assertEquals(solution.getCycleStart(a).intValue(), 4);
    }

    @Test
    public void testNoCycle() {
        final ListNode a = new ListNode(3);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(0);
        final ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        Assert.assertNull(solution.getCycleStart(a));
    }
}
