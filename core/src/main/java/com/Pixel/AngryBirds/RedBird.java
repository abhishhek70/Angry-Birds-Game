package com.Pixel.AngryBirds;

public class RedBird extends Bird {

    public RedBird(Vector2D position, float width, float height) {
        super(position, width, height, "Red");
    }

    @Override
    public void applySpecialAbility() {

        System.out.println("RedBird has no special ability.");
    }

    @Override
    public void render() {
        System.out.println("Rendering RedBird");
    }
}

