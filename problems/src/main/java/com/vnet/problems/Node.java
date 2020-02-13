package com.vnet.problems;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class Node {
    private char value;
    private List<Node> children;

    public Node(final char value) {
        this.value = value;
        this.children = null;
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

    public void traverseDepthFirstAssumeTree() {
        traverseDepthFirstAssumeTree(this, 0);
    }

    public void traverseBreadthFirstAssumeTree() {
        traverseBreadthFirstAssumeTree(this);
    }

    public List<List<Node>> getAllPathsDepthFirstAssumeTree() {
        return new TreePathContext().collectPaths(this);
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
         * Starting from the end of current path, remove nodes until current node is met.
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

    private static String pathToString(final List<Node> path) {
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
