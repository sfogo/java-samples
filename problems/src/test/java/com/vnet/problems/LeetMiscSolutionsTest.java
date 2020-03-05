package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LeetMiscSolutionsTest {
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
}
