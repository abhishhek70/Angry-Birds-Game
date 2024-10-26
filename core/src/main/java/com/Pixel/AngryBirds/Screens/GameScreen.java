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

public class GameScreen implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Slingshot slingshot;
    private RedBird bird1;
    private YellowBird bird2;
    private BlackBird bird3;

    private Texture backgroundTexture;
    private Texture pauseButtonTexture;

    private ImageButton imageButtonPause;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public GameScreen(AngryBirdsGame game){
        this.game = game;

        this.slingshot = new Slingshot(game, "slingshot.png", 125, 50, 50, 125);
        this.bird1 = new RedBird(game, "redbird.png", 90, 60, 40, 40);
        this.bird2 = new YellowBird(game, "yellowbird.png", 50, 65, 40, 40);
        this.bird3 = new BlackBird(game, "blackbird.png", 10, 60, 40, 40);

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
