package com.vnet.problems;

public class LeetTree {
    public int depth(final BinaryTreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(depth(tree.left), depth(tree.right));
    }

    public boolean isBalanced(final BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left == null) {
            return node.value <= node.right.value && isBalanced(node.right);
        }

        if (node.right == null) {
            return node.left.value <= node.value && isBalanced(node.left);
        }

        return node.left.value <= node.value && node.value <= node.right.value
                && isBalanced(node.left)
                && isBalanced(node.right);
    }
}
