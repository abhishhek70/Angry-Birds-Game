package com.Pixel.AngryBirds.Screens;

import com.Pixel.AngryBirds.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

public class GameScreen1 implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Slingshot slingshot;
    private RedBird bird1;
    private YellowBird bird2;
    private BlackBird bird3;

    private Block horzWoodBlock1;
    private Block horzWoodBlock2;
    private Block horzWoodBlock3;
    private Block horzWoodBlock4;
    private Block horzWoodBlock5;
    private Block horzWoodBlock6;

    private Block horzWoodBlock7;
    private Block horzWoodBlock8;
    private Block horzWoodBlock9;
    private Block horzWoodBlock10;

    private Block vertWoodBlock1;
    private Block vertWoodBlock2;
    private Block vertWoodBlock3;
    private Block vertWoodBlock4;

    private Block horzIceBlock1;
    private Block horzIceBlock2;

    private InternPig pig1;
    private InternPig pig2;

    private Texture backgroundTexture;
    private Texture pauseButtonTexture;

    private ImageButton imageButtonPause;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public GameScreen1(AngryBirdsGame game){
        this.game = game;
        this.slingshot = new Slingshot(game, "slingshot.png", 105, 50, 90, 135);
        this.bird1 = new RedBird(game, "redbird.png", 90, 60, 40, 40);
        this.bird2 = new YellowBird(game, "yellowbird.png", 50, 65, 40, 40);
        this.bird3 = new BlackBird(game, "blackbird.png", 10, 60, 40, 40);

        this.horzWoodBlock1 = new Block(game, "woodBlockRectHorizontal.png", 550, 50, 50, 15);
        this.horzWoodBlock2 = new Block(game, "woodBlockRectHorizontal.png", 550, 65, 50, 15);
        this.horzWoodBlock3 = new Block(game, "woodBlockRectHorizontal.png", 550, 80, 50, 15);
        this.horzWoodBlock4 = new Block(game, "woodBlockRectHorizontal.png", 650, 50, 50, 15);
        this.horzWoodBlock5 = new Block(game, "woodBlockRectHorizontal.png", 650, 65, 50, 15);
        this.horzWoodBlock6 = new Block(game, "woodBlockRectHorizontal.png", 650, 80, 50, 15);

        this.horzWoodBlock7 = new Block(game, "woodBlockRectHorizontal.png", 525, 95, 50, 15);
        this.horzWoodBlock8 = new Block(game, "woodBlockRectHorizontal.png", 575, 95, 50, 15);
        this.horzWoodBlock9 = new Block(game, "woodBlockRectHorizontal.png", 625, 95, 50, 15);
        this.horzWoodBlock10 = new Block(game, "woodBlockRectHorizontal.png", 675, 95, 50, 15);

        this.pig1 = new InternPig(game, "pig.png", 550, 110, 40, 40);
        this.pig2 = new InternPig(game, "pig.png", 650, 110, 40, 40);

        this.vertWoodBlock1 = new Block(game, "woodBlockRectVertical.png", 530, 110, 10, 50);
        this.vertWoodBlock2 = new Block(game, "woodBlockRectVertical.png", 600, 110, 10, 50);
        this.vertWoodBlock3 = new Block(game, "woodBlockRectVertical.png", 630, 110, 10, 50);
        this.vertWoodBlock4 = new Block(game, "woodBlockRectVertical.png", 700, 110, 10, 50);

        this.horzIceBlock1 = new Block(game, "iceBlockRectHorizontal.png", 530, 160, 80, 10);
        this.horzIceBlock2 = new Block(game, "iceBlockRectHorizontal.png", 630, 160, 80, 10);

        backgroundTexture = new Texture("gameBackground.jpg");
        pauseButtonTexture = new Texture("pauseButton.png");

        this.camera = game.camera;
        this.viewport =  game.viewport;

        Drawable buttonDrawablePause = new TextureRegionDrawable(new TextureRegion(pauseButtonTexture));

        imageButtonPause = new ImageButton(buttonDrawablePause, buttonDrawablePause);
        imageButtonPause.setSize(100, 50);
        imageButtonPause.setPosition(0, WORLD_HEIGHT - 75);

        imageButtonPause.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PauseScreen(game));
            }
        });

        stage = new Stage(viewport);
        stage.addActor(imageButtonPause);

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
        slingshot.draw();
        bird1.draw();
        bird2.draw();
        bird3.draw();
        horzWoodBlock1.draw();
        horzWoodBlock2.draw();
        horzWoodBlock3.draw();
        horzWoodBlock4.draw();
        horzWoodBlock5.draw();
        horzWoodBlock6.draw();
        horzWoodBlock7.draw();
        horzWoodBlock8.draw();
        horzWoodBlock9.draw();
        horzWoodBlock10.draw();
        pig1.draw();
        pig2.draw();
        vertWoodBlock1.draw();
        vertWoodBlock2.draw();
        vertWoodBlock3.draw();
        vertWoodBlock4.draw();
        horzIceBlock1.draw();
        horzIceBlock2.draw();
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            game.setScreen(new WinScreen(game));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            game.setScreen(new LoseScreen(game));
        }

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
        pauseButtonTexture.dispose();
    }
}
