package com.vnet.problems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class Node {
    private final static MaxFinder maxFinder = new MaxFinder();
    private char value;
    private List<Node> children;

    public Node(final char value) {
        this.value = value;
        this.children = null;
    }

    public Node(final char value, final Node... children) {
        this.value = value;
        for (final Node node : children) {
            addChild(node);
        }
    }

    private boolean hasNoChildren() {
        return children == null || children.size() == 0;
    }

    private boolean hasChildren() {
        return !hasNoChildren();
    }

    private int letterRank() {
        return (value - 'A') + 1;
    }

    public void addChild(final Node node) {
        if (children == null) {
            children = new LinkedList<>();
        }
        children.add(node);
    }

    public int heightByDepth() {
        return heightByDepth(this, 0);
    }

    @Data
    @AllArgsConstructor
    static private class QNode {
        private final Node node;
        private final int depth;
    }

    public int heightByBreadth() {
        final Queue<QNode> queue = new LinkedList<>();
        queue.add(new QNode(this, 0));
        int h = 0;
        while (!queue.isEmpty()) {
            final QNode n = queue.poll();
            if (n.depth > h) {
                h = n.depth;
            }
            if (n.node.hasChildren()) {
                for (final Node child : n.node.children) {
                    queue.add(new QNode(child, 1 + n.depth));
                }
            }
        }
        return h;
    }

    static private int heightByDepth(final Node node, final int level) {
        if (node.hasNoChildren()) {
            return level;
        }

        final int[] heights = new int[node.children.size()];
        for (int c=0; c<node.children.size(); c++) {
            heights[c] = heightByDepth(node.children.get(c), 1 + level);
        }
        return maxFinder.getMaxValue(heights);
    }

    public void traverseDepthFirstAssumeTree() {
        traverseDepthFirstAssumeTree(this, 0);
    }

    public void traverseBreadthFirstAssumeTree() {
        traverseBreadthFirstAssumeTree(this);
    }

    public List<List<Node>> getAllPathsDepthFirstAssumeTree() {
        return new TreePathContext().collectPaths(this);
    }

    public List<List<Node>> getAllPathsDepthFirstAssumeTree2() {
        return new TreePathContext().collectPaths2(this);
    }

    private static class TreePathContext {
        private LinkedList<Node> currentPath;
        private List<List<Node>> paths;

        private List<List<Node>> collectPaths(final Node node) {
            currentPath = new LinkedList<>();
            paths = new LinkedList<>();
            collect(node, 0);
            return paths;
        }

        /**
         * No need to initialize current path with starting node
         * BUT need to trim current path up to current node before
         * recurring into each child.
         * @param node node
         * @param depth current depth
         */
        private void collect(final Node node, final int depth) {
            log.info("{}{}:{}", padding(depth), node.value, node.letterRank());
            currentPath.add(node);

            if (node.hasNoChildren()) {
                paths.add(new LinkedList<>(currentPath));
                log.info("PATH#{}: {}", paths.size(), pathToString(currentPath));
                return;
            }

            for (final Node child : node.children) {
                trimCurrentPathEnd(node);
                collect(child, 1 + depth);
            }
        }

        /*
         * Starting from the end of current path,
         * remove nodes until current node is met.
         * @param node current node
         */
        private void trimCurrentPathEnd(final Node node) {
            boolean done = false;
            while (!done) {
                if (currentPath.peekLast().value == node.value) {
                    done = true;
                } else {
                    currentPath.pollLast();
                }
            }
        }

        private List<List<Node>> collectPaths2(final Node node) {
            currentPath = new LinkedList<>();
            paths = new LinkedList<>();
            currentPath.add(node);
            collect2(node, 0);
            return paths;
        }

        /**
         * Current path was initialized with starting node
         * @param node node
         * @param depth current depth
         */
        private void collect2(final Node node, final int depth) {
            log.info("{}{}:{}", padding(depth), node.value, node.letterRank());

            if (node.hasNoChildren()) {
                paths.add(new LinkedList<>(currentPath));
                log.info("PATH#{}: {}", paths.size(), pathToString(currentPath));
                return;
            }

            for (final Node child : node.children) {
                currentPath.add(child);
                collect2(child, 1 + depth);
                currentPath.remove(child);
            }
        }
    }

    private static void traverseDepthFirstAssumeTree(final Node node, final int depth) {
        log.info("{}{}:{}", padding(depth), node.value, node.letterRank());

        if (node.hasNoChildren()) {
            return;
        }

        for (final Node child : node.children) {
            traverseDepthFirstAssumeTree(child, 1 + depth);
        }
    }

    private static void traverseBreadthFirstAssumeTree(final Node root) {
        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            final Node n = queue.poll();
            log.info("{}{}:{}", padding(level), n.value, n.letterRank());
            if (n.hasChildren()) {
                level++;
                queue.addAll(n.children);
            }
        }
    }

    private static String padding(final int size) {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<size; i++) {
            s.append("..");
        }
        return s.toString();
    }

    static String pathToString(final List<Node> path) {
        if (path == null || path.size() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(path.get(0).value);
        for (int i=1; i<path.size(); i++) {
            builder.append("-").append(path.get(i).value);
        }
        return builder.toString();
    }
}
