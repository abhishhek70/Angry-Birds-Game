package com.Pixel.AngryBirds;

public abstract class Pig extends GameObject {
    protected int health;
    protected String size;
    protected int hit_Points;

    public Pig(Vector2D position, float width, float height, int health, String size, int hit_Points) {
        super(position, width, height);
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
