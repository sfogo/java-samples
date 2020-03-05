package com.vnet.problems;

import java.util.Stack;

public class LeetMinStack {
    private Stack<Integer> values = new Stack<>();
    private Stack<Integer> minValues = new Stack<>();

    public void push(final int x) {
        values.push(x);
        if (minValues.empty()) {
            minValues.push(x);
        } else if (x < minValues.peek()) {
            minValues.push(x);
        }
    }

    public int pop() {
        final int x = values.pop();
        if (x == minValues.peek()) {
            minValues.pop();
        }
        return x;
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minValues.peek();
    }
}
