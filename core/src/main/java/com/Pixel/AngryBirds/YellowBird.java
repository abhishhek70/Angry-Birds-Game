package com.Pixel.AngryBirds;

import java.io.Serializable;

public class YellowBird extends Bird implements Serializable {

    public YellowBird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, Slingshot slingshot) {
        super(game, texturePath, x, y, width, height, "Yellow", slingshot);
    }

//    @Override
//    public void update() {
//    }

    @Override
    public void render() {
        System.out.println("Rendering YellowBird");
    }
}

