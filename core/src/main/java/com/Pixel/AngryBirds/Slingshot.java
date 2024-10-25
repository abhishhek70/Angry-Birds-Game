package com.Pixel.AngryBirds;

public class Slingshot extends GameObject {
    private Bird currentBird;

    public Slingshot(Vector2D position, float width, float height) {
        super(position, width, height);
    }

    public void loadBird(Bird bird) {
        this.currentBird = bird;
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

