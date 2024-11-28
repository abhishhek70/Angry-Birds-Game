package com.Pixel.AngryBirds;

public class RedBird extends Bird {

    public RedBird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, Slingshot slingshot) {
        super(game, texturePath, x, y, width, height, "Red", slingshot);
    }

//    @Override
//    public void update() {
//    }

    @Override
    public void render() {
        System.out.println("Rendering RedBird");
    }
}

