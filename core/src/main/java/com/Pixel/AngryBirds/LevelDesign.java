package com.Pixel.AngryBirds;

abstract class LevelDesign {
    protected Structure levelStructure;
    protected Image backGround;
    protected List<Bird> levelBirds;
    protected List<Pig> pigTypes;
    protected List<Vector2D> pigPosition;

    public abstract Level generateLevel();
}
