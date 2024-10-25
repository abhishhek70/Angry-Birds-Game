package com.Pixel.AngryBirds;

public class RedBird extends Bird {

    public RedBird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height, "Red");
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

