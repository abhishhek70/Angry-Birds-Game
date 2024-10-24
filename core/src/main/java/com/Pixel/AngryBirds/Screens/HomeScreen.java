package com.Pixel.AngryBirds.Screens;

import com.Pixel.AngryBirds.AngryBirdsGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HomeScreen implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    Texture backgroundTexture;
    Texture loadGameButtonTexture;
    Texture playGameButtonTexture;
    private ImageButton imageButtonLoad;
    private ImageButton imageButtonPlay;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;
//    private static final float PLAY_BUTTON_X;
//    private static final float PLAY_BUTTON_Y;
//    private static final float LOAD_BUTTON_X;
//    private static final float LOAD_BUTTON_Y;


    public HomeScreen(AngryBirdsGame game){
        this.game = game;

        backgroundTexture = new Texture("homeScreenBackground.png");
        loadGameButtonTexture = new Texture("loadGameButton.png");
        playGameButtonTexture = new Texture("playGameButton.png");

        Drawable buttonDrawableLoad = new TextureRegionDrawable(new TextureRegion(loadGameButtonTexture));
        Drawable buttonDrawablePlay = new TextureRegionDrawable(new TextureRegion(playGameButtonTexture));

//        camera = new OrthographicCamera();
//        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
//        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        this.camera = game.camera;
        this.viewport = game.viewport;

        imageButtonLoad = new ImageButton(buttonDrawableLoad, buttonDrawableLoad);
        imageButtonLoad.setSize(200, 100);
        imageButtonLoad.setPosition(WORLD_WIDTH/2 - 100, WORLD_HEIGHT/2 - 100);

        imageButtonPlay = new ImageButton(buttonDrawablePlay, buttonDrawablePlay);
        imageButtonPlay.setSize(200, 100);
        imageButtonPlay.setPosition(WORLD_WIDTH/2 - 100, WORLD_HEIGHT/2 );

        imageButtonLoad.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LoadingScreen(game));  // Change it later
            }
        });

        imageButtonPlay.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new levelChooseScreen(game));  // Change it later
            }
        });

        stage = new Stage(viewport);
        stage.addActor(imageButtonLoad);
        stage.addActor(imageButtonPlay);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        game.batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
        viewport.update(width, height);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        backgroundTexture.dispose();
        loadGameButtonTexture.dispose();
        playGameButtonTexture.dispose();
        stage.dispose();
    }
}
