package com.Pixel.AngryBirds;

class InternPig extends Pig {
    public InternPig(Vector2D position, float width, float height) {
        super(position, width, height, 50, "small", 10);
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


