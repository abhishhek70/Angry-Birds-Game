package com.Pixel.AngryBirds;

import com.Pixel.AngryBirds.Screens.HomeScreen;
import com.Pixel.AngryBirds.Screens.LoadingScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class AngryBirdsGame extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new LoadingScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
