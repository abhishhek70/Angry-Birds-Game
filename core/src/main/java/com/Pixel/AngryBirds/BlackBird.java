package com.Pixel.AngryBirds;

public class BlackBird extends Bird {

    public BlackBird(Vector2D position, float width, float height) {
        super(position, width, height, "Black");
    }

    @Override
    public void applySpecialAbility() {
        System.out.println("Blackbird has activated bomb");
    }

    @Override
    public void render() {
        System.out.println("Rendering BlueBird");
    }
}

