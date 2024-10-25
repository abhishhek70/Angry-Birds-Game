package com.Pixel.AngryBirds;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;


abstract class LevelDesign {
    protected Structure levelStructure;
    protected Texture backGround;
    protected List<Bird> levelBirds;
    protected List<Pig> pigTypes;
    protected List<Vector2D> pigPosition;

    public abstract Level generateLevel();
}
