package com.Pixel.AngryBirds;

public class Slingshot extends GameObject {
    private Bird current_Bird;

    public Slingshot(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height);
    }

    public void loadBird(Bird bird) {
        this.current_Bird = bird;
    }

    public void aim(float angle) {
    }

    public void launch(float angle, Vector2D initialVelocity) {

    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }
}

