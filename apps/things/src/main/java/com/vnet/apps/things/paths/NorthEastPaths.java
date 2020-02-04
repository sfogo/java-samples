package com.vnet.apps.things.paths;

import lombok.Data;
import com.vnet.common.VException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class NorthEastPaths {

    @Data
    static class Point {
        final int x;
        final int y;

        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
    }

    private static class PathContext {
        private final List<List<Point>> paths = new LinkedList<>();
        private List<Point> currentPath = new LinkedList<>();
        private int count = 0;

        private void traverseForCount(final int x, final int y, final int width, final int height) {
            if (x == width && y == height) {
                count++;
                return;
            }

            if (x < width) {
                traverseForCount(x + 1, y, width, height);
            }

            if (y < height) {
                traverseForCount(x, y + 1, width, height);
            }
        }

        private void traverse(final int x, final int y, final int width, final int height) {
            currentPath.add(new Point(x, y));

            if (x == width && y == height) {
                // Copy current path to result paths :
                // Each resulting path must contain exactly 1 + x + y points
                paths.add(new LinkedList<>(currentPath));
                return;
            }

            if (x < width) {
                traverse(x + 1, y, width, height);
            }

            if (y < height) {
                if (currentPath.size() == 1 + width + height) {
                    // If current path size is 1 + width + height, it means that top right corner
                    // had just been reached : we need to keep the first x + y + 1 points
                    // that recursion has already visited.
                    // NOTE: no need to do that check above for x < width because only when you go up (change of direction)
                    // do you need to retain the points recursively traversed so far.
                    currentPath = new LinkedList<>(currentPath.subList(0, x + y + 1));
                }
                traverse(x, y + 1, width, height);
            }
        }

        private void validate(final int width, final int height) {
            if (width < 0) {
                throw new VException("Invalid width");
            }
            if (height < 0) {
                throw new VException("Invalid height");
            }
        }

        private int count(final int width, final int height) {
            validate(width, height);
            count = 0;
            traverseForCount(0, 0, width, height);
            return count;
        }

        private List<List<Point>> getPaths(final int width, final int height) {
            validate(width, height);
            traverse(0, 0, width, height);
            return paths;
        }
    }

    public List<List<Point>> get(final int width, final int height) {
        return new PathContext().getPaths(width, height);
    }


    public int count(final int width, final int height) {
        return new PathContext().count(width, height);
    }
}
