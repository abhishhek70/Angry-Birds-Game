package com.Pixel.AngryBirds;

import java.io.Serializable;
import com.badlogic.gdx.physics.box2d.Body;
public class InternPig extends Pig implements Serializable {
    private transient Body body;

    public InternPig(AngryBirdsGame game, String texturePath, float x, float y, float width, float height) {
        super(game, texturePath, x, y, width, height, 0, null, 0);
    }


    @Override
    public void takeDamage(int amt) {

    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }
    public void setBody(Body body) {
        this.body = body;
        body.setUserData(this);
    }
    public Body getBody() {
        return body;
    }
}


