package com.vnet.common;

public class Fibonacci {
    public int recursive(final int n)  {
        if (n < 0) {
            throw new VException("Invalid value:" + n);
        }
        return rFibo(n);
    }

    private int rFibo(final int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        return recursive(n-1) + recursive(n-2);
    }

    public int iterative(final int n) {
        if (n < 0) {
            throw new VException("Invalid value:" + n);
        }

        int un0 = 1;
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
