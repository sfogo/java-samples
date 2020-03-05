package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeetTreeTest {
    final LeetTree tree = new LeetTree();

    @Test
    public void testDepthZero() {
        Assert.assertEquals(tree.depth(null), 0);
    }

    @Test
    public void testDepthOne() {
        Assert.assertEquals(tree.depth(new BinaryTreeNode(1)), 1);
    }

    @Test
    public void testDepthTwo() {
        Assert.assertEquals(tree.depth(new BinaryTreeNode(1,
                new BinaryTreeNode(2),
                new BinaryTreeNode(3))), 2);
    }

    @Test
    public void testDepthThree() {
        Assert.assertEquals(tree.depth(new BinaryTreeNode(3,
                new BinaryTreeNode(9),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15),
                        new BinaryTreeNode(7)))), 3);
    }

    @Test
    public void testDepthLeftAlwaysNull() {
        Assert.assertEquals(tree.depth(new BinaryTreeNode(1,
                null,
                new BinaryTreeNode(2, null,
                        new BinaryTreeNode(3, null,
                                new BinaryTreeNode(4, null,
                                        new BinaryTreeNode(5)))))), 5);
    }
}
