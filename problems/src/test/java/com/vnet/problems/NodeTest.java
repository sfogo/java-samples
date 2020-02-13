package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NodeTest {

    private Node createTree() {
        final Node n9 = new Node('I');
        final Node n10= new Node('J');
        final Node n11= new Node('K');
        final Node n12= new Node('L');

        final Node n5 = new Node('E', n9, n10);
        final Node n6 = new Node('F');
        final Node n7 = new Node('G', n11, n12);
        final Node n8 = new Node('H');

        final Node n2 = new Node('B', n5, n6);
        final Node n3 = new Node('C');
        final Node n4 = new Node('D', n7, n8);

        return new Node('A', n2, n3, n4);
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
