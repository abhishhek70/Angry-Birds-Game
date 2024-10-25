package com.Pixel.AngryBirds;

public abstract class Bird extends GameObject {
    protected String type;
    protected Vector2D velocity;

    public Bird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, String type) {
        super(game, texturePath, x, y, width, height);
        this.type = type;
        this.velocity = new Vector2D(0, 0); // Initial velocity
    }

    public void putOnSlingShot() {
    }
//abstract method for to use special ability
    public abstract void applySpecialAbility();

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }
}

