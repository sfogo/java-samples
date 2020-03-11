package com.vnet.problems;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        final List<String> values = new LinkedList<>();
        generateParenthesis(values, 0, 0, n, "");
        return values;
    }

    /**
     * Pass everything in recurring call
     * @param values accumulating result
     * @param open current number of open parenthesis
     * @param closed current number of closed parenthesis
     * @param n number of parenthesis pairs
     * @param current current value
     */
    private void generateParenthesis(
            final List<String> values,
            final int open,
            final int closed,
            final int n,
            final String current) {
        if (current.length() == 2*n) {
            values.add(current);
            return;
        }

        if (open < n) {
            generateParenthesis(values, open+1, closed, n, current + "(");
        }

        if (closed < open) {
            generateParenthesis(values, open, closed+1, n, current + ")");
        }
    }

    private static String padding(final int size) {
        final StringBuilder builder = new StringBuilder();
        for (int i=0; i<size; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public List<String> gen2Parenthesis(final int n) {
        return new ParenthesisGenerator().generate(n);
    }

    /**
     * Same thing using an extra class : pass only open and closed counts
     * BUT you need to adjust current accordingly
     */
    private static class ParenthesisGenerator {
        private LinkedList<Character> current;
        private List<String> values;
        private int nbPairs;

        /**
         * generate
         * @param open current number of open parenthesis
         * @param closed current number of closed parenthesis
         */
        private void generate(final int open, final int closed) {
            if (current.size() == 2*nbPairs) {
                values.add(currentAsString());
                return;
            }

            if (open < nbPairs) {
                current.add('(');
                generate(open+1, closed);
                current.pollLast();
            }

            if (closed < open) {
                current.add(')');
                generate(open, closed+1);
                current.pollLast();
            }
        }

        private String currentAsString() {
            final StringBuilder builder = new StringBuilder();
            for (final Character c : current) {
                builder.append(c);
            }
            return builder.toString();
        }

        List<String> generate(final int n) {
            values = new LinkedList<>();
            current = new LinkedList<>();
            nbPairs = n;
            generate(0, 0);
            return values;
        }
    }

    public String zigzagConvert(final String s, final int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        final StringBuilder builder = new StringBuilder();
        final int step2 = numRows - 2;

        // Number of sections whose size is rows + step2 = 2*(rows-1)
        // last one may be truncated
        int count = s.length() / (numRows+step2);
        if (s.length() % (numRows+step2) > 0) {
            count++;
        }

        // Start : Offset = 0
        for (int i=0; i<count; i++) {
            final int index = i*(numRows+step2);
            if (index < s.length()) {
                builder.append(s.charAt(index));
            }
        }

        // Middle : offset 1 to rows-2
        for (int offset = 1; offset<=numRows-2; offset++) {
            for (int i=0; i<count; i++) {
                // Letter in section of size rows
                int index = i*(numRows+step2) + offset;
                if (index < s.length()) {
                    builder.append(s.charAt(index));
                }
                // Take letter is section of size rows-2 backwards
                index = (i+1)*(numRows+step2) - offset;
                if (index < s.length()) {
                    builder.append(s.charAt(index));
                }
            }
        }

        // End : Offset = rows-1
        for (int i=0; i<count; i++) {
            final int index = i*(numRows+step2) + (numRows - 1);
            if (index < s.length()) {
                builder.append(s.charAt(index));
            }
        }

        return builder.toString();
    }

    public List<String> zigzagLines(final String s, final int rows) {
        final List<String> lines = new LinkedList<>();
       if (s == null || s.length() == 0 || rows == 1) {
           lines.add(s);
           return lines;
        }

        final int step2 = rows - 2;

        // Number of sections whose size is rows + step2 = 2*(rows-1)
        // last one may be truncated
        int count = s.length() / (rows+step2);
        if (s.length() % (rows+step2) > 0) {
            count++;
        }

        // Start : Offset = 0
        StringBuilder line = new StringBuilder();
        for (int i=0; i<count; i++) {
            final int index = i*(rows+step2);
            if (index < s.length()) {
                if (i>0) {
                    line.append(padding(step2));
                }
                line.append(s.charAt(index));
            }
        }
        lines.add(line.toString());

        // Middle : offset 1 to rows-2
        for (int offset = 1; offset<=rows-2; offset++) {
            line = new StringBuilder();
            for (int i=0; i<count; i++) {
                // Letter in section of size rows
                int index = i*(rows+step2) + offset;
                if (index < s.length()) {
                    line.append(s.charAt(index));
                }
                // Take letter is section of size rows-2 backwards
                index = (i+1)*(rows+step2) - offset;
                if (index < s.length()) {
                    line.append(padding(step2-offset));
                    line.append(s.charAt(index));
                    line.append(padding(offset-1));
                }
            }
            lines.add(line.toString());
        }

        // End : Offset = rows-1
        line = new StringBuilder();
        for (int i=0; i<count; i++) {
            final int index = i*(rows+step2) + (rows - 1);
            if (index < s.length()) {
                if (i>0) {
                    line.append(padding(step2));
                }
                line.append(s.charAt(index));
            }
        }
        lines.add(line.toString());

        return lines;
    }

    /**
     * https://leetcode.com/problems/rotated-digits/submissions/
     * @param N max value
     * @return number of accepted numbers
     */
    public int rotatedDigits(final int N) {
        final int max = 10000;
        if (N<0 || N>max) {
            throw new IllegalArgumentException("Invalid value:" + N);
        }

        int count = 0;
        for (int i=1; i<=N; i++) {
            int nbDigits;
            if (i<10) {
                nbDigits = 1;
            } else if (i<100) {
                nbDigits = 2;
            } else if (i<1000) {
                nbDigits = 3;
            } else {
                nbDigits = 4;
            }

            int value = i;
            boolean candidate = true;
            int selfCount = 0;
            for (int p=1; p<=nbDigits && candidate; p++) {
                final int mod = value % 10;
                if (mod==3 || mod==4 || mod==7) {
                    candidate = false;
                } else if (mod==0 || mod==1 || mod==8) {
                    selfCount++;
                }
                value = value / 10;
            }

            if (candidate && selfCount != nbDigits) {
                count++;
            }
        }
        return count;
    }

    /**
     * Multiply 2 numbers given as string. DO NOT convert these numbers to integer values
     * @param num1 1st number
     * @param num2 2nd number
     * @return string
     */
    public String multiply(final String num1, final String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        int pow1 = 1;
        for (int i=0; i<num1.length(); i++) {
            final int d1 = num1.charAt(num1.length() - 1 - i) - '0';
            int s = 0;
            int carry = 0;
            int pow2 = 1;
            for (int j=0; j<num2.length(); j++) {
                final int d2 = num2.charAt(num2.length() - j - 1) - '0';
                final int p = d1*d2 + carry;
                if (j==num2.length()-1) {
                    s += (p * pow2);
                } else {
                    s += (p % 10) * pow2;
                }
                carry = p / 10;
                pow2 = 10*pow2;
            }
            result += (pow1 * s);
            pow1 = 10*pow1;
        }

        return String.valueOf(result);
    }

    public String add(final String num1, final String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i=0;
        while (i<num1.length() && i<num2.length()) {
            final int sum = (num1.charAt(num1.length() - 1 - i) - '0') + (num2.charAt(num2.length() - 1 - i) - '0') + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
            i++;
        }

        // will enter at most one of the two loops
        // when num1 and num2 lengths differ

        while (i<num1.length()) {
            final int sum = (num1.charAt(num1.length() - 1 - i) - '0') + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
            i++;
        }

        while (i<num2.length()) {
            final int sum = (num2.charAt(num2.length() - 1 - i) - '0') + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
            i++;
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    /**
     * https://leetcode.com/problems/multiply-strings/
     * @param num1 1st number
     * @param num2 2nd number
     * @return string
     */
    public String multiply2(final String num1, final String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String result = "";
        int shift = 0;
        for (int i=0; i<num1.length(); i++) {
            final int d1 = num1.charAt(num1.length() - 1 - i) - '0';
            final StringBuilder builder = new StringBuilder();
            int carry = 0;
            for (int j=0; j<num2.length(); j++) {
                final int d2 = num2.charAt(num2.length() - j - 1) - '0';
                final int p = d1*d2 + carry;
                if (j==num2.length()-1) {
                    builder.insert(0, p);
                } else {
                    builder.insert(0, p%10);
                }
                carry = p / 10;
            }

            // Multiply by 10 shift times
            if (result.isEmpty()) {
                result = builder.toString();
            } else {
                for (int s = 0; s < shift; s++) {
                    builder.append("0");
                }
                result = add(result, builder.toString());
            }
            shift++;
        }
        return result;
    }

    public boolean isValidBrackets(String s) {
        if (s == null) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        // Last Open Parenthesis '(' index
        int lastOpenP = -1;
        // Last Open Accolade '{' index
        int lastOpenA = -1;
        // Last open square '[' Bracket
        int lastOpenS = -1;
        // Find First Closing item
        int open = -1;
        int closed = -1;

        boolean stop = false;
        for (int i=0; i<s.length() && !stop; i++) {
            final char c = s.charAt(i);
            if (c == '(') {
                lastOpenP = i;
            } else if (c == '{') {
                lastOpenA = i;
            } else if (c == '[') {
                lastOpenS = i;
            } else {
                stop = true;
                closed = i;
                if (c == ')') {
                    open = lastOpenP;
                } else if (c == '}') {
                    open = lastOpenA;
                } else if (c == ']') {
                    open = lastOpenS;
                }
            }
        }
        if (open >= 0 && closed > open) {
            // examine String inside open.closed pair
            final String inside = s.substring(open+1, closed);
            final String outside = s.substring(0, open) + s.substring(1+closed);
            return isValidBrackets(inside) && isValidBrackets(outside);
        } else {
            return false;
        }
    }

    /**
     * https://leetcode.com/problems/count-and-say/
     * @param n level
     * @return what you say
     */
    public String countAndSay(final int n) {
        String s = "1";
        for (int i=1; i<n; i++) {
            final StringBuilder builder = new StringBuilder();
            char previousChar = s.charAt(0);
            int count = 1;
            for (int j=1; j<s.length(); j++) {
                final char c = s.charAt(j);
                if (c == previousChar) {
                    count++;
                } else {
                    builder.append(count).append(previousChar);
                    count = 1;
                }
                previousChar = c;
            }
            builder.append(count).append(previousChar);
            s = builder.toString();
        }
        return s;
    }

    /**
     * https://leetcode.com/problems/valid-anagram/
     * @param s string one
     * @param t string two
     * @return true is t is anagram of s
     */
    public boolean isAnagram(final String s, final String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        final Map<Character,Integer> sMap = new HashMap<>();
        final Map<Character,Integer> tMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }
        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (final Character c : sMap.keySet()) {
            if (tMap.get(c) == null) {
                return false;
            }
            if (!tMap.get(c).equals(sMap.get(c))) {
                return false;
            }
        }

        return true;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode oddTail = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (odd != null && even != null) {
            oddTail = odd;
            odd.next = odd.next.next;
            even.next = even.next == null ? null : even.next.next;
            // next two values
            odd = odd.next;
            even = even.next;
        }
        if (odd == null && even == null) {
            oddTail.next = evenHead;
        } else if (odd != null) {
            odd.next = evenHead;
        }
        return head;
    }

    /**
     * Remove duplicates : count number of distinct values
     * AND modify inout array to contain distinct sorted values at its beginning
     * @param nums SORTED array
     * @return count
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[count-1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
