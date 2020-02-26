package com.vnet.problems;

import com.vnet.common.VException;

import java.util.Random;

public class TestHelper {
    private static Random random = new Random(System.currentTimeMillis());

    private TestHelper() {
        // override default construction
    }

    public static int[][] createIntMatrix(final int nbRows, final int nbCols, final int minValue, final int maxValue) {
        if (nbRows < 1) {
            throw new VException("Invalid number of rows:" + nbRows);
        }
        if (nbCols < 1) {
            throw new VException("Invalid number of columns:" + nbCols);
        }
        if (minValue > maxValue) {
            throw new VException("Invalid minimum value:" + maxValue);
        }

        final int[][] matrix = new int[nbRows][nbCols];
        for (int i=0; i<nbRows; i++) {
            for (int j=0; j<nbCols; j++) {
                matrix[i][j] = getValueInRange(minValue, maxValue);
            }
        }
        return matrix;
    }

    public static int[] createIntArray(final int size, final int minValue, final int maxValue) {
        if (size < 1) {
            throw new VException("Invalid size:" + size);
        }
        if (minValue > maxValue) {
            throw new VException("Invalid minimum value:" + minValue);
        }

        final int[] a = new int[size];
        for (int i=0; i<size; i++) {
            a[i] = getValueInRange(minValue, maxValue);
        }
        return a;
    }

    /**
     * Get value within range
     * @param minValue minimum value (inclusive)
     * @param maxValue maximum value (inclusive)
     * @return value
     */
    private static int getValueInRange(final int minValue, final int maxValue) {
        return minValue + random.nextInt(maxValue - minValue + 1);
    }

    public static String generate(final int length) {
        final byte[] bytes = new byte[length];
        for (int i=0; i<length; i++) {
            bytes[i] = (byte) ('A' + random.nextInt(26));
        }
        return new String(bytes);
    }
}
