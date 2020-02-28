package com.vnet.problems;

import com.vnet.common.VException;

public class BestBuySell {

    final int get(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No Values");
        }
        int min = values[0];
        int best = 0;
        for (int i=1; i<values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            } else {
                best = Math.max(best, values[i] - min);
            }
        }
        return best;
    }

    final int get2(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No Values");
        }
        int min = values[0];
        int best = 0;
        for (int i=1; i<values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            // This will work too even though it
            // unnecessarily updates best value too soon :
            // There is no need to update the best value
            // as long as next value is a lower minimum
            best = Math.max(best, values[i] - min);
        }
        return best;
    }
}
