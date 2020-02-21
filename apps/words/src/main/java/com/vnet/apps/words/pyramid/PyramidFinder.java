package com.vnet.apps.words.pyramid;

import com.vnet.common.Sums;
import com.vnet.common.VException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
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
            // Valid lengths must be expressed as n*(n+1)/2 values (sum of first n integers)
            // Each valid length n*(n+1)/2 is kept alongside the integer n.
            // It is CRUCIAL to keep that number because if number is a pyramid,
            // it expresses the number of different letters in the word!
            validLengths.put(sum, n);
            log.info("Added {} for {}", sum, n);
            done = sum > maxLength;
            n++;
        }
    }

    public Map<Character, Integer> find(final String word) {
        if (word.length() > maxLength) {
            throw new VException("Word is too long. Max accepted length is " + maxLength);
        }

        final Integer nbExpectedDistinctLetters = validLengths.get(word.length());
        if (nbExpectedDistinctLetters == null) {
            throw new VException("Word of length " + word.length() + " cannot be a pyramid");
        }

        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i=0; i<word.length(); i++) {
            frequencies.merge(word.charAt(i), 1, Integer::sum);
        }

        // If mapped frequencies do not contain the expected number of distinct letters,
        // Then word is not a pyramid
        if (frequencies.size() != nbExpectedDistinctLetters) {
            throw new VException(explainWhyItIsNot(word, frequencies));
        }

        return frequencies;
    }

    private String explainWhyItIsNot(String word, final Map<Character, Integer> frequencies) {
        String s = word + " is not a pyramid word";
        return s;
    }
}
