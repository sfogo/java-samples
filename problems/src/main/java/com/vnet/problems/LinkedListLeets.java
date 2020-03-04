package com.vnet.problems;

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
}
