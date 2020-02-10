package com.vnet.problems;

import com.vnet.common.VException;

public class SAFinder {
    private static void checkValues(final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No Values");
        }
    }

    public int findAny(final int value, final int[] values) {
        checkValues(values);

        int inf = 0;
        int sup = values.length - 1;
        while (inf <= sup) {
            final int mid = (inf + sup) / 2;
            final int v = values[mid];
            if (value == v) {
                return mid;
            } else if (value < v) {
                sup = mid - 1;
            } else {
                inf = mid + 1;
            }
        }
        throw new VException("Not Found");
    }

    /**
     * Find any starting at a given index and considering a given number of elements
     * @param value value to find
     * @param values array
     * @param start start at this index
     * @param count number of elements to consider from start index
     * @return index where value is found, throw exception if value not found
     */
    public int findAny(final int value, final int[] values, final int start, final int count) {
        checkValues(values);

        if (start < 0 || start >= values.length) {
            throw new VException("Invalid start: " + start);
        }

        if (count <= 0) {
            throw new VException("Invalid Count:" + count);
        }

        if (start + count > values.length) {
            throw new VException("Count too high:" + count);
        }

        int inf = start;
        int sup = start + count - 1;
        while (inf <= sup) {
            final int mid = (inf + sup) / 2;
            final int v = values[mid];
            if (value == v) {
                return mid;
            } else if (value < v) {
                sup = mid - 1;
            } else {
                inf = mid + 1;
            }
        }
        throw new VException("Not Found");
    }

    public int findFirstOccurrence(final int value, final int[] values) {
        checkValues(values);

        int count = values.length;
        int counter = 0;
        while (true) {
            try {
                count = findAny(value, values, 0, count);
                counter++;
            } catch (VException e) {
                if (counter == 0) {
                    throw e;
                } else {
                    return count;
                }
            }
        }
    }

    public int findLastOccurrence(final int value, final int[] values) {
        checkValues(values);

        int start = 0;
        int count = values.length;
        int counter = 0;
        while (true) {
            try {
                start = 1 + findAny(value, values, start, count);
                count = values.length - start;
                counter++;
            } catch (VException e) {
                if (counter == 0) {
                    throw e;
                } else {
                    // -1 because start gets updated
                    // with latest index found + 1
                    return start - 1;
                }
            }
        }
    }

    public ArrayRange findOccurrences(final int value, final int[] values) {
        return new ArrayRange(findFirstOccurrence(value, values), findLastOccurrence(value, values));
    }
}
