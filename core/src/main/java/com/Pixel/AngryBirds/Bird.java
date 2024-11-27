//package com.Pixel.AngryBirds;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.scenes.scene2d.Actor;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.InputListener;
//
//import java.io.Serializable;
//
//public abstract class Bird extends GameObject implements Serializable {
//    protected String type;
//    protected Vector2 velocity;
//    protected boolean isLaunched;
//    protected Slingshot slingshot;
//    protected boolean onSlingshot;
//
//    protected float initialX;
//    protected float initialY;
//
//    public Bird(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, String type, Slingshot slingshot) {
//        super(game, texturePath, x, y, width, height);
//        this.initialX = x;
//        this.initialY = y;
//        this.type = type;
//        this.velocity = new Vector2(0, 0);
//        this.isLaunched = false;
//        this.slingshot = slingshot;
//        this.onSlingshot = false;
//
//        addListener(new InputListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                System.out.println("touchDown triggered");
//                if (!isLaunched) {
//                    if (!onSlingshot) {
//                        putOnSlingshot();
//                    }
//                    return true;
//                }
//                return false;
//            }
//
//            @Override
//            public void touchDragged(InputEvent event, float x, float y, int pointer) {
//                if (onSlingshot) {
//                    float newX = event.getStageX() - getWidth() / 2;
//                    float newY = event.getStageY() - getHeight() / 2;
//                    float leftLimit = slingshot.getX();
//                    float rightLimit = slingshot.getX() + slingshot.getWidth() - getWidth();
//                    float topLimit = slingshot.getY() + slingshot.getHeight();
//                    float bottomLimit = slingshot.getY() + slingshot.getHeight() / 3;
//                    if (newX < leftLimit) {
//                        newX = leftLimit;
//                    } else if (newX > rightLimit) {
//                        newX = rightLimit;
//                    }
//                    if (newY < bottomLimit) {
//                        newY = bottomLimit;
//                    } else if (newY > topLimit) {
//                        newY = topLimit;
//                    }
//                    setPosition(newX, newY);
//                    slingshot.aim(new Vector2(newX, newY));
//                }
//            }
//
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                if (onSlingshot) {
//                    putOnSlingshot();
//                }
//            }
//        });
//    }
//
////    @Override
////    public Actor hit(float x, float y, boolean touchable) {
////        System.out.println("Hit check at: " + x + ", " + y);
////        return super.hit(x, y, touchable);
////    }
//
//
//    public void putOnSlingshot() {
//        if (slingshot.hasBird()) {
//            Bird currentBird = slingshot.getCurrentBird();
//            currentBird.setInitialPosition();
//            currentBird.onSlingshot = false;
//        }
//        float newX = slingshot.getX() + getWidth();
//        float newY = slingshot.getY() + slingshot.getHeight() - getHeight();
//        setPosition(newX, newY);
//        velocity.set(0, 0);
//        isLaunched = false;
//        slingshot.setCurrentBird(this);
//        onSlingshot = true;
//    }
//
//    public abstract void applySpecialAbility();
//
//    public void setVelocity(Vector2 velocity) {
//        this.velocity.set(velocity);
//    }
//
//    public void setPosition(float x, float y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public void setInitialPosition() {
//        setPosition(initialX, initialY);
//    }
//
//    public float getX() {
//        return x;
//    }
//
//    public float getY() {
//        return y;
//    }
//
//    public Vector2 getVelocity() {
//        return velocity;
//    }
//
//    public void launch() {
//        isLaunched = true;
//    }
//
//    @Override
//    public void update() {
//        if (isLaunched) {
//            // Update position based on velocity
//            setPosition(getX() + velocity.x, getY() + velocity.y);
//            velocity.y -= 0.5f; // Simulate gravity
//        }
//    }
//
//    @Override
//    public void render() {
////        super.render();
//    }
//}

package com.Pixel.AngryBirds;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.io.Serializable;

public abstract class Bird extends GameObject implements Serializable {
    protected String type;
    protected Vector2 velocity;
    protected boolean isLaunched;
    protected Slingshot slingshot;
    protected boolean onSlingshot;

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
        this.onSlingshot = false;

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("touchDown triggered");
                if (!isLaunched) {
                    if (!onSlingshot) {
                        putOnSlingshot();
                    }
                    return true;
                }
                return false;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (onSlingshot) {
                    slingshot.startDragging(new Vector2(event.getStageX(), event.getStageY()));
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
                    slingshot.aim(new Vector2(newX, newY));
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (onSlingshot) {
//                    putOnSlingshot();
                    slingshot.stopDragging(new Vector2(event.getStageX(), event.getStageY()));
                    float releaseX = getX() - slingshot.getX();
                    float releaseY = getY() - slingshot.getY();
                    Vector2 releaseVelocity = new Vector2(releaseX, releaseY).scl(-1); // Adjust the scale factor as needed
                    setVelocity(releaseVelocity);
                    launch();
                }
            }
        });
    }

//    @Override
//    public Actor hit(float x, float y, boolean touchable) {
//        System.out.println("Hit check at: " + x + ", " + y);
//        return super.hit(x, y, touchable);
//    }

    public void putOnSlingshot() {
        if (slingshot.hasBird()) {
            Bird currentBird = slingshot.getCurrentBird();
            currentBird.setInitialPosition();
            currentBird.onSlingshot = false;
        }
        float newX = slingshot.getX() + getWidth();
        float newY = slingshot.getY() + slingshot.getHeight() - getHeight();
        setPosition(newX, newY);
        velocity.set(0, 0);
        isLaunched = false;
        slingshot.setCurrentBird(this);
        onSlingshot = true;
        setTouchable(Touchable.enabled); // Ensure the bird is touchable
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
        // Render logic here
    }

    public float getInitialX() {
        return initialX;
    }

    public float getInitialY() {
        return initialY;
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, width, height);
    }
}
