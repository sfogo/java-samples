package com.vnet.problems;

import com.vnet.common.VException;

public class MaxFinder {
    public int getMaxPosition(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }
        return getMaxPosition(values, 0,values.length - 1);
    }

    public int getMaxValue(final int[] values) {
        return values[getMaxPosition(values)];
    }

    public int scanForMaxPosition(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }
        int maxPosition = 0;
        for (int pos = 1; pos < values.length; pos++) {
            if (values[pos] > values[maxPosition]) {
                maxPosition = pos;
            }
        }
        return maxPosition;
    }

    public int scanForMaxValue(final int[] values) {
        return values[scanForMaxPosition(values)];
    }

    private int getMaxPosition(final int[] values, final int first, final int last) {
        // --------------
        // Only one left
        // --------------
        if (first == last) {
            return first;
        }

        // --------------
        // Only two left
        // --------------
        if (last == 1 + first) {
            return values[first] > values[last] ? first : last;
        }

        // --------------
        // Left & Right
        // --------------
        final int mid = (first + last) / 2;
        final int leftPos = getMaxPosition(values, first, mid);
        final int rightPos= getMaxPosition(values, 1 + mid, last);
        return values[leftPos] > values[rightPos] ? leftPos : rightPos;
    }
}
