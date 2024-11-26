package com.Pixel.AngryBirds;

import com.Pixel.AngryBirds.Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class AngryBirdsGame extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Viewport viewport;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        setScreen(new LoadingScreen(this));
//        setScreen(new PauseScreen(this));
//        setScreen(new HomeScreen(this));
        setScreen(new GameScreen1(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
