package com.Pixel.AngryBirds;

import java.io.Serializable;

public class Block extends GameObject implements Serializable {
    private int health;
    private String material;
    private int hitPoints;

    public Block(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }

    public void takeDamage(int amt) {
    }

    public boolean isDestroyed() {
        return false;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
