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

public class LoseScreen implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Texture backgroundTexture;
    private Texture restartLevelButtonTexture;
    private Texture menuButtonTexture;

    private ImageButton imageButtonRestartLevel;
    private ImageButton imageButtonMenu;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public LoseScreen(AngryBirdsGame game){
        this.game = game;

        backgroundTexture = new Texture("loseScreenBackground.png");
        restartLevelButtonTexture = new Texture("restartButton.png");
        menuButtonTexture = new Texture("menuButton.png");

        this.camera = game.camera;
        this.viewport =  game.viewport;

        Drawable buttonDrawableRestart = new TextureRegionDrawable(new TextureRegion(restartLevelButtonTexture));
        Drawable buttonDrawableMenu = new TextureRegionDrawable(new TextureRegion(menuButtonTexture));

        imageButtonRestartLevel = new ImageButton(buttonDrawableRestart, buttonDrawableRestart);
        imageButtonRestartLevel.setSize(175, 75);
        imageButtonRestartLevel.setPosition(250, 200);

        imageButtonMenu = new ImageButton(buttonDrawableMenu, buttonDrawableMenu);
        imageButtonMenu.setSize(175, 75);
        imageButtonMenu.setPosition(400, 200);

        imageButtonRestartLevel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        imageButtonMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelChooseScreen(game));
            }
        });

        stage = new Stage(viewport);
        stage.addActor(imageButtonRestartLevel);
        stage.addActor(imageButtonMenu);

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
        // Destroy screen's assets here
        backgroundTexture.dispose();
        restartLevelButtonTexture.dispose();
        menuButtonTexture.dispose();
    }
}
