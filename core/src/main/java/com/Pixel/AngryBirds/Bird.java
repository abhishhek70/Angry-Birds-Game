// core/src/main/java/com/Pixel/AngryBirds/Bird.java
package com.Pixel.AngryBirds;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.io.Serializable;

public abstract class Bird extends GameObject implements Serializable {
    protected String type;
    protected Slingshot slingshot;

    protected float initialX;
    protected float initialY;

    private boolean onSlingshot;
    private boolean isDragged = false;
    private boolean isLaunched = false;
    private boolean hasStopped = false;

    private Vector2 velocity;
    private Vector2 acceleration;

    Bird previousBird = null;
    private static final float GROUND_LEVEL = 50;

    public Bird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, String type, Slingshot slingshot) {
        super(game, texturePath, x, y, width, height);
        this.initialX = x;
        this.initialY = y;
        this.type = type;
        this.slingshot = slingshot;
        this.onSlingshot = false;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, -0.07f); // Gravity

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                previousBird = slingshot.getCurrentBird();
                if (onSlingshot) {
                    isDragged = true;
                } else {
                    putOnSlingshot();
                }
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (isDragged) {
                    float newX = event.getStageX() - getWidth() / 2;
                    float newY = event.getStageY() - getHeight() / 2;
                    float leftLimit = slingshot.getX();
                    float rightLimit = slingshot.getX() + slingshot.getWidth() - getWidth();
                    float topLimit = slingshot.getY() + slingshot.getHeight();
                    float bottomLimit = slingshot.getY() + slingshot.getHeight() / 3;
                    if (newX < leftLimit) {
                        newX = leftLimit;
                    } else if (newX > rightLimit) {
                        newX = rightLimit;
                    }
                    if (newY < bottomLimit) {
                        newY = bottomLimit;
                    } else if (newY > topLimit) {
                        newY = topLimit;
                    }
                    setPosition(newX, newY);
                    slingshot.setDragPosition(newX, newY);
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isDragged = false;
                if (previousBird != null && previousBird == Bird.this) {
                    launch();
                }
            }
        });
    }

    public void putOnSlingshot() {
        if (slingshot.hasBird()) {
            Bird currentBird = slingshot.getCurrentBird();
            if (!currentBird.hasLaunched()) {
                currentBird.resetPosition();
                currentBird.onSlingshot = false;
            }
        }
        float newX = slingshot.getX() + getWidth();
        float newY = slingshot.getY() + slingshot.getHeight() - getHeight();
        setPosition(newX, newY);
        slingshot.setCurrentBird(this);
        onSlingshot = true;
    }

    public void resetPosition() {
        setPosition(initialX, initialY);
        isLaunched = false;
        velocity.set(0, 0);
    }

    public boolean hasLaunched() {
        return isLaunched;
    }

    public boolean isDragged() {
        return isDragged;
    }

    public boolean isOnSlingshot() {
        return onSlingshot;
    }

    public void launch() {
        float slingshotCenterX = slingshot.getX() + slingshot.getWidth() / 2;
        float slingshotCenterY = slingshot.getY() + slingshot.getHeight();
        Vector2 dragDistance = new Vector2(slingshotCenterX - getX(), slingshotCenterY - getY());
        float power = dragDistance.len() * 0.07f; // Adjust the multiplier as needed
        float angle = dragDistance.angleRad();
        velocity.set(power * (float)Math.cos(angle), power * (float)Math.sin(angle));
        isLaunched = true;
        onSlingshot = false;
    }

    public int timeSoFar = 0;
    @Override
    public void update() {
        if (isLaunched && !hasStopped) {
            float oldX = slingshot.getX() + getWidth();
            float oldY = slingshot.getY() + slingshot.getHeight() - getHeight();
            float newX = oldX + velocity.x*timeSoFar + 0.5f*acceleration.x*timeSoFar*timeSoFar;
            float newY = oldY + velocity.y*timeSoFar + 0.5f*acceleration.y*timeSoFar*timeSoFar;
            setPosition(newX, newY);
            if (newY < GROUND_LEVEL) { // Check if the bird is below the ground level
                newY = GROUND_LEVEL; // Set the bird's position to the ground level
                velocity.set(0, 0); // Stop the bird's movement
                hasStopped = true; // Mark the bird as not launched
            }
            timeSoFar++;
        }
    }

    @Override
    public void render() {
        // Render logic here
    }
}
