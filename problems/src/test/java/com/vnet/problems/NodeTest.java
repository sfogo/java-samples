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
    public void testDF() {
        final Node root = createTree();
        root.traverseDepthFirstAssumeTree();
    }

    @Test
    public void testBF() {
        final Node root = createTree();
        root.traverseBreadthFirstAssumeTree();
    }

    @Test
    public void testGetAllPaths() {
        final Node root = createTree();
        final List<List<Node>> list = root.getAllPathsDepthFirstAssumeTree();
        Assert.assertEquals(list.size(), 7);
        Assert.assertEquals(Node.pathToString(list.get(0)), "A-B-E-I");
        Assert.assertEquals(Node.pathToString(list.get(1)), "A-B-E-J");
        Assert.assertEquals(Node.pathToString(list.get(2)), "A-B-F");
        Assert.assertEquals(Node.pathToString(list.get(3)), "A-C");
        Assert.assertEquals(Node.pathToString(list.get(4)), "A-D-G-K");
        Assert.assertEquals(Node.pathToString(list.get(5)), "A-D-G-L");
        Assert.assertEquals(Node.pathToString(list.get(6)), "A-D-H");
    }
}
