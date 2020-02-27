package com.vnet.problems;

import com.vnet.common.VException;

import java.util.LinkedList;
import java.util.List;

public class WordBreaker {
    private final String[] dictionary;

    public WordBreaker(final String[] dictionary) {
        this.dictionary = dictionary;
        if (dictionary == null || dictionary.length == 0) {
            throw new VException("Invalid dictionary");
        }
    }

    public String[] breakup(final String sentence) {
        if (sentence == null || sentence.length() == 0) {
            throw new VException("Invalid sentence");
        }
        final List<Integer> indices = new BreakupContext().breakup(sentence);
        final String[] words = new String[indices.size()];
        for (int i=0; i<indices.size(); i++) {
            words[i] = dictionary[indices.get(i)];
        }
        return words;
    }

    private class BreakupContext {
        private boolean done;
        private LinkedList<Integer> currentIndices;
        private List<Integer> responseIndices;

        private List<Integer> breakup(final String sentence) {
            currentIndices = new LinkedList<>();
            responseIndices = null;
            breakupSentence(sentence);
            if (responseIndices == null) {
                throw new VException("Cannot breakup " + sentence);
            }
            return responseIndices;
        }

        private void breakupSentence(final String sentence) {
            if (sentence.length() == 0) {
                responseIndices = new LinkedList<>(currentIndices);
                return;
            }

            final List<Integer> candidates = getCandidateIndices(sentence);
            if (candidates.size() == 0) {
                throw new VException("Cannot decompose sentence:" + sentence);
            }


            for (final Integer integer : candidates) {
                if (responseIndices == null) {
                    try {
                        currentIndices.add(integer);
                        // Break up remaining portion
                        breakupSentence(sentence.substring(dictionary[integer].length()));
                        currentIndices.pollLast();
                    } catch (VException e) {
                        currentIndices.pollLast();
                    }
                }
            }
        }
    };

    /**
     * Returns possible starts for sentence
     * @param sentence sentence
     * @return list of all words (as indices) that are a beginning of the sentence
     */
    private List<Integer> getCandidateIndices(final String sentence) {
        final List<Integer> indices = new LinkedList<>();
        for (int i=0; i<dictionary.length; i++) {
            if (sentence.startsWith(dictionary[i])) {
                indices.add(i);
            }
        }
        return indices;
    }
}
