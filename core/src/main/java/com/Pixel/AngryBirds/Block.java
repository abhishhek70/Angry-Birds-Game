package com.Pixel.AngryBirds;

import java.io.Serializable;
import com.badlogic.gdx.physics.box2d.Body;


public class Block extends GameObject implements Serializable {
    private int health;
    private String material;
    private int hitPoints;
    private transient Body body;


    public Block(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height);
    }

    @Override
    public void update() {
        if (body != null) {
            setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
        }
    }

    @Override
    public void render() {
    }

    public void takeDamage(int amt) {
        health -= amt;
    }


    public boolean isDestroyed() {
        return health <= 0;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setBody(Body body) {
        this.body = body;
        body.setUserData(this);
    }

    public Body getBody() {
        return body;
    }
}
