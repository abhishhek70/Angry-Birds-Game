package com.Pixel.AngryBirds;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public abstract class Bird extends GameObject {
    protected String type;
    protected Vector2 velocity;
    protected boolean isLaunched;
    protected Slingshot slingshot;

    protected float initialX;
    protected float initialY;

    public Bird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, String type, Slingshot slingshot) {
        super(game, texturePath, x, y, width, height);
        this.initialX = x;
        this.initialY = y;
        this.type = type;
        this.velocity = new Vector2(0, 0);
        this.isLaunched = false;
        this.slingshot = slingshot;

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (!isLaunched) {
                    putOnSlingshot();
                    return true;
                }
                return false;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (!isLaunched) {
                    slingshot.aim(new Vector2(x, y));
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (!isLaunched) {
                    Vector2 releaseVelocity = new Vector2(initialX - x, initialY - y).scl(2); // Adjust the scaling factor as needed
                    slingshot.stopDragging(releaseVelocity);
                }
            }
        });
    }

    public void putOnSlingshot() {
        if (slingshot.hasBird()) {
            Bird currentBird = slingshot.getCurrentBird();
            currentBird.setInitialPosition();
        }
        float newX = slingshot.getX() + getWidth();
        float newY = slingshot.getY() + slingshot.getHeight() - getHeight();
        setPosition(newX, newY);
        velocity.set(0, 0);
        isLaunched = false;
        slingshot.setCurrentBird(this);
    }

    public abstract void applySpecialAbility();

    public void setVelocity(Vector2 velocity) {
        this.velocity.set(velocity);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setInitialPosition() {
        setPosition(initialX, initialY);
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
