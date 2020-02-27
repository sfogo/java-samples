package com.vnet.problems;

import com.vnet.common.VException;

import java.util.LinkedList;
import java.util.List;

public class Stairs {
    /**
     * Calculate the number of ways to climb n steps knowing that
     * you can do one step or two steps at a time.
     * @param n number of steps
     * @return number of different ways to climb
     */
    public int climb(final int n) {
        if (n <= 0) {
            throw new VException("Invalid number of steps: " + n);
        }
        return countClimbPaths(n);
    }

    public List<List<Integer>> getClimbPaths(final int n) {
        return new ClimbContext().collectPaths(n);
    }

    private int countClimbPaths(final int n) {
        return new ClimbContext().count(n);
    }

    private static class ClimbContext {
        private LinkedList<Integer> currentPath;
        private List<List<Integer>> paths;
        private int count;

        private void count(final int step, final int n) {
            if (step == n) {
                count++;
                return;
            }

            // step + 1 <= n
            if (step < n) {
                count(step + 1, n);
            }

            // step + 2 <= n
            if (step < n-1) {
                count(step + 2, n);
            }
        }

        private int count(final int n) {
            count = 0;
            count(0, n);
            return count;
        }

        private void collect(final int step, final int n) {
            if (step == n) {
                paths.add(new LinkedList<>(currentPath));
                return;
            }

            // step + 1 <= n
            if (step < n) {
                currentPath.add(step + 1);
                collect(step + 1, n);
                currentPath.pollLast();
            }

            // step + 2 <= n
            if (step < n-1) {
                currentPath.add(step + 2);
                collect(step + 2, n);
                currentPath.pollLast();
            }
        }

        private List<List<Integer>> collectPaths(final int n) {
            currentPath = new LinkedList<>();
            paths = new LinkedList<>();
            collect(0, n);
            return paths;
        }
    }
}
