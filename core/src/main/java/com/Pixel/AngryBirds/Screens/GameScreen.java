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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private AngryBirdsGame game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Slingshot slingshot;
    private RedBird bird1;
    private YellowBird bird2;
    private BlackBird bird3;

    private List<Bird> availableBirds;

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
    private ImageButton saveButton;
    private ImageButton loadButton;

    private Stage stage;

    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public GameScreen(AngryBirdsGame game){
        this.game = game;

        this.slingshot = new Slingshot(game, "slingshot.png", 105, 50, 90, 135);
        this.bird1 = new RedBird(game, "redbird.png", 90, 60, 40, 40, slingshot);
        this.bird2 = new YellowBird(game, "yellowbird.png", 50, 65, 40, 40, slingshot);
        this.bird3 = new BlackBird(game, "blackbird.png", 10, 60, 40, 40, slingshot);

        availableBirds = new ArrayList<>();
        availableBirds.add(bird1);
        availableBirds.add(bird2);
        availableBirds.add(bird3);

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
        saveButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("saveButton.png"))));
        saveButton.setSize(100, 50);
        saveButton.setPosition(100, WORLD_HEIGHT - 75);
        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                saveGame("savegame.dat");
            }
        });

        stage.addActor(saveButton);
        loadButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("loadButton.png"))));
        loadButton.setSize(100, 50);
        loadButton.setPosition(200, WORLD_HEIGHT - 75);
        loadButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                loadGame("savegame.dat");
            }
        });

        stage.addActor(loadButton);


        stage.addActor(bird1);
        stage.addActor(bird2);
        stage.addActor(bird3);

        // Add click listeners for birds
//        addBirdClickListener(bird1);
//        addBirdClickListener(bird2);
//        addBirdClickListener(bird3);

//        bird1.setTouchable(Touchable.enabled);
//        bird2.setTouchable(Touchable.enabled);
//        bird3.setTouchable(Touchable.enabled);

        Gdx.input.setInputProcessor(stage);
    }

    private void addBirdClickListener(Bird bird) {
        bird.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                if (true) {
//                    bird.putOnSlingshot();
//                }
//            }
        });
    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        input();
        logic();
        drawScreen(delta);
    }

    private void input() {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            game.setScreen(new WinScreen(game));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            game.setScreen(new LoseScreen(game));
        }

        if (Gdx.input.justTouched()) {
            Vector2 touchPos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            Vector3 touchPos3 = new Vector3(touchPos.x, touchPos.y, 0);
            camera.unproject(touchPos3);
            touchPos.set(touchPos3.x, touchPos3.y);

            if (bird1.getBoundingBox().contains(touchPos)) {
                slingshot.placeBirdOnSlingshot(bird1);
            } else if (bird2.getBoundingBox().contains(touchPos)) {
                slingshot.placeBirdOnSlingshot(bird2);
            } else if (bird3.getBoundingBox().contains(touchPos)) {
                slingshot.placeBirdOnSlingshot(bird3);
            }
        }

        if (slingshot.hasBird()) {
            if (Gdx.input.isTouched()) {
                Vector2 dragPos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
                Vector3 dragPos3 = new Vector3(dragPos.x, dragPos.y, 0);
                camera.unproject(dragPos3);
                dragPos.set(dragPos3.x, dragPos3.y);
                slingshot.aim(dragPos);
            }
        }

    }
    public void saveGame(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(slingshot);
            oos.writeObject(availableBirds);
            oos.writeObject(pig1);
            oos.writeObject(pig2);
            oos.writeObject(horzWoodBlock1);
            oos.writeObject(horzWoodBlock2);
            oos.writeObject(horzWoodBlock3);
            oos.writeObject(horzWoodBlock4);
            oos.writeObject(horzWoodBlock5);
            oos.writeObject(horzWoodBlock6);
            oos.writeObject(horzWoodBlock7);
            oos.writeObject(horzWoodBlock8);
            oos.writeObject(horzWoodBlock9);
            oos.writeObject(horzWoodBlock10);
            oos.writeObject(vertWoodBlock1);
            oos.writeObject(vertWoodBlock2);
            oos.writeObject(vertWoodBlock3);
            oos.writeObject(vertWoodBlock4);
            oos.writeObject(horzIceBlock1);
            oos.writeObject(horzIceBlock2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            slingshot = (Slingshot) ois.readObject();
            availableBirds = (List<Bird>) ois.readObject();
            pig1 = (InternPig) ois.readObject();
            pig2 = (InternPig) ois.readObject();
            horzWoodBlock1 = (Block) ois.readObject();
            horzWoodBlock2 = (Block) ois.readObject();
            horzWoodBlock3 = (Block) ois.readObject();
            horzWoodBlock4 = (Block) ois.readObject();
            horzWoodBlock5 = (Block) ois.readObject();
            horzWoodBlock6 = (Block) ois.readObject();
            horzWoodBlock7 = (Block) ois.readObject();
            horzWoodBlock8 = (Block) ois.readObject();
            horzWoodBlock9 = (Block) ois.readObject();
            horzWoodBlock10 = (Block) ois.readObject();
            vertWoodBlock1 = (Block) ois.readObject();
            vertWoodBlock2 = (Block) ois.readObject();
            vertWoodBlock3 = (Block) ois.readObject();
            vertWoodBlock4 = (Block) ois.readObject();
            horzIceBlock1 = (Block) ois.readObject();
            horzIceBlock2 = (Block) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void logic() {

//        bird1.putOnSlingshot();

    }

    private void drawScreen(float delta) {

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

        slingshot.drawProjectilePath();

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
