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

        final Node n5 = new Node('E');
        final Node n6 = new Node('F');
        final Node n7 = new Node('G');
        final Node n8 = new Node('H');

        n5.addChild(n9);
        n5.addChild(n10);

        n7.addChild(n11);
        n7.addChild(n12);

        final Node n2 = new Node('B');
        final Node n3 = new Node('C');
        final Node n4 = new Node('D');

        n2.addChild(n5);
        n2.addChild(n6);

        n4.addChild(n7);
        n4.addChild(n8);

        final Node root = new Node('A');
        root.addChild(n2);
        root.addChild(n3);
        root.addChild(n4);

        return root;
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
