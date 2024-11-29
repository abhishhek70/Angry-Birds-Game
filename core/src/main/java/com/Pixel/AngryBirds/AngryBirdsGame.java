package com.Pixel.AngryBirds;

import com.Pixel.AngryBirds.Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.audio.Music;

import java.io.Serial;
import java.io.Serializable;

public class AngryBirdsGame extends Game {
//    @Serial
//    private static final long serialVersionUID = 1L;

    public  transient SpriteBatch batch;
    public  transient OrthographicCamera camera;
    public  transient Viewport viewport;
    private  transient Music backgroundMusic;


    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("background.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
        setScreen(new LoadingScreen(this));
//        setScreen(new PauseScreen(this));
//        setScreen(new HomeScreen(this));
//        setScreen(new GameScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }
    public void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
            backgroundMusic.dispose();
        }
    }
}
