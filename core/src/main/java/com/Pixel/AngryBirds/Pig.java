package com.Pixel.AngryBirds;

import java.io.Serializable;

public abstract class Pig extends GameObject implements Serializable {
    protected int health;
    protected String size;
    protected int hit_Points;

    public Pig(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, int health, String size, int hit_Points) {
        super(game, texturePath, x, y, width, height);
        this.health = health;
        this.size = size;
        this.hit_Points = hit_Points;
    }

    public abstract void takeDamage(int amt);
    public abstract boolean isDestroyed();

    @Override
    public abstract void update();

    @Override
    public abstract void render();
}
