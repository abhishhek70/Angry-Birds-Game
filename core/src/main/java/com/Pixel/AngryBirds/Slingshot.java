// core/src/main/java/com/Pixel/AngryBirds/Slingshot.java
package com.Pixel.AngryBirds;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

public class Slingshot extends GameObject implements Serializable {
    private Bird currentBird;
    private Vector2 dragPosition;

    public Slingshot(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height);
        System.out.println("Slingshot, x:" +  x + "y:" + y);
        this.dragPosition = new Vector2();
    }

    public Bird getCurrentBird() {
        return currentBird;
    }

    public void setCurrentBird(Bird currentBird) {
        this.currentBird = currentBird;
    }

    public boolean hasBird() {
        return currentBird != null;
    }

    public void setDragPosition(float x, float y) {
        this.dragPosition.set(x, y);
    }

    public void drawProjectilePath(ShapeRenderer shapeRenderer) {
        if (currentBird != null && currentBird.isDragged()) {
            shapeRenderer.setColor(Color.BLACK);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

            Vector2 birdPosition = new Vector2(currentBird.getX(), currentBird.getY());
            Vector2 slingshotCenter = new Vector2(getX() + getWidth() / 2, getY() + getHeight());
            Vector2 dragDistance = new Vector2(slingshotCenter.x - birdPosition.x, slingshotCenter.y - birdPosition.y);
            float power = dragDistance.len() * 0.07f; // Adjust the multiplier as needed
            float angle = dragDistance.angleRad();
            Vector2 velocity = new Vector2(power * (float) Math.cos(angle), power * (float) Math.sin(angle));
            Vector2 position = new Vector2(birdPosition.x + currentBird.getWidth(), birdPosition.y + currentBird.getHeight());

            for (int i = 0; i < 100; i++) {
                position.add(velocity);
                velocity.add(0, -0.07f); // Gravity
                if (i%2 == 0) {
                    shapeRenderer.circle(position.x, position.y, 1.5f); // Draw a small circle to represent the path
                }
            }

            shapeRenderer.end();
        }
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }
}
