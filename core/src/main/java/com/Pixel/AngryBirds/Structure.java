package com.Pixel.AngryBirds;
import java.util.ArrayList;
import java.util.List;

public class Structure {
    private List<Block> blocks;
    private List<Vector2D> blockPositions;

    public Structure() {
        blocks = new ArrayList<>();
        blockPositions = new ArrayList<>();
    }

    public boolean collapseCheck() {
        return false;
    }

    public void addBlock(Block block, Vector2D position) {
    }

    public void removeBlock(int index) {
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Vector2D> getBlockPositions() {
        return blockPositions;
    }

    public void setBlockPositions(List<Vector2D> blockPositions) {
        this.blockPositions = blockPositions;
    }

    public Block getBlock(int index) {
        return (index >= 0 && index < blocks.size()) ? blocks.get(index) : null;
    }

    public Vector2D getBlockPosition(int index) {
        return (index >= 0 && index < blockPositions.size()) ? blockPositions.get(index) : null;
    }

    public void updateBlocks() {

    }

    public void renderBlocks() {
    }
}
