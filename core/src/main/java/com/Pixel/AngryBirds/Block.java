package com.Pixel.AngryBirds;

public class Block extends GameObject {
    private int health;
    private String material;
    private int hitPoints;

    public Block(Vector2D position, float width, float height, int health, String material, int hitPoints) {
        super(position, width, height);
        this.health = health;
        this.material = material;
        this.hitPoints = hitPoints;
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
