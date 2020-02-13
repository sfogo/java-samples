package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NodeTest {

    private Node createTree() {
        return new Node('A',
                new Node('B',
                        new Node('E',
                                new Node('I'),
                                new Node('J')),
                        new Node('F')),
                new Node('C'),
                new Node('D',
                        new Node('G',
                                new Node('K'),
                                new Node('L')),
                        new Node('H')));
    }

    @Test
    public void testTraverseTreeDepthFirst() {
        final Node root = createTree();
        root.traverseDepthFirstAssumeTree();
    }

    @Test
    public void testTraverseTreeBreadthFirst() {
        final Node root = createTree();
        root.traverseBreadthFirstAssumeTree();
    }

    @Test
    public void testGetAllPaths() {
        final List<List<Node>> paths = createTree().getAllPathsDepthFirstAssumeTree();
        Assert.assertEquals(paths.size(), 7);
        Assert.assertEquals(Node.pathToString(paths.get(0)), "A-B-E-I");
        Assert.assertEquals(Node.pathToString(paths.get(1)), "A-B-E-J");
        Assert.assertEquals(Node.pathToString(paths.get(2)), "A-B-F");
        Assert.assertEquals(Node.pathToString(paths.get(3)), "A-C");
        Assert.assertEquals(Node.pathToString(paths.get(4)), "A-D-G-K");
        Assert.assertEquals(Node.pathToString(paths.get(5)), "A-D-G-L");
        Assert.assertEquals(Node.pathToString(paths.get(6)), "A-D-H");
    }

    @Test
    public void testTreeHeight() {
        Assert.assertEquals(createTree().heightAssumeTree(), 3);
    }
}
