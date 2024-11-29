package com.Pixel.AngryBirds;

import com.badlogic.gdx.physics.box2d.Body;

import java.io.Serializable;

public abstract class Pig extends GameObject implements Serializable {
    protected int health;
    protected String size;
    protected int hit_Points;
    private transient Body body;

    public Pig(AngryBirdsGame game, String texturePath, float x, float y, float width, float height, int health, String size, int hit_Points) {
        super(game, texturePath, x, y, width, height);
        this.health = health;
        this.size = size;
        this.hit_Points = hit_Points;
    }

    public abstract void takeDamage(int amt);
    public abstract boolean isDestroyed();

    public void setBody(Body body) {
        this.body = body;
        body.setUserData(this);
    }

    public Body getBody() {
        return body;
    }

    @Override
    public void update() {
        if (body != null) {
            setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
        }
    }

    @Override
    public abstract void render();
}
