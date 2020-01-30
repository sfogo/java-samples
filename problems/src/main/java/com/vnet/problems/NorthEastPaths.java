package com.vnet.problems;

import com.vnet.common.VException;

public class NorthEastPaths {
    private int count;

    public int count(final int width, final int height) {
        if (width < 0) {
            throw new VException("Invalid width");
        }
        if (height < 0) {
            throw new VException("Invalid height");
        }
        count = 0;
        countPaths(0, 0, width, height);
        return count;
    }

    private void countPaths(final int x, final int y, final int width, final int height) {
        if (x == width && y == height) {
            count++;
            return;
        }

        if (x < width) {
            countPaths(x + 1, y, width, height);
        }

        if (y < height) {
            countPaths(x, y + 1, width, height);
        }
    }
}
