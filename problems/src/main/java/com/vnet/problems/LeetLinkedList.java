package com.vnet.problems;

import com.vnet.common.VException;

import java.util.List;

public class LeetLinkedList {
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
     * Remove nth element from end of list.
     * - Check if list is long enough to remove n elements for n (n=0 removes nothing, n=1 removes last)
     * - If list is long enough, slide a 2-pointer (left/right) window whose width is n-1 until next of right hits null,
     * then left hand side of the fork is the nth element from end we want to remove.
     * @param head list head (assumes list it has no cycle)
     * @param n nth element
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

    /**
     * - Assume both lists are sorted
     * - Get rid of edge cases when one of the two list is null
     * - Maintain one pointer on each least
     * - Compare numbers pointed to by the two pointers , add smallest to resulting list
     *   and only advance the pointer that pointed to smallest number, repeat as long as both pointers are not null
     * - Remember result head and result tail
     * - Finally, since one list is finish before the other, hook remaining part on to tail
     * @param list1 first list
     * @param list2 second list
     * @return merge list
     */
    public ListNode mergeSortedLists(final ListNode list1, final ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode tail = null;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                final ListNode newNode = new ListNode(p1.value);
                if (head == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                }
                tail = newNode;
                p1 = p1.next;
            } else {
                final ListNode newNode = new ListNode(p2.value);
                if (head == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                }
                tail = newNode;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            tail.next = p2;
        }
        if (p2 == null) {
            tail.next = p1;
        }

        return head;
    }

    public ListNode reverse(final ListNode head) {
        ListNode reversedHead = null;
        ListNode node = head;
        while (node != null) {
            final ListNode newNode = new ListNode(node.value);
            if (reversedHead != null) {
                newNode.next = reversedHead;
            }
            reversedHead = newNode;
            node = node.next;
        }
        return reversedHead;
    }

    public boolean isPalindrome(final ListNode head) {
        int count = 0;
        ListNode reversed = null;
        ListNode node = head;
        while (node != null) {
            final ListNode newNode = new ListNode(node.value);
            if (reversed != null) {
                newNode.next = reversed;
            }
            reversed = newNode;
            node = node.next;
            count++;
        }
        ListNode n1 = head;
        ListNode n2 = reversed;
        // will work whether or not there is a middle element
        final int inspectionCount = count / 2;
        for (int i=0; i<inspectionCount; i++) {
            if (n1.value != n2.value) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
