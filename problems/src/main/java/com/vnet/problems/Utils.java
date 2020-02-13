package com.vnet.problems;

import com.vnet.common.VException;

import java.util.List;

public class Utils {
    /**
     * Find where to insert value in list
     * @param list list sorted ascending
     * @return insert position
     */
    public int sortedListedInsertPosition(final List<Integer> list, final int value) {
        if (list == null) {
            throw new VException("Null list");
        }
        if (list.size() == 0) {
            return 0;
        }
        return sortedListedInsertPosition(list, value, 0, list.size() - 1);
    }

    private int sortedListedInsertPosition(
            final List<Integer> values,
            final int value,
            final int first,
            final int last) {
        if (first == last) {
            return value > values.get(first) ? 1 + first : first;
        }

        if (last == 1 + first) {
            if (value <= values.get(first)) {
                return first;
            } else if (value >= values.get(last)) {
                return last;
            } else {
                return 1 + first;
            }
        }

        final int mid = (first + last) / 2;
        final int midValue = values.get(mid);
        if (value <= midValue) {
            return sortedListedInsertPosition(values, value, first, mid);
        } else {
            return sortedListedInsertPosition(values, value, 1+mid, last);
        }
    }
}
