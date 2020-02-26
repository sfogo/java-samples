package com.vnet.problems;

import com.vnet.common.VException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

public class BlockLetters {
    @Data
    public static class Block {
        private final String lettersAsString;
        private final char[] letters;
        public boolean contains(final char c) {
            for (final char letter : letters) {
                if (letter == c) {
                    return true;
                }
            }
            return false;
        }

        public Block(final String s) {
            lettersAsString = s;
            letters = new char[s.toUpperCase().length()];
            for (int i=0; i<s.length(); i++) {
                letters[i] = s.charAt(i);
            }
        }
    }

    @Data
    @AllArgsConstructor
    public static class BlockSelection {
        private Block block;
        private char letter;
    }

    public List<BlockSelection> selectBlocks(final String word, final List<Block> blocks) {
        return select(word.toUpperCase(), blocks);
    }

    private List<BlockSelection> select(final String word, final List<Block> blocks) {
        if (word == null || word.length() == 0) {
            throw new VException("word is empty");
        }
        final List<BlockSelection> selectedBlocks = new LinkedList<>();
        final List<Block> remainingBlocks = new LinkedList<>(blocks);
        for (int i=0; i<word.length(); i++) {
            final char letter = word.charAt(i);
            // -------------------------------
            // Check if letter is available
            // in one of the remaining blocks
            // -------------------------------
            final Block block = find(letter, remainingBlocks);
            if (block == null) {
                // Letter was NOT found in one of the remaining blocks.
                // Let's see if one of the selected blocks may have stolen the letter
                // and if we could swap one selected cube with one remaining block.
                // In order for a swap to be possible, the following condition must be met:
                // One selected block must contain current letter AND
                // the letter ts was selected for must be available in one of the remaining blocks
                Block remainingBlock = null;
                Integer swapIndex = null;
                for (int s=0; s<selectedBlocks.size(); s++) {
                    final BlockSelection selection = selectedBlocks.get(s);
                    if (selection.getBlock().contains(letter)) {
                        remainingBlock = find(selection.letter, remainingBlocks);
                        if (remainingBlock != null) {
                            // Swap is possible
                            swapIndex = s;
                            break;
                        }
                    }
                }
                if (swapIndex != null) {
                    // remove the found replacement from remaining blocks
                    remainingBlocks.remove(remainingBlock);
                    // Get swapped selection
                    final BlockSelection swappedSelection = selectedBlocks.get(swapIndex);
                    // Remove it from selected blocks
                    selectedBlocks.remove(swappedSelection);
                    // put replacement in place of swapped selection
                    selectedBlocks.add(swapIndex, new BlockSelection(remainingBlock, swappedSelection.letter));
                    // Added swapped block for current letter
                    selectedBlocks.add(new BlockSelection(swappedSelection.block, letter));
                }
            } else {
                // Letter was found in one of the remaining blocks
                // - Add it to selection
                // - Remove it from remaining blocks
                selectedBlocks.add(new BlockSelection(block, letter));
                remainingBlocks.remove(block);
            }
        }

        if (selectedBlocks.size() == word.length()) {
            return selectedBlocks;
        }

        throw new VException("Cannot make word: " + word);
    }

    /**
     * Tells whether letter is in one of the blocks
     * @param letter letter
     * @param blocks block list
     * @return first block found, null otherwise
     */
    private Block find(final char letter, final List<Block> blocks) {
        for (final Block block : blocks) {
            if (block.contains(letter)) {
                return block;
            }
        }
        return null;
    }
}
