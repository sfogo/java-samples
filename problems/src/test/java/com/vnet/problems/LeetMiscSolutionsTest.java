package com.vnet.problems;

import com.vnet.common.Fibonacci;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class LeetMiscSolutionsTest {
    final Fibonacci fibonacci = new Fibonacci(true);
    final Random random = new Random(System.currentTimeMillis());
    final LeetMiscSolutions solution = new LeetMiscSolutions();

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
        Assert.assertEquals(new HashSet<>(list).size(), fibonacci.iterative(5));
    }

    @Test
    public void testParenthesisWithFour() {
        final List<String> list = solution.generateParenthesis(4);
        Assert.assertEquals(list.size(), 13);
        Assert.assertEquals(new HashSet<>(list).size(), fibonacci.iterative(7));
    }

    @Test
    public void testParenthesisWithFive() {
        final List<String> list = solution.generateParenthesis(5);
        Assert.assertEquals(list.size(), 34);
        Assert.assertEquals(new HashSet<>(list).size(), fibonacci.recursive(9));
    }

    @Test
    public void testParenthesisWith2ndMethod() {
        final List<String> list = solution.genParenthesis(3);
        Assert.assertEquals(list.size(), 5);
    }
}
