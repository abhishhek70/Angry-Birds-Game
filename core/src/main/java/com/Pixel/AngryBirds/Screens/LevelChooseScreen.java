package com.Pixel.AngryBirds.Screens;

import com.Pixel.AngryBirds.AngryBirdsGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.utils.viewport.Viewport;

public class LevelChooseScreen implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Texture backgroundTexture;
    private Texture backButtonTexture;
    private Texture levelOne;
    private Texture levelTwo;
    private Texture levelThree;
    private Texture lockedLevel;

    private ImageButton imageButtonBack;
    private ImageButton imageButtonLevelOne;
    private ImageButton imageButtonLevelTwo;
    private ImageButton imageButtonLevelThree;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public LevelChooseScreen(AngryBirdsGame game){
        this.game = game;

        backgroundTexture = new Texture("levelChooseScreenBackground.png");
        backButtonTexture = new Texture("backButton.png");
        levelOne = new Texture("levelOne.png");
        levelTwo = new Texture("levelTwo.png");
        levelThree = new Texture("levelThree.png");
        lockedLevel = new Texture("lockedLevel.png");

        Drawable buttonDrawableBack = new TextureRegionDrawable(new TextureRegion(backButtonTexture));
        Drawable buttonDrawableLevelOne = new TextureRegionDrawable(new TextureRegion(levelOne));
        Drawable buttonDrawableLevelTwo = new TextureRegionDrawable(new TextureRegion(levelTwo));
        Drawable buttonDrawableLevelThree = new TextureRegionDrawable(new TextureRegion(levelThree));

        this.camera = game.camera;
        this.viewport = game.viewport;

        imageButtonBack = new ImageButton(buttonDrawableBack, buttonDrawableBack);
        imageButtonBack.setSize(100, 50); // To do
        imageButtonBack.setPosition(0, WORLD_HEIGHT - 75); // To do

        imageButtonLevelOne = new ImageButton(buttonDrawableLevelOne, buttonDrawableLevelOne);
        imageButtonLevelOne.setSize(200, 100);
        imageButtonLevelOne.setPosition(WORLD_WIDTH/2 - 300, WORLD_HEIGHT/2 + 100);

        imageButtonLevelTwo = new ImageButton(buttonDrawableLevelTwo, buttonDrawableLevelTwo);
        imageButtonLevelTwo.setSize(200, 100);
        imageButtonLevelTwo.setPosition(WORLD_WIDTH/2 - 100, WORLD_HEIGHT/2 + 100);

        imageButtonLevelThree = new ImageButton(buttonDrawableLevelThree, buttonDrawableLevelThree);
        imageButtonLevelThree.setSize(200, 100);
        imageButtonLevelThree.setPosition(WORLD_WIDTH/2 + 100, WORLD_HEIGHT/2 + 100);

        imageButtonBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new HomeScreen(game));  // Change it later
            }
        });

        imageButtonLevelOne.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));  // Change it later
            }
        });

        imageButtonLevelTwo.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));  // Change it later
            }
        });

        imageButtonLevelThree.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));  // Change it later
            }
        });

        stage = new Stage(viewport);
        stage.addActor(imageButtonBack);
        stage.addActor(imageButtonLevelOne);
        stage.addActor(imageButtonLevelTwo);
        stage.addActor(imageButtonLevelThree);

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
        game.batch.draw(lockedLevel, WORLD_WIDTH/2 - 237, WORLD_HEIGHT/2 - 50, 110, 100);
        game.batch.draw(lockedLevel, WORLD_WIDTH/2 - 237 + 200, WORLD_HEIGHT/2 - 50, 110, 100);
        game.batch.draw(lockedLevel, WORLD_WIDTH/2 - 237 + 400, WORLD_HEIGHT/2 - 50, 110, 100);
        game.batch.draw(lockedLevel, WORLD_WIDTH/2 - 237, WORLD_HEIGHT/2 - 200, 110, 100);
        game.batch.draw(lockedLevel, WORLD_WIDTH/2 - 237 + 200, WORLD_HEIGHT/2 - 200, 110, 100);
        game.batch.draw(lockedLevel, WORLD_WIDTH/2 - 237 + 400, WORLD_HEIGHT/2 - 200, 110, 100);
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
        backButtonTexture.dispose();
        levelOne.dispose();
        levelTwo.dispose();
        levelThree.dispose();
    }
}
