package com.vnet.problems;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class LeetMiscSolutionsTest {
    private final Random random = new Random(System.currentTimeMillis());
    private final LeetMiscSolutions solution = new LeetMiscSolutions();

    @Test
    public void testToNodeList() {
        final ListNode node = solution.toListNode(943);
        Assert.assertEquals(node.value, 3);
        Assert.assertEquals(node.next.value, 4);
        Assert.assertEquals(node.next.next.value, 9);
        Assert.assertNull(node.next.next.next);
    }

    @Test
    public void testEvaluate() {
        Assert.assertEquals(solution.evaluate(solution.toListNode(7890)), 7890);
    }

    @Test
    public void testZeroToNodeList() {
        final ListNode node = solution.toListNode(0);
        Assert.assertEquals(node.value, 0);
        Assert.assertNull(node.next);
    }

    @Test
    public void testSumNumbersAsLists() {
        final ListNode node = solution.addTwoNumbers(
                solution.toListNode(342),
                solution.toListNode(465));
        Assert.assertEquals(node.value, 7);
        Assert.assertEquals(node.next.value, 0);
        Assert.assertEquals(node.next.next.value, 8);
        Assert.assertNull(node.next.next.next);
    }

    @Test
    public void testLongestSubstringWithoutRepeats() {
        final String s = solution.longestSubstringWithoutRepeats("abcabcbb");
        Assert.assertEquals(s, "abc");
    }

    @Test
    public void testLSSWR2() {
        Assert.assertEquals(solution.longestSubstringWithoutRepeats("bbbbb"), "b");
    }

    @Test
    public void testLSSWR3() {
        Assert.assertEquals(solution.longestSubstringWithoutRepeats("pwwkew"), "wke");
    }

    @Test
    public void testLSSWR4() {
        final String s = "entrelesgrandesvillescirculentdestrainsvides";
        final String l = solution.longestSubstringWithoutRepeats(s);
        Assert.assertEquals(l, "grandesvil");
    }

    @Test
    public void testLSSWR5() {
        final StringBuilder builder = new StringBuilder();
        final int max = 30;
        for (int i=0; i<max; i++) {
            builder.append((char) ('A' + random.nextInt(26)));
        }
        final String s = builder.toString();
        System.out.println(s);
        System.out.println(solution.longestSubstringWithoutRepeats(s));
    }

    @Test
    public void testSumPairs() {
        final int[] values = new int[] {-2,1,2,6,5,11,7,9,8,3};
        final int sum = 9;
        final List<Pair<Integer,Integer>> list = solution.valuePairs(sum, values);
        Assert.assertEquals(list.size(), 4);
        for (final Pair<Integer,Integer> pair : list) {
            Assert.assertEquals(sum, pair.getLeft() + pair.getRight());
        }
    }

    @Test
    public void testSumIndexPairs() {
        final int[] values = new int[] {-2,1,2,6,5,11,7,9,8,3};
        final int sum = 9;
        final List<Pair<Integer,Integer>> list = solution.indexPairs(sum, values);
        Assert.assertEquals(list.size(), 4);
        for (final Pair<Integer,Integer> pair : list) {
            Assert.assertEquals(sum, values[pair.getLeft()] + values[pair.getRight()]);
        }
    }

    @Test
    public void testParenthesis() {
        final List<String> list = solution.generateParenthesis(3);
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void testParenthesisWithFour() {
        final List<String> list = solution.generateParenthesis(4);
        Assert.assertEquals(list.size(), 14);
    }

    @Test
    public void testParenthesisWithFive() {
        final List<String> list = solution.generateParenthesis(5);
        Assert.assertEquals(list.size(), 42);
    }

    @Test
    public void testParenthesisWithGenerator() {
        final List<String> list1 = solution.generateParenthesis(4);
        final List<String> list2 = solution.gen2Parenthesis(4);
        Assert.assertEquals(list1.size(), list2.size());
    }

    @Test
    public void testViewParenthesisCounts() {
        int previousSize = 0;
        for (int i=1; i<=10; i++) {
            final List<String> list = solution.generateParenthesis(i);
            System.out.println(i + ":" + solution.generateParenthesis(i).size() + (i == 1 ? "" : " r=" + 1.0f * list.size() / previousSize));
            previousSize = list.size();
        }
    }

    @Test
    public void testZigzag4() {
        final String z = solution.zigzagConvert("PAYPALISHIRING", 4);
        Assert.assertEquals(z, "PINALSIGYAHRPI");
    }

    @Test
    public void testZigzag3() {
        final String z = solution.zigzagConvert("PAYPALISHIRING", 3);
        Assert.assertEquals(z, "PAHNAPLSIIGYIR");
    }

    @Test
    public void printZigzag4() {
        final List<String> lines = solution.zigzagLines("PAYPALISHIRING", 4);
        for (final String line : lines) {
            System.out.println(line);
        }
    }

    @Test
    public void printZigzag5() {
        final List<String> lines = solution.zigzagLines("DOYOUHAPPENTOKNOWIFPAYPALISHIRING?", 5);
        for (final String line : lines) {
            System.out.println(line);
        }
    }

    @Test
    public void testRotateDigits() {
        Assert.assertEquals(solution.rotatedDigits(10), 4);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(solution.multiply("86", "127"), "10922");
        Assert.assertEquals(solution.multiply("86", "127"), solution.multiply("127", "86"));
        Assert.assertEquals(solution.multiply("123", "456"), "56088");
        Assert.assertEquals(solution.multiply("1", "9876"), "9876");
        Assert.assertEquals(solution.multiply("1", "9876"), solution.multiply("9876", "1"));
        Assert.assertEquals(solution.multiply("1999", "1999"), "3996001");
    }

    @Test
    public void testMultiply2() {
        Assert.assertEquals(solution.multiply2("86", "127"), "10922");
    }

    @Test
    public void testBigMultiply2() {
        Assert.assertEquals(solution.multiply2("123456789", "987654321"), "121932631112635269");
        Assert.assertEquals(solution.multiply2("1999", "1999"), "3996001");
        Assert.assertEquals(solution.multiply2("199", "199"), "39601");
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(solution.add("1127", "86"), "1213");
        Assert.assertEquals(solution.add("101", "9"), "110");
        Assert.assertEquals(solution.add("11", "22"), "33");
    }

    @Test
    public void testValidParenthesis() {
        final boolean b = solution.isValidBrackets("([)]");
        Assert.assertFalse(b);
    }

    @Test
    public void testValidParenthesis2() {
        Assert.assertTrue(solution.isValidBrackets("{[()()()]}"));
        Assert.assertTrue(solution.isValidBrackets("()"));
        Assert.assertTrue(solution.isValidBrackets("{}"));
        Assert.assertTrue(solution.isValidBrackets("[]"));
        Assert.assertTrue(solution.isValidBrackets("()[]{}"));
        Assert.assertTrue(solution.isValidBrackets("[[[[]]]]"));
    }

    @Test
    public void testCountAndSay4() {
        Assert.assertEquals(solution.countAndSay(4), "1211");
    }

    @Test
    public void testCountAndSay6() {
        Assert.assertEquals(solution.countAndSay(6), "312211");
    }

    @Test
    public void viewCountAndSayUntil16() {
        int previousLength = 1;
        for (int i=1; i<16; i++) {
            final String s = solution.countAndSay(i);
            System.out.println(s + " length:" + s.length() + " r:" + (1.0 * s.length() / previousLength));
            previousLength = s.length();
        }
    }

    @Test
    public void testIsAnagram() {
        Assert.assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testIsAnagram2() {
        Assert.assertFalse(solution.isAnagram("anagram", "nagaran"));
    }

    @Test
    public void testOddEvenListOdd() {
        final ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        final ListNode node = solution.oddEvenList(head);
        Assert.assertEquals(node.value, 1);
        Assert.assertEquals(node.next.value, 3);
        Assert.assertEquals(node.next.next.value, 5);
        Assert.assertEquals(node.next.next.next.value, 2);
        Assert.assertEquals(node.next.next.next.next.value, 4);
    }

    @Test
    public void testOddEvenListEven() {
        final ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        final ListNode node = solution.oddEvenList(head);
        Assert.assertEquals(node.value, 1);
        Assert.assertEquals(node.next.value, 3);
        Assert.assertEquals(node.next.next.value, 5);
        Assert.assertEquals(node.next.next.next.value, 2);
        Assert.assertEquals(node.next.next.next.next.value, 4);
        Assert.assertEquals(node.next.next.next.next.next.value, 6);
    }

    @Test
    public void testOddEvenListEdgeCases() {
        Assert.assertNull(solution.oddEvenList(null));
        ListNode node = solution.oddEvenList(new ListNode(1));
        Assert.assertEquals(node.value, 1);
        Assert.assertNull(node.next);
        node = solution.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3))));
        Assert.assertEquals(node.value, 1);
        Assert.assertEquals(node.next.value, 3);
        Assert.assertEquals(node.next.next.value, 2);
        Assert.assertNull(node.next.next.next);
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray() {
        // Sorted Array
        final int[] values = {0,0,1,1,1,2,2,3,3,4};
        Assert.assertEquals(solution.removeDuplicates(values), 5);
        Assert.assertEquals(values[0], 0);
        Assert.assertEquals(values[1], 1);
        Assert.assertEquals(values[2], 2);
        Assert.assertEquals(values[3], 3);
        Assert.assertEquals(values[4], 4);

        Assert.assertEquals(solution.removeDuplicates(new int[] {1}), 1);
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertFalse(solution.isPalindrome(347));
        Assert.assertTrue(solution.isPalindrome(1221));
    }
}
