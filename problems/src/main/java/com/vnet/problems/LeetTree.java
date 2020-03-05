package com.vnet.problems;

public class LeetTree {
    public int depth(final BinaryTreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(depth(tree.left), depth(tree.right));
    }
}
