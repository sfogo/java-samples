package com.vnet.common;

public class Fibonacci {
    private final boolean startAtZero;

    public Fibonacci(final boolean startAtZero) {
        this.startAtZero = startAtZero;
    }

    public Fibonacci() {
        this(false);
    }

    public int recursive(final int n)  {
        if (n < 0) {
            throw new VException("Invalid value:" + n);
        }
        return f(n);
    }

    private int f(final int n) {
        if (n == 0) {
            return startAtZero ? 0 : 1;
        }
        return n < 2 ? 1 : f(n-1) + f(n-2);
    }

    public int iterative(final int n) {
        if (n < 0) {
            throw new VException("Invalid value:" + n);
        }

        int un0 = startAtZero ? 0 : 1;
        if (n == 0) {
            return un0;
        }

        int un1 = 1;
        if (n == 1) {
            return un1;
        }

        int un2 = un1 + un0;
        for (int i=0; i<n-2; i++) {
            un0 = un1;
            un1 = un2;
            un2 = un1 + un0;
        }
        return un2;
    }
}
