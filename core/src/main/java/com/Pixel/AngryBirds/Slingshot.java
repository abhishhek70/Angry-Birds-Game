package com.Pixel.AngryBirds;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

public class Slingshot extends GameObject implements Serializable {
    private Bird currentBird;
    private boolean isDragging;
    private Vector2 startPosition;
    private Vector2 dragPosition;
    private ShapeRenderer shapeRenderer;

    public Slingshot(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height);
        this.startPosition = new Vector2(x, y);
        this.dragPosition = new Vector2(x, y);
        this.isDragging = false;
        this.shapeRenderer = new ShapeRenderer();
    }

    public float getX() {
        return startPosition.x;
    }

    public float getY() {
        return startPosition.y;
    }

    public boolean hasBird() {
        return currentBird != null;
    }

    public Bird getCurrentBird() {
        return currentBird;
    }

    public void setCurrentBird(Bird currentBird) {
        this.currentBird = currentBird;
    }

    public void placeBirdOnSlingshot(Bird bird) {
        if (currentBird != null) {
            // Return the current bird to its initial position
            currentBird.setPosition(currentBird.getInitialX(), currentBird.getInitialY());
        }
        // Place the new bird on the slingshot
        currentBird = bird;
        currentBird.setPosition(startPosition.x, startPosition.y);
    }

    public void startDragging(Vector2 dragPosition) {
        if (currentBird != null) {
            this.isDragging = true;
            this.dragPosition.set(dragPosition);
        }
    }

    public void stopDragging(Vector2 releaseVelocity) {
        if (currentBird != null) {
            this.isDragging = false;
            launch(releaseVelocity);
        }
    }

    public void aim(Vector2 dragPosition) {
        if (currentBird != null) {
            this.dragPosition.set(dragPosition);
            currentBird.setPosition(dragPosition.x, dragPosition.y);
        }
    }

    public void launch(Vector2 releaseVelocity) {
        if (currentBird != null) {
            currentBird.setVelocity(releaseVelocity);
            currentBird.launch();
            currentBird = null;
        }
    }

    public void drawProjectilePath() {
        if (currentBird != null && isDragging) {
            shapeRenderer.setProjectionMatrix(game.batch.getProjectionMatrix());
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.RED);

            Vector2 position = new Vector2(dragPosition);
            Vector2 velocity = new Vector2(dragPosition.x - startPosition.x, dragPosition.y - startPosition.y).scl(-1);

            for (int i = 0; i < 100; i++) {
                shapeRenderer.circle(position.x, position.y, 2);
                position.add(velocity);
                velocity.y -= 0.5f; // Simulate gravity
            }

            shapeRenderer.end();
        }
    }

    @Override
    public void update() {
        // Update bird on the slingshot if not launched
        if (currentBird != null && !currentBird.isLaunched) {
            currentBird.setPosition(startPosition.x, startPosition.y);
        }
    }

    @Override
    public void render() {
//        super.render();
    }
}

