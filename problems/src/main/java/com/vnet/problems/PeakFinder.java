package com.vnet.problems;

import com.vnet.common.VException;

public class PeakFinder {
    public int findAny(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }
        return find(values, 0, values.length - 1);
    }

    private int find(final int[] values, final int low, final int high) {
        final int mid = (low + high) / 2;
        final int v = values[mid];
        if (mid-1 >= 0 && values[mid-1] > v) {
            return find(values, 0, mid-1);
        } else if (mid+1 < values.length && values[mid+1] > v) {
            return find(values, mid+1, high);
        } else {
            return mid;
        }
    }
}
