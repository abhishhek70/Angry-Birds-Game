//package com.Pixel.AngryBirds;
//
//public class Slingshot extends GameObject {
//    private Bird current_Bird;
//
//    public Slingshot(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
//        super(game, texturePath, x, y, width, height);
//    }
//
//    public void loadBird(Bird bird) {
//        this.current_Bird = bird;
//    }
//
//    public void aim(float angle) {
//    }
//
//    public void launch(float angle, Vector2D initialVelocity) {
//
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

public class Slingshot extends GameObject {
    private Bird currentBird;
    private boolean isDragging;
    private Vector2 startPosition;

    public Slingshot(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height);
        this.startPosition = new Vector2(x, y);
        this.isDragging = false;
    }

//    public void loadBird(Bird bird) {
//        this.currentBird = bird;
//        bird.putOnSlingshot(getX(), getY());
//    }

    public float getX() {
        return startPosition.x;
    }

    public float getY() {
        return startPosition.y;
    }

    public boolean hasBird() {
        return currentBird != null;
    }

    public void setCurrentBird(Bird currentBird) {
        this.currentBird = currentBird;
    }

    public void aim(Vector2 dragPosition) {
        if (currentBird != null) {
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

