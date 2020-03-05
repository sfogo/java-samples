package com.vnet.problems;

import com.vnet.common.VException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class LeetLinkedListTest {
    private final LeetLinkedList solution = new LeetLinkedList();

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
        assertEquals(solution.getCycleStart(a).intValue(), 1);
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
        assertEquals(solution.getCycleStart(a).intValue(), 4);
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

    @Test
    public void testRemoveFromEnd() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        final ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        solution.removeFromEnd(a, 3);
    }

    @Test
    public void testRemove() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        final ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        final ListNode head = solution.removeFromEnd(a, 3);
        assertEquals(head, a);
        assertEquals(head.next, c);
    }

    @Test
    public void testRemoveHead() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = null;
        final ListNode head = solution.removeFromEnd(a, 3);
        assertEquals(head, b);
    }

    @Test(expectedExceptions = VException.class)
    public void testRemoveNotEnough() {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = null;
        solution.removeFromEnd(a, 7);
    }

    @Test
    public void testMergeSortedLists() {
        final ListNode list1 = new ListNode(1,
                new ListNode(3,
                        new ListNode(7,
                                new ListNode(11, null))));

        final ListNode list2 = new ListNode(2,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(8,
                                        new ListNode(9,
                                                new ListNode(15, null))))));

        assertList(
                solution.mergeSortedLists(list1, list2),
                new int[] {1,2,2,3,3,7,8,9,11,15});
    }

    @Test
    public void testMergeSortedListsOneNull() {
        final ListNode list1 = new ListNode(1,
                new ListNode(3,
                        new ListNode(7,
                                new ListNode(11, null))));

        assertList(
                solution.mergeSortedLists(list1, null),
                new int[] {1,3,7,11});
    }

    @Test
    public void testMergeSortedListNoIntertwine() {
        final ListNode list1 = new ListNode(1,
                new ListNode(3,
                        new ListNode(7,
                                new ListNode(11, null))));

        final ListNode list2 = new ListNode(12,
                new ListNode(12,
                        new ListNode(13,
                                new ListNode(18,
                                        new ListNode(19,
                                                new ListNode(25, null))))));

        ListNode head = solution.mergeSortedLists(list1, list2);
        assertList(head, new int[] {1,3,7,11,12,12,13,18,19,25});
    }

    private void assertList(final ListNode head, final int[] expected) {
        ListNode node = head;
        for (final int value : expected) {
            Assert.assertEquals(node.value, value);
            node = node.next;
        }
        Assert.assertNull(node);
    }

    @Test
    public void testReverse() {
        final ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4, null))));
        assertList(solution.reverse(list), new int[] {4,3,2,1});
    }

    @Test
    public void testReverseOfOne() {
        assertList(solution.reverse(new ListNode(1)), new int[] {1});
    }

    @Test
    public void testReverseOfTwo() {
        assertList(solution.reverse(new ListNode(1, new ListNode(2))), new int[] {2,1});
    }

    @Test
    public void testPalindrome() {
        Assert.assertTrue(solution.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(7,
                                        new ListNode(3,
                                                new ListNode(2,
                                                        new ListNode(1, null)))))))));
    }

    @Test
    public void testPalindromeOfOne() {
        Assert.assertTrue(solution.isPalindrome(new ListNode(1)));
    }

    @Test
    public void testPalindromeOfThree() {
        Assert.assertTrue(solution.isPalindrome(new ListNode(7,
                new ListNode(8,
                        new ListNode(7)))));
    }

    @Test
    public void testNoPalindrome() {
        Assert.assertFalse(solution.isPalindrome(new ListNode(7, new ListNode(8))));
    }
}
