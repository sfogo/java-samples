package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeetTreeTest {
    final LeetTree solution = new LeetTree();

    @Test
    public void testDepthZero() {
        Assert.assertEquals(solution.depth(null), 0);
    }

    @Test
    public void testDepthOne() {
        Assert.assertEquals(solution.depth(new BinaryTreeNode(1)), 1);
    }

    @Test
    public void testDepthTwo() {
        Assert.assertEquals(solution.depth(new BinaryTreeNode(1,
                new BinaryTreeNode(2),
                new BinaryTreeNode(3))), 2);
    }

    @Test
    public void testDepthThree() {
        Assert.assertEquals(solution.depth(new BinaryTreeNode(3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)))), 3);
    }

    @Test
    public void testDepthLeftAlwaysNull() {
        Assert.assertEquals(solution.depth(new BinaryTreeNode(1,
                null,
                new BinaryTreeNode(2, null,
                        new BinaryTreeNode(3, null,
                                new BinaryTreeNode(4, null,
                                        new BinaryTreeNode(5)))))), 5);
    }

    @Test
    public void testIsBalanced123() {
        Assert.assertTrue(solution.isBalanced(new BinaryTreeNode(2,
                new BinaryTreeNode(1),
                new BinaryTreeNode(3))));
    }

    @Test
    public void testIsBalanced() {
        Assert.assertTrue(solution.isBalanced(new BinaryTreeNode(0,
                new BinaryTreeNode(-3,
                        new BinaryTreeNode(-10),
                        null),
                new BinaryTreeNode(9,
                        new BinaryTreeNode(5),
                        null))));
    }

    @Test
    public void testFromArray() {
        final int[] values = new int[] {-10,-3,0,5,9};
        final BinaryTreeNode tree = solution.fromSortedArray(values);
        Assert.assertEquals(tree.value, 0);

        Assert.assertEquals(tree.left.value, -10);
        Assert.assertEquals(tree.left.right.value, -3);
        Assert.assertNull(tree.left.left);

        Assert.assertEquals(tree.right.value, 5);
        Assert.assertEquals(tree.right.right.value, 9);
        Assert.assertNull(tree.right.left);
    }
}
