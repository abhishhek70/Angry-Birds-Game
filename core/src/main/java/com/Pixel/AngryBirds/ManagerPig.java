package com.Pixel.AngryBirds;

class ManagerPig extends Pig {
    public ManagerPig(Vector2D position, float width, float height) {
        super(position, width, height, 100, "medium", 20);
    }

    @Override
    public void takeDamage(int amt) {
        health -= amt;
        if (health < 0) {
            health = 0;
        }
    }

    @Override
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
