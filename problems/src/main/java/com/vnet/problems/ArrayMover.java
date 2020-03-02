package com.vnet.problems;

import com.vnet.common.VException;

public class ArrayMover {
    public void shiftLeft(final int from, final int count, final int[] values) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }

        if (from <= 0 || from >= values.length) {
            throw new VException("Index out of range:" + from);
        }

        if (from + count > values.length) {
            throw new VException("Count is too high:" + count);

        }

        for (int i = from; i < from + count; i++) {
            values[i-1] = values[i];
        }
    }

    public int indexOf(final int value, final int[] values, final int start, final int count) {
        if (values == null || values.length == 0) {
            throw new VException("No values");
        }

        if (start < 0 || start >= values.length) {
            throw new VException("Invalid start index:" + start);
        }

        if (count < 0 || start + count > values.length) {
            throw new VException("Invalid count:" + count);
        }

        for (int i=start; i<start+count; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void moveZerosToEnd(final int[] values) {
        moveValueToEnd(values, 0);
    }

    public void moveValueToEnd(final int[] values, final int x) {
        int at = 0;
        int length = values.length;
        while ((at = indexOf(x, values, at, length)) >= 0 && at < length - 1) {
            shiftLeft(at+1, length - at - 1, values);
            values[length - 1] = x;
            length--;
        }
    }
}
