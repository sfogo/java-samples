package com.vnet.problems;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public List<Pair<Integer, Integer>> valuePairs(final int sum, final int[] values) {
        final List<Pair<Integer, Integer>> indexPairs = indexPairs(sum, values);
        final List<Pair<Integer, Integer>> pairs = new LinkedList<>();
        for (final Pair<Integer,Integer> indexPair : indexPairs) {
            pairs.add(new ImmutablePair<>(values[indexPair.getLeft()], values[indexPair.getRight()]));
        }
        return pairs;
    }

    public List<Pair<Integer, Integer>> indexPairs(final int sum, final int[] values) {
        if (values == null || values.length == 0) {
            return new LinkedList<>();
        }

        final List<Pair<Integer, Integer>> list = new LinkedList<>();
        // key : difference with value, index where difference is found
        final Map<Integer, Integer> differences = new HashMap<>();
        for (int i=0; i<values.length; i++) {
            // must be two distinct items in array
            final int diff = sum - values[i];
            if (diff == 0) {
                continue;
            }
            if (differences.get(values[i]) == null) {
                differences.put(diff, i);
            } else {
                list.add(new ImmutablePair<>(i, differences.get(values[i])));
            }
        }
        return list;
    }

    public List<String> generateParenthesis(final int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }

        if (n == 1) {
            final List<String> list = new LinkedList<>();
            list.add("()");
            return list;
        }

        final List<String> list = generateParenthesis(n-1);
        final Set<String> set = new HashSet<>();
        for (final String s : list) {
            // use a set since adding () may yield duplicates
            // from different entries (or from same entry for that matter)
            set.add("()" + s);
            set.add(s + "()");
            // Adding at both ends does not create duplicates
            set.add("(" + s + ")");
        }
        return new LinkedList<>(set);
    }
}
