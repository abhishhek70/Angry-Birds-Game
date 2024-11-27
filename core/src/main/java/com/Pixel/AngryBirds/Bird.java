//package com.Pixel.AngryBirds;
//
//public abstract class Bird extends GameObject {
//    protected String type;
//    protected Vector2D velocity;
//
//    public Bird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, String type) {
//        super(game, texturePath, x, y, width, height);
//        this.type = type;
//        this.velocity = new Vector2D(0, 0); // Initial velocity
//    }
//
//    public void putOnSlingShot() {
//    }
////abstract method for to use special ability
//    public abstract void applySpecialAbility();
//
//    public void setVelocity(Vector2D velocity) {
//        this.velocity = velocity;
//    }
//
//    public Vector2D getVelocity() {
//        return velocity;
//    }
//
//    @Override
//    public void update() {
//    }
//
//    @Override
//    public void render() {
//    }
//}
//

package com.Pixel.AngryBirds;

import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

public abstract class Bird extends GameObject implements Serializable {
    protected String type;
    protected Vector2 velocity;
    protected boolean isLaunched;

    public Bird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, String type) {
        super(game, texturePath, x, y, width, height);
        this.type = type;
        this.velocity = new Vector2(0, 0);
        this.isLaunched = false;
    }

    public void putOnSlingshot(float x, float y) {
        setPosition(x, y);
        velocity.set(0, 0);
        isLaunched = false;
    }

    public abstract void applySpecialAbility();

    public void setVelocity(Vector2 velocity) {
        this.velocity.set(velocity);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void launch() {
        isLaunched = true;
    }

    @Override
    public void update() {
        if (isLaunched) {
            // Update position based on velocity
            setPosition(getX() + velocity.x, getY() + velocity.y);
            velocity.y -= 0.5f; // Simulate gravity
        }
    }

    @Override
    public void render() {
//        super.render();
    }
}
