package com.vnet.problems;

import com.vnet.common.VException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SAFinderOccurrencesTest {
    private final int[] values = new int[] {1, 2, 4, 8, 11, 11, 11,11, 11, 11, 11, 11, 11, 11, 11, 11, 13, 13, 17};
    private final SAFinder finder = new SAFinder();

    @Test
    public void findFirstOne() {
        Assert.assertEquals(finder.findFirstOccurrence(1, new int[] {1}), 0);
    }

    @Test
    public void findFirst17() {
        Assert.assertEquals(finder.findFirstOccurrence(17, values), values.length - 1);
    }

    @Test
    public void findLast17() {
        Assert.assertEquals(finder.findLastOccurrence(17, values), values.length - 1);
    }

    @Test
    public void findFirstThree() {
        Assert.assertEquals(finder.findFirstOccurrence(3, new int[] {1,2,3,4}), 2);
    }

    @Test
    public void findLastThree() {
        Assert.assertEquals(finder.findFirstOccurrence(3, new int[] {1,2,3,4}), 2);
    }

    @Test
    public void findFirstOccurrence() {
        Assert.assertEquals(finder.findFirstOccurrence(11, values), 4);
    }

    @Test(expectedExceptions = VException.class)
    public void testFONotFound() {
        finder.findFirstOccurrence(137, values);
    }

    @Test(expectedExceptions = VException.class)
    public void testLONotFound() {
        finder.findLastOccurrence(137, values);
    }

    @Test
    public void findLastOccurrence() {
        Assert.assertEquals(finder.findLastOccurrence(11, values), 15);
    }

    @Test
    public void findOccurrences() {
        final ArrayRange range = finder.findOccurrences(11, values);
        Assert.assertEquals(range.getStart(), 4);
        Assert.assertEquals(range.getEnd(), 15);
    }

    @Test
    public void findOccurrencesSame() {
        final int[] sameValues = new int[] {7, 7, 7, 7, 7};
        final ArrayRange range = finder.findOccurrences(7, sameValues);
        Assert.assertEquals(range.getStart(), 0);
        Assert.assertEquals(range.getEnd(), sameValues.length - 1);
    }
}


