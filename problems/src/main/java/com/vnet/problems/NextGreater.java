package com.vnet.problems;

import com.vnet.common.VException;

import java.util.LinkedList;
import java.util.List;

public class NextGreater {
    /**
     * Find next greater number with same digits
     * @param n number
     * @return next greater
     */
    public int get(final int n) {
        // find Length of longest decreasing sequence from the end
        final List<Integer> digits = new LinkedList<>();
        int value = n;
        int count = 0;
        int previousDigit = -1;
        boolean sequenceFound = false;
        while (value > 0) {
            final int digit = value % 10;
            if (!sequenceFound && digit >= previousDigit) {
                count++;
            } else {
                sequenceFound = true;
            }
            digits.add(0, digit);
            value = value / 10;
            previousDigit = digit;
        }

        if (count == digits.size()) {
            throw new VException("No next greater");
        }

        // we have all digits in the list and the last count digits
        // are the long decreasing from right (indices length-count to length-1)
        // In last count digits, find which one is the first one
        // that is strictly bigger than number placed just before decreasing sequence
        final int swap = digits.get(digits.size() - count - 1);
        Integer swappedIndex = null;
        for (int i=digits.size() - 1; i >= digits.size() - count && swappedIndex==null; i--) {
            if (digits.get(i) > swap) {
                swappedIndex = i;
            }
        }
        if (swappedIndex == null) {
            throw new VException("Error");
        }

        final Integer removed = digits.remove(swappedIndex.intValue());
        // Put differ value at same index
        digits.add(swappedIndex, swap);
        // size is still the same
        digits.remove(digits.size() - count - 1);
        // CAREFUL : size is lower by one now
        digits.add(digits.size() - count, removed);

        // Reverse the last count digits
        // to make it as small as possible
        final List<Integer> result = new LinkedList<>();
        for (int i=0; i<digits.size() - count; i++) {
            result.add(digits.get(i));
        }
        for (int i=digits.size()-1; i >= digits.size()-count; i--) {
            result.add(digits.get(i));
        }

        return convert(result);
    }

    private int convert(final List<Integer> digits) {
        int n = 0;
        for (final Integer digit : digits) {
            n = 10*n + digit;
        }
        return n;
    }
}
