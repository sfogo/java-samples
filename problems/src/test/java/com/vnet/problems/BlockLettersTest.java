package com.vnet.problems;

import com.vnet.common.VException;
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
        showBlocks(blocks);
        final List<BlockSelection> selectedBlocks = blockLetters.selectBlocks("WORD", blocks);
        Assert.assertEquals(selectedBlocks.size(), 4);
        show(selectedBlocks);
    }

    @Test
    public void testABC() {
        final List<BlockLetters.Block> blocks = new LinkedList<Block>() {{
            add(new Block("AAA"));
            add(new Block("BBC"));
            add(new Block("BOO"));
            add(new Block("DDD"));
        }};
        showBlocks(blocks);
        final List<BlockSelection> selectedBlocks = blockLetters.selectBlocks("ABC", blocks);
        Assert.assertEquals(selectedBlocks.size(), 3);
        show(selectedBlocks);
    }

    @Test(expectedExceptions = VException.class)
    public void testNotEnoughCubes() {
        final List<BlockLetters.Block> blocks = new LinkedList<Block>() {{
            add(new Block("AAA"));
            add(new Block("BBC"));
            add(new Block("DDD"));
        }};
        blockLetters.selectBlocks("ABCD", blocks);
    }

    @Test
    public void testZoo() {
        final List<BlockLetters.Block> blocks = new LinkedList<Block>() {{
            for (int i=0; i<8; i++) {
                add(new Block(TestHelper.generate(6)));
            }
        }};
        try {
            showBlocks(blocks);
            final List<BlockSelection> selectedBlocks = blockLetters.selectBlocks("ZOO", blocks);
            Assert.assertEquals(selectedBlocks.size(), 3);
            show(selectedBlocks);
        } catch (VException e) {
            // ignore
        }
    }

    @Test
    public void testBigger() {
        final List<BlockLetters.Block> blocks = new LinkedList<Block>() {{
            add(new Block("ASLXSB"));
            add(new Block("CMSNMV"));
            add(new Block("AVATJU"));
            add(new Block("JIMNZS"));
            add(new Block("EZFLFU"));
            add(new Block("KUFQOI"));
            add(new Block("LCVYMJ"));
            add(new Block("ZQUMSY"));
            add(new Block("UJLMCM"));
            add(new Block("RUZMMG"));
            add(new Block("NRMNNO"));
            add(new Block("HPKNMD"));
        }};
        showBlocks(blocks);
        final String word = "ABCDEF";
        final List<BlockSelection> selectedBlocks = blockLetters.selectBlocks(word, blocks);
        Assert.assertEquals(selectedBlocks.size(), word.length());
        show(selectedBlocks);
    }

    private void show(final List<BlockSelection> selectedBlocks) {
        for (final BlockSelection selection : selectedBlocks) {
            System.out.println(selection.getBlock().getLettersAsString() + " for " + selection.getLetter());
        }
    }

    private void showBlocks(final List<Block> blocks) {
        for (final Block block : blocks) {
            System.out.println(block.getLettersAsString());
        }
    }
}
