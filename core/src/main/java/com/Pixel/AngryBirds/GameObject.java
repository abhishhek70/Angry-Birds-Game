package com.Pixel.AngryBirds;

import com.badlogic.gdx.graphics.Texture;

public abstract class GameObject {

    protected AngryBirdsGame game;
    protected Texture objectTexture;
    protected float x;
    protected float y;
    protected float width;
    protected float height;

    public GameObject(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        this.game = game;
        this.objectTexture = new Texture(texturePath);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//    Abstract methods
    public abstract void update();
    public abstract void render();

//    method for collision check
    public boolean collidesWith(GameObject obj) {

        return false;  // if collision not detected
    }

    public void draw(float posX, float posY){
        game.batch.draw(objectTexture, posX, posY, width, height);
    }

//    getters and setters

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

