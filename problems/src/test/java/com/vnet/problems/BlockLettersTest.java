package com.vnet.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vnet.problems.BlockLetters.Block;
import com.vnet.problems.BlockLetters.BlockSelection;

import java.util.LinkedList;
import java.util.List;

public class BlockLettersTest {
    final BlockLetters blockLetters = new BlockLetters();

    @Test
    public void TestWord() {
        final List<BlockLetters.Block> blocks = new LinkedList<Block>() {{
            add(new Block("WOMMMM"));
            add(new Block("URUUUV"));
            add(new Block("AAAAWA"));
            add(new Block("KLMDMM"));
        }};
        final List<BlockSelection> selectedBlocks = blockLetters.selectBlocks("WORD", blocks);
        Assert.assertEquals(selectedBlocks.size(), 4);
        for (final BlockSelection selection : selectedBlocks) {
            System.out.println(selection.getBlock().getLettersAsString() + " for " + selection.getLetter());
        }
    }
}
