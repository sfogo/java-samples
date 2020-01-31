package com.vnet.problems;

import com.vnet.common.VException;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

public class NEPaths {

    @Data
    class Point {
        final int x;
        final int y;
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
    }

    private List<List<Point>> paths;
    private List<Point> currentPath;

    public List<List<Point>> getPaths(final int width, final int height) {
        if (width < 0) {
            throw new VException("Invalid width");
        }
        if (height < 0) {
            throw new VException("Invalid height");
        }

        paths = new LinkedList<>();
        currentPath = new LinkedList<>();
        getPaths(0, 0, width, height);
        return paths;
    }

    private void getPaths(final int x, final int y, final int width, final int height) {
        currentPath.add(new Point(x, y));

        if (x == width && y == height) {
            // Copy current path to result paths :
            // Each resulting path must contain exactly 1 + x + y points
            paths.add(new LinkedList<>(currentPath));
            return;
        }

        if (x < width) {
            if (currentPath.size() == 1 + width + height) {
                // If current path size is 1 + width + height, it means that top right corner
                // had just been reached : we need to keep the first x + y + 1 points
                // that recursion has already visited.
                currentPath = new LinkedList<>(currentPath.subList(0, x + y + 1));
            }
            getPaths(x + 1, y, width, height);
        }

        if (y < height) {
            if (currentPath.size() == 1 + width + height) {
                currentPath = new LinkedList<>(currentPath.subList(0, x + y + 1));
            }
            getPaths(x, y + 1, width, height);
        }
    }
}
