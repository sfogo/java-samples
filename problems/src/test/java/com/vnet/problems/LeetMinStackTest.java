package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LeetMinStackTest {

    @Test
    public void testStack() {
        final LeetMinStack stack = new LeetMinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        Assert.assertEquals(stack.getMin(), -3);
        stack.pop();
        Assert.assertEquals(stack.top(), 0);
        Assert.assertEquals(stack.getMin(), -2);
    }

    @Test
    public void testStackRandomly() {
        final LeetMinStack stack = new LeetMinStack();
        final Random random = new Random(System.currentTimeMillis());
        final int size = 8;

        for (int i=0; i<size; i++) {
            final int x = 1 + random.nextInt(100);
            stack.push(x);
            System.out.println("pushed:" + x + " min:" + stack.getMin());
        }

        for (int i=1; i<size; i++) {
            final int x = stack.pop();
            System.out.println("popped:" + x + " min:" + stack.getMin());
        }
    }
}
