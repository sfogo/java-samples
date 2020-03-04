package com.vnet.problems;

import com.vnet.common.VException;

public class LinkedListLeets {
    public boolean hasCycle(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head == null ? null : head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return false;
    }

    /**
     * Get Cycle Start
     * @param head linked list
     * @return null if there is no cycle, otherwise (zero based) position
     */
    public Integer getCycleStart(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head == null ? null : head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                int start = 0;
                ListNode left = head;
                ListNode right = fast;
                while (left != right.next) {
                    left = left.next;
                    right = right.next;
                    start++;
                }
                return start;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return null;
    }

    /**
     * Remove nth element from end of list
     * @param head list head (assumes list it has no cycle)
     * @param n nth element (n=0 removes nothing, n=1 removes last)
     */
    public ListNode removeFromEnd(final ListNode head, final int n) {
        if (head == null || n <=0) {
            return head;
        }
        int count = 1;
        ListNode node = head;
        while (count < n && node.next != null) {
            count++;
            node = node.next;
        }

        if (count != n) {
            throw new VException("Too few elements");
        }

        ListNode left = head;
        ListNode right = node;
        ListNode parent = null;

        while (right.next != null) {
            parent = left;
            left = left.next;
            right = right.next;
        }

        if (parent == null) {
            return left.next;
        } else {
            parent.next = left.next;
            return head;
        }
    }
}
