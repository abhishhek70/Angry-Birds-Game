package com.Pixel.AngryBirds;

public class InternPig extends Pig {
    public InternPig(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height, 0, null, 0);
    }

    @Override
    public void takeDamage(int amt) {

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


