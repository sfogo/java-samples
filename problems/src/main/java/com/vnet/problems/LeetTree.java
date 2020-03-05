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

    public BinaryTreeNode fromSortedArray(final int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        return create(values, 0, values.length - 1);
    }

    private BinaryTreeNode create(final int[] values, final int left, final int right) {
        if (left > right) {
            return null;
        }

        final int mid = (left + right) / 2;
        return new BinaryTreeNode(values[mid],
                create(values, left, mid-1),
                create(values, mid + 1, right));
    }
}
