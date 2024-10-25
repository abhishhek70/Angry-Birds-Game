package com.Pixel.AngryBirds;

public class YellowBird extends Bird {

    public YellowBird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height, "Yellow");
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

