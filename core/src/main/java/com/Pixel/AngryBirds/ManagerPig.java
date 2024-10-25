package com.Pixel.AngryBirds;

class ManagerPig extends Pig {
    public ManagerPig(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, int health) {
        super(game, texturePath, x, y, width, height, 0, null, 0);
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
