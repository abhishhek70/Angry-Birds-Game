package com.Pixel.AngryBirds;

public class YellowBird extends Bird {

    public YellowBird(Vector2D position, float width, float height) {
        super(position, width, height, "Yellow");
    }

    @Override
    public void applySpecialAbility() {
        System.out.println("YellowBird speed boost activated!");
    }

    @Override
    public void render() {
        System.out.println("Rendering YellowBird");
    }
}

