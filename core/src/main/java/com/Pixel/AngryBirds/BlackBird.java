package com.Pixel.AngryBirds;

import java.io.Serializable;

public class BlackBird extends Bird implements Serializable {

    public BlackBird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, Slingshot slingshot) {
        super(game, texturePath, x, y, width, height, "Black", slingshot);
    }

//    @Override
//    public void update() {
//
//    }

    @Override
    public void render() {
        System.out.println("Rendering BlueBird");
    }
}

