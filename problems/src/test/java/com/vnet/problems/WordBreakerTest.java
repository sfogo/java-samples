package com.vnet.problems;

import com.vnet.common.VException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordBreakerTest {
    private final WordBreaker breaker1 = new WordBreaker(new String[] {
            "i", "like",
            "sam", "sung", "samsung", "mobile",
            "ice", "cream", "icecream",
            "man", "go", "mango",
            "blue", "green"
    });

    @Test
    public void testFind01() {
        final String sentence = "ilike";
        final String[] words = breaker1.breakup(sentence);
        Assert.assertEquals(words.length, 2);
        System.out.println("Sentence:" + sentence);
        show(words);
    }

    @Test
    public void testFind02() {
        final String sentence = "ilikecream";
        final String[] words = breaker1.breakup(sentence);
        Assert.assertEquals(words.length, 3);
        System.out.println("Sentence:" + sentence);
        show(words);
    }

    @Test
    public void testFind03() {
        final String sentence = "samsungbluegreen";
        final String[] words = breaker1.breakup(sentence);
        Assert.assertEquals(words.length, 4);
        System.out.println("Sentence:" + sentence);
        show(words);
    }

    @Test(expectedExceptions = VException.class)
    public void testFind04() {
        final String sentence = "samsungyellow";
        breaker1.breakup(sentence);
    }

    @Test(expectedExceptions = VException.class)
    public void testFind05() {
        final String sentence = "yellow";
        breaker1.breakup(sentence);
    }

    @Test
    public void testFind06() {
        final String sentence = "greengocream";
        final String[] words = breaker1.breakup(sentence);
        Assert.assertEquals(words.length, 3);
        System.out.println("Sentence:" + sentence);
        show(words);
    }

    private void show(final String[] words) {
        for (final String word : words) {
            System.out.println(word);
        }
    }
}
