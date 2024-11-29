// core/src/main/java/com/Pixel/AngryBirds/Screens/GameScreen.java
package com.Pixel.AngryBirds.Screens;
import com.badlogic.gdx.audio.Sound;
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
import com.badlogic.gdx.physics.box2d.*;
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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef;

import static com.Pixel.AngryBirds.Bird.GROUND_LEVEL;

public class GameScreen2 implements Screen, Serializable {

    public static final float GROUND_LEVEL = 50;
    private transient AngryBirdsGame game;
    private transient World world;
    private transient Box2DDebugRenderer debugRenderer;
    private transient OrthographicCamera camera;
    private transient Viewport viewport;
    private Queue<Body> bodiesToDestroy;


    private Slingshot slingshot;
    private RedBird bird1;
    private YellowBird bird2;
    private BlackBird bird3;
    //    private List<Block> blocks;/
    private List<Bird> availableBirds;
    private static final String SAVE_DIR = "saves/";

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

    private transient Texture backgroundTexture;
    private transient Texture pauseButtonTexture;

    private transient ImageButton imageButtonPause;
    private transient ImageButton saveButton;
    private transient ImageButton loadButton;

    private transient Stage stage;
    private transient Sound launchSound;


    private static final float WORLD_WIDTH = 800;
    private static final float WORLD_HEIGHT = 600;

    public GameScreen2(AngryBirdsGame game){
        this.game = game;
//        game.stopBackgroundMusic();
        world = new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();
        bodiesToDestroy = new LinkedList<>();

//        blocks = new ArrayList<>();
//        pigs = new ArrayList<>();



        this.slingshot = new Slingshot(game, "slingshot.png", 105, 50, 90, 135);
        this.bird1 = new RedBird(game, "redbird.png", 325, 50, 40, 40, slingshot);
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


        Gdx.input.setInputProcessor(stage);
        launchSound = Gdx.audio.newSound(Gdx.files.internal("launch.mp3"));
        createBox2DBodies();
        createGroundBody();

        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                handleCollision(contact);
            }

            @Override
            public void endContact(Contact contact) {
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }
        });


    }
    private void createBox2DBodies() {
        createBirdBody(bird1);
        createBirdBody(bird2);
        createBirdBody(bird3);

        createBlockBody(horzWoodBlock1, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock2, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock3, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock4, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock5, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock6, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock7, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock8, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock9, BodyDef.BodyType.StaticBody);
        createBlockBody(horzWoodBlock10, BodyDef.BodyType.StaticBody);
        createBlockBody(vertWoodBlock1, BodyDef.BodyType.StaticBody);
        createBlockBody(vertWoodBlock2, BodyDef.BodyType.StaticBody);
        createBlockBody(vertWoodBlock3, BodyDef.BodyType.StaticBody);
        createBlockBody(vertWoodBlock4, BodyDef.BodyType.StaticBody);
        createBlockBody(horzIceBlock1, BodyDef.BodyType.StaticBody);
        createBlockBody(horzIceBlock2, BodyDef.BodyType.StaticBody);

        createPigBody(pig1, BodyDef.BodyType.StaticBody);
        createPigBody(pig2, BodyDef.BodyType.StaticBody);
    }
    private void createGroundBody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, GROUND_LEVEL);

        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(800, 1);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.3f;

        body.createFixture(fixtureDef);
        shape.dispose();
    }

    private void createBirdBody(Bird bird) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(bird.getX(), bird.getY());

        Body body = world.createBody(bodyDef);

        CircleShape shape = new CircleShape();
        shape.setRadius(bird.getWidth() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.3f;

        body.createFixture(fixtureDef);
        shape.dispose();

        bird.setBody(body);
    }

    private void createBlockBody(Block block,BodyDef.BodyType bodyType) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(block.getX(), block.getY());

        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(block.getWidth() / 2, block.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.3f;

        body.createFixture(fixtureDef);
        shape.dispose();

        block.setBody(body);
    }

    private void createPigBody(InternPig pig,BodyDef.BodyType bodyType) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(pig.getX(), pig.getY());

        Body body = world.createBody(bodyDef);

        CircleShape shape = new CircleShape();
        shape.setRadius(pig.getWidth() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.3f;

        body.createFixture(fixtureDef);
        shape.dispose();

        pig.setBody(body);
    }


    private void handleCollision(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        Object userDataA = fixtureA.getBody().getUserData();
        Object userDataB = fixtureB.getBody().getUserData();

        if (userDataA instanceof Bird && userDataB instanceof Block) {
            handleBirdBlockCollision((Block) userDataB);
        } else if (userDataA instanceof Block && userDataB instanceof Bird) {
            handleBirdBlockCollision((Block) userDataA);
        }
    }

    private void handleBirdBlockCollision(Block block) {
        block.takeDamage(1);
        if (block.isDestroyed()) {
            bodiesToDestroy.add(block.getBody()); // Queue the body for destruction
            handleBlockCollapse(block);
        } else {
            block.getBody().setType(BodyDef.BodyType.DynamicBody);
        }
    }

    private void handleBlockCollapse(Block destroyedBlock) {
        for (Block block : getBlocksAbove(destroyedBlock)) {
            block.takeDamage(1);
            if (block.isDestroyed()) {
                bodiesToDestroy.add(block.getBody()); // Queue for destruction
            } else {
                block.getBody().setType(BodyDef.BodyType.DynamicBody);
            }
        }
    }



    private List<Block> getBlocksAbove(Block destroyedBlock) {
        List<Block> blocksAbove = new ArrayList<>();
        for (Block block : getAllBlocks()) {
            if (block.getY() > destroyedBlock.getY() && block.getX() == destroyedBlock.getX()) {
                blocksAbove.add(block);
            }
        }
        return blocksAbove;
    }

    private List<Block> getAllBlocks() {
        List<Block> allBlocks = new ArrayList<>();
        allBlocks.add(horzWoodBlock1);
        allBlocks.add(horzWoodBlock2);
        allBlocks.add(horzWoodBlock3);
        allBlocks.add(horzWoodBlock4);
        allBlocks.add(horzWoodBlock5);
        allBlocks.add(horzWoodBlock6);
        allBlocks.add(horzWoodBlock7);
        allBlocks.add(horzWoodBlock8);
        allBlocks.add(horzWoodBlock9);
        allBlocks.add(horzWoodBlock10);
        allBlocks.add(vertWoodBlock1);
        allBlocks.add(vertWoodBlock2);
        allBlocks.add(vertWoodBlock3);
        allBlocks.add(vertWoodBlock4);
        allBlocks.add(horzIceBlock1);
        allBlocks.add(horzIceBlock2);
        return allBlocks;
    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        input();
        logic();

        // Step the physics simulation
        world.step(1 / 60f, 6, 2);

        // Destroy queued bodies after the physics step
        while (!bodiesToDestroy.isEmpty()) {
            Body body = bodiesToDestroy.poll();
            if (body != null && !world.isLocked()) {
                world.destroyBody(body);
            }
        }

        // Delegate rendering to drawScreen
        drawScreen(delta);

        // Render debug visuals for Box2D bodies
        debugRenderer.render(world, camera.combined);
    }



    private void input() {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            game.setScreen(new WinScreen(game));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            game.setScreen(new LoseScreen(game));
        }
    }

    public void saveGame(String filePath) {
        File dir = new File(SAVE_DIR);
        if (!dir.exists()) {
            dir.mkdirs(); // Create the directory if it doesn't exist
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Save file not found: " + filePath);
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            GameScreen loadedGame = (GameScreen) ois.readObject();
            this.copyFrom(loadedGame,game);
            System.out.println("Game loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void copyFrom(GameScreen loadedGame, AngryBirdsGame game) {
//        this.game = game;
//        this.camera = game.camera;
//        this.viewport = game.viewport;
//        this.slingshot = loadedGame.slingshot;
//        this.bird1 = loadedGame.bird1;
//        this.bird2 = loadedGame.bird2;
//        this.bird3 = loadedGame.bird3;
//        this.availableBirds = loadedGame.availableBirds;
//        this.horzWoodBlock1 = loadedGame.horzWoodBlock1;
//        this.horzWoodBlock2 = loadedGame.horzWoodBlock2;
//        this.horzWoodBlock3 = loadedGame.horzWoodBlock3;
//        this.horzWoodBlock4 = loadedGame.horzWoodBlock4;
//        this.horzWoodBlock5 = loadedGame.horzWoodBlock5;
//        this.horzWoodBlock6 = loadedGame.horzWoodBlock6;
//        this.horzWoodBlock7 = loadedGame.horzWoodBlock7;
//        this.horzWoodBlock8 = loadedGame.horzWoodBlock8;
//        this.horzWoodBlock9 = loadedGame.horzWoodBlock9;
//        this.horzWoodBlock10 = loadedGame.horzWoodBlock10;
//        this.vertWoodBlock1 = loadedGame.vertWoodBlock1;
//        this.vertWoodBlock2 = loadedGame.vertWoodBlock2;
//        this.vertWoodBlock3 = loadedGame.vertWoodBlock3;
//        this.vertWoodBlock4 = loadedGame.vertWoodBlock4;
//        this.horzIceBlock1 = loadedGame.horzIceBlock1;
//        this.horzIceBlock2 = loadedGame.horzIceBlock2;
//        this.pig1 = loadedGame.pig1;
//        this.pig2 = loadedGame.pig2;
//        this.backgroundTexture = loadedGame.backgroundTexture;
//        this.pauseButtonTexture = loadedGame.pauseButtonTexture;
//        this.imageButtonPause = loadedGame.imageButtonPause;
//        this.saveButton = loadedGame.saveButton;
//        this.loadButton = loadedGame.loadButton;
//        this.stage = loadedGame.stage;
//        this.launchSound = loadedGame.launchSound;
    }

    private void logic() {
        List<Bird> birdsToRemove = new ArrayList<>();
        for (Bird bird : availableBirds) {
            bird.update();
            float birdX = bird.getX();
            float birdY = bird.getY();
            if (birdX < -bird.getWidth() || birdX > WORLD_WIDTH || birdY < -bird.getHeight() || birdY > WORLD_HEIGHT) {
                birdsToRemove.add(bird);
            }
        }

        for (Block block : getAllBlocks()) {
            block.update();
        }

        // Queue birds for removal, but don't modify lists immediately
        for (Bird bird : birdsToRemove) {
            bodiesToDestroy.add(bird.getBody());
        }
    }


    public void removeBird(Bird bird) {
        availableBirds.remove(bird);
        stage.getActors().removeValue(bird, true);
    }

    private void drawScreen(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        slingshot.draw();
        for (Bird bird : availableBirds) {
            bird.draw();
        }
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

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        slingshot.drawProjectilePath(shapeRenderer);
        shapeRenderer.dispose();


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
        launchSound.dispose();

    }
}
