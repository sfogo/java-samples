package com.vnet.problems;

import com.vnet.common.VException;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @Data
    @AllArgsConstructor
    static class Result {
        private int max;
        private int start;
        private int end;
    }

    /**
     * Find LCS
     * @param values values
     * @return result
     */
    public Result getWithIndices(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }
        final Result locResult = new Result(values[0], 0, 0);
        final Result absResult = new Result(values[0], 0, 0);

        for (int i=1; i<values.length; i++) {
            final int n = values[i];
            if (n + locResult.max > n) {
                locResult.max = n + locResult.max;
                locResult.end += 1;
            } else {
                locResult.max = n;
                locResult.start = i;
                locResult.end = i;
            }
            if (locResult.max > absResult.max) {
                absResult.max = locResult.max;
                absResult.start = locResult.start;
                absResult.end = locResult.end;
            }
        }
        return absResult;
    }
}
