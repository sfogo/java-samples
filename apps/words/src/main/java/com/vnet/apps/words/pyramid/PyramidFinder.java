package com.vnet.apps.words.pyramid;

import com.vnet.common.Sums;
import com.vnet.common.VException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class PyramidFinder {
    @Value("${words.maxLength:100}")
    private int maxLength;

    private Map<Integer, Integer> validLengths;

    @PostConstruct
    void init() {
        validLengths = new HashMap<>();
        boolean done = false;
        int n = 1;
        while (!done) {
            final int sum = Sums.firstN(n);
            // Valid word lengths must be expressed as n*(n+1)/2 values (sum of first n integers)
            // Each valid length n*(n+1)/2 is kept alongside the integer n.
            // It is CRUCIAL to keep that number because if word is a pyramid,
            // it expresses the number of different letters in the word.
            validLengths.put(sum, n);
            log.info("Added {} for {}", sum, n);
            done = sum > maxLength;
            n++;
        }
    }

    public Map<Character, Integer> find(final String word) {
        return get(word.toLowerCase());
    }

    private Map<Character, Integer> get(final String word) {
        if (word.length() > maxLength) {
            throw new VException("Word is too long. Max accepted length is " + maxLength);
        }

        final Integer nbExpectedDistinctLetters = validLengths.get(word.length());
        if (nbExpectedDistinctLetters == null) {
            throw new VException("Word of length " + word.length() + " cannot be a pyramid");
        }

        // Calculate the frequency of each letter
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i=0; i<word.length(); i++) {
            frequencies.merge(word.charAt(i), 1, Integer::sum);
        }

        // If mapped frequencies do not contain the expected number of distinct letters,
        // Then we can tell right away that word is not a pyramid
        if (frequencies.size() != nbExpectedDistinctLetters) {
            throw new VException(word + " is not a pyramid word");
        }

        // We have the right number of letters but we need to check
        // the actual counts. e.g. aaaabbbbcd is not a pyramid and yields 4 entries
        checkFrequencies(word, frequencies);
        return frequencies;
    }

    /**
     * Check Frequencies
     * @param word word
     * @param frequencies mapped frequencies
     */
    private void checkFrequencies(String word, final Map<Character, Integer> frequencies) {
        final List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequencies.entrySet());
        // Sort entries in ascending order
        list.sort(Map.Entry.comparingByValue());

        for (int i=0; i<list.size() ; i++) {
            final Map.Entry<Character, Integer> entry = list.get(i);
            // Entries 0 to n-1 must contain values 1 to n
            if (!entry.getValue().equals(1 + i)) {
                String s = word + " is not a pyramid word.";
                if (i == 0) {
                    s += " Least frequent character " + entry.getKey() + " appears " + entry.getValue();
                    s += " times (while it should appear only once).";
                } else {
                    final Map.Entry<Character, Integer> prev = list.get(i-1);
                    s += " Most frequent character after " + prev.getKey() + "(" + prev.getValue() + ")";
                    s += " is " + entry.getKey() + "(" + entry.getValue() + ")";
                }
                throw new VException(s);
            }
        }
    }
}
