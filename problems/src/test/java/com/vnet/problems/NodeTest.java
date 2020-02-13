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
    }
}
