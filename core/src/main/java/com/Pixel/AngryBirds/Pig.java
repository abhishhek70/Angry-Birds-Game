package com.Pixel.AngryBirds;

public class Pig extends GameObject {
    private int health;
    private String size;
    private int hit_Points;

    public Pig(Vector2D position, float width, float height, int health, String size, int hit_Points) {
        super(position, width, height);
        this.health = health;
        this.size = size;
        this.hit_Points = hit_Points;
    }

    public void takeDamage(int amt) {
        health -= amt;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }
}


