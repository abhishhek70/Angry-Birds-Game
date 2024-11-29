package com.Pixel.AngryBirds;
//
//import com.badlogic.gdx.graphics.Texture;
//
//public abstract class GameObject {
//
//    protected AngryBirdsGame game;
//    protected Texture objectTexture;
//    protected float x;
//    protected float y;
//    protected float width;
//    protected float height;
//
//    public GameObject(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
//        this.game = game;
//        this.objectTexture = new Texture(texturePath);
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//    }
//
////    Abstract methods
//    public abstract void update();
//    public abstract void render();
//
////    method for collision check
//    public boolean collidesWith(GameObject obj) {
//
//        return false;  // if collision not detected
//    }
//
//    public void draw(){
//        game.batch.draw(objectTexture, x, y, width, height);
//    }
//
////    getters and setters
//
//    public float getWidth() {
//        return width;
//    }
//
//    public void setWidth(float width) {
//        this.width = width;
//    }
//
//    public float getHeight() {
//        return height;
//    }
//
//    public void setHeight(float height) {
//        this.height = height;
//    }
//}
//



import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.io.Serializable;

public abstract class GameObject extends Actor implements Serializable {
    protected transient AngryBirdsGame game;
    protected transient Texture texture;
    protected float x, y, width, height;

    public GameObject(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        this.game = game;
        this.texture = new Texture(texturePath);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x, y, width, height);
    }

//    @Override
    public void draw() {
        game.batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, width, height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public abstract void update();
    public abstract void render();
}
