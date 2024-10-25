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

public class LoadGameScreen implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Texture backgroundTexture;
    private Texture backButtonTexture;
    private Texture filledSlotOneTexture;
    private Texture filledSlotTwoTexture;
    private Texture emptySlotTexture;

    private ImageButton imageButtonBack;
    private ImageButton imageButtonFilledSlotOne;
    private ImageButton imageButtonFilledSLotTwo;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public LoadGameScreen(AngryBirdsGame game){
        this.game = game;

        backgroundTexture = new Texture("levelChooseScreenBackground.png");
        backButtonTexture = new Texture("backButton.png");
        filledSlotOneTexture = new Texture("filledSlotOne.png");
        filledSlotTwoTexture = new Texture("filledSlotTwo.png");
        emptySlotTexture = new Texture("emptySlot.png");

        this.camera = game.camera;
        this.viewport =  game.viewport;

        Drawable buttonDrawableBack = new TextureRegionDrawable(new TextureRegion(backButtonTexture));
        Drawable buttonDrawableFilledSlotOne = new TextureRegionDrawable(new TextureRegion(filledSlotOneTexture));
        Drawable buttonDrawableFilledSlotTwo = new TextureRegionDrawable(new TextureRegion(filledSlotTwoTexture));

        imageButtonBack = new ImageButton(buttonDrawableBack, buttonDrawableBack);
        imageButtonBack.setSize(100, 50); // To do
        imageButtonBack.setPosition(0, WORLD_HEIGHT - 75); // To do

        imageButtonFilledSlotOne = new ImageButton(buttonDrawableFilledSlotOne, buttonDrawableFilledSlotOne);
        imageButtonFilledSlotOne.setSize(500, 250); // To do
        imageButtonFilledSlotOne.setPosition(170, 350); // To do

        imageButtonFilledSLotTwo = new ImageButton(buttonDrawableFilledSlotTwo, buttonDrawableFilledSlotTwo);
        imageButtonFilledSLotTwo.setSize(500, 250); // To do
        imageButtonFilledSLotTwo.setPosition(170, 225); // To do

        imageButtonBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new HomeScreen(game));  // Change it later
            }
        });

        imageButtonFilledSlotOne.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));  // Change it later
            }
        });

        imageButtonFilledSLotTwo.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));  // Change it later
            }
        });

        stage = new Stage(viewport);
        stage.addActor(imageButtonBack);
        stage.addActor(imageButtonFilledSlotOne);
        stage.addActor(imageButtonFilledSLotTwo);

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
        game.batch.draw(emptySlotTexture, 218, 185, 425, 80);
        game.batch.draw(emptySlotTexture, 218, 70, 425, 80);
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
    }
}
