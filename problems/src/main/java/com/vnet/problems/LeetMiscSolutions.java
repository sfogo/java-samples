package com.vnet.problems;

public class LeetMiscSolutions {
    /**
     * Add two numbers given a digit numbers. Lowest digit first.
     * No leading zeros.
     * e.g. 342 = 2 -> 4 -> 3 -> null;
     * @param n1 first number
     * @param n2 second number
     * @return sum as digit list
     */
    public ListNode addTwoNumbers(final ListNode n1, final ListNode n2) {
        return toListNode(evaluate(n1) + evaluate(n2));
    }

    public int evaluate(final ListNode node) {
        if (node == null) {
            return 0;
        }
        int number = 0;
        ListNode n = node;
        int multiplier = 1;
        while (n != null) {
            number += multiplier * n.value;
            n = n.next;
            multiplier = 10 * multiplier;
        }
        return number;
    }

    public ListNode toListNode(int n) {
        final ListNode head = new ListNode(n % 10);
        ListNode tail = head;
        n = n / 10;
        while (n > 0) {
            final ListNode newNode = new ListNode(n % 10);
            tail.next = newNode;
            tail = newNode;
            n = n / 10;
        }
        return head;
    }

    public String longestSubstringWithoutRepeats(final String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // Local max so far
        String loc = s.substring(0, 1);
        // Absolute max
        String abs = s.substring(0, 1);

        for (int i=1; i<s.length(); i++) {
            final char c = s.charAt(i);
            if (loc.indexOf(c) == -1) {
                loc = loc + c;
            } else {
                final int last = loc.lastIndexOf(c);
                if (last == loc.length() - 1) {
                    loc = "" + c;
                } else {
                    loc = loc.substring(1 + last) + c;
                }
            }
            if (loc.length() > abs.length()) {
                abs = loc;
            }
        }
        return abs;
    }
}
