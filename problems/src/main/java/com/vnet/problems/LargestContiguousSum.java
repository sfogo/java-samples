package com.vnet.problems;

import com.vnet.common.VException;

import java.util.function.BiFunction;

public class LargestContiguousSum {

    private BiFunction<Integer, Integer, Integer> max = (a, b) -> a > b ? a : b;

    /**
     * Find largest contiguous sum
     * @param values values
     * @return LCS
     */
    public int get(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }

        int locMax = values[0];
        int absMax = values[0];
        for (int i=1; i<values.length; i++) {
            final int n = values[i];
            locMax = max.apply(locMax + n, n);
            absMax = max.apply(locMax, absMax);
        }
        return absMax;
    }
}
