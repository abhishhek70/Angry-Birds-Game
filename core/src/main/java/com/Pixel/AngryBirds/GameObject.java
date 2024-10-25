package com.Pixel.AngryBirds;

public abstract class GameObject {

    protected Vector2D position;  // Assuming you have a Vector2D class for 2D vectors
    protected float width;
    protected float height;

    public GameObject(Vector2D position, float width, float height) {
        this.position = position;
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

//    getters and setters
    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

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

