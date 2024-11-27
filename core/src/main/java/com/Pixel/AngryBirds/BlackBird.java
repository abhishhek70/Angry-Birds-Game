package com.Pixel.AngryBirds;

public class BlackBird extends Bird {

    public BlackBird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, Slingshot slingshot) {
        super(game, texturePath, x, y, width, height, "Black", slingshot);
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

