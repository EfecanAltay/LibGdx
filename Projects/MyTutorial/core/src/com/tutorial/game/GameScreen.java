package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen {
	
	Stage stage ;
	World world ;
	OrthographicCamera cam;
	
	Car car;
	
	Character c ;
	
	Table table ;
	
	boolean pauseKey = false  ; 

	
	TextureAtlas atlas = new TextureAtlas("UI/uIDesing.pack");
	
	Skin skin = new Skin(Gdx.files.internal("UI/uIDesing.json"),atlas);
	
	public  GameScreen () {
	
		
	//ScreenViewport viewport = new ScreenViewport(cam);
	//viewport.setWorldSize(GAME_WORLD_WIDHT, GAME_WORLD_HEIGHT);
	
	
	world = new World();
	table = new Table();
	
	table.setBounds(-Gdx.graphics.getWidth()/4, -Gdx.graphics.getHeight()/4, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
	System.out.println(table.getX()  + " : " + table.getY());
	table.align(Align.center);
	
	car = new Car(){
		@Override
		protected void positionChanged() {
			// TODO Auto-generated method stub
			super.positionChanged();
		if(selected)
			c.setPosition(car.getX(), car.getY());
		}
		
		@Override
		public void exitCar() {
			// TODO Auto-generated method stub
			super.exitCar();
			c.cam = car.cam;
			c.selected  = true ;
			c.setPosition(this.getX(), this.getY());
			table.setPosition(c.getX()-Gdx.graphics.getWidth()/4, c.getY()-Gdx.graphics.getHeight()/4);
		}
	};
	
	c = new Character(){
		@Override
		public void enterCar() {
			// TODO Auto-generated method stub
			super.enterCar();
			
			table.setPosition(c.getX()-Gdx.graphics.getWidth()/4, c.getY()-Gdx.graphics.getHeight()/4);
			car.cam = c.cam ;
			car.selected  = true ;
			
		}
		
	};
	
	cam = c.cam;


	
	stage = new Stage(new ScreenViewport(cam));
	
	stage.setKeyboardFocus(c);
	stage.addActor(world);
	stage.addActor(car);
	stage.addActor(car.dG);
	stage.addActor(c);
	stage.addActor(table);
	
	
	
}

	@Override
	public void render (float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		table.setPosition(c.getX()-Gdx.graphics.getWidth()/4, c.getY()-Gdx.graphics.getHeight()/4);
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			if(!pauseKey){
			pauseGame(table, skin);
			}
			else{
				table.removeActor(table.findActor("MENU"));
				pauseKey = false;
			}
			
			
		}
		
		
		//dG.setPosition(stage.getCamera().position.x,stage.getCamera().position.y);
		
		stage.act();
		stage.draw();
		table.debug();
		
		
		c.debug();
		car.debug();

	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
	
	}



	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	public void setInputProcessor(){
		Gdx.input.setInputProcessor(stage);
	}
	public void pauseGame(Table table , Skin skin){
		GameMenu gm = new GameMenu(table,skin);
		stage.setKeyboardFocus(gm.window);
		
		pauseKey = true ;
	}
	public void exitGame(){
	
	}
	
	
	public class GameMenu{
		Window window ;
		TextButton tbResume,tbExit;
		
		public GameMenu(final Table table,Skin skin) {
			// TODO Auto-generated constructor stub
		window = new Window("Menu", skin);
		
		
		//window.padTop(35);
		
		//window.padRight(10);
		window.setName("MENU");
		window.setMovable(false);
		
		//window.setPosition(window.getX() - window.getWidth()/2 , window.getY() - window.getHeight()/2);
		//window.setPosition(table.getOriginX(), table.getOriginY());
		window.setPosition(table.getOriginX() + table.getWidth()/2  - window.getWidth()/2, table.getOriginY() + table.getHeight()/2 - window.getHeight()/2);
		//window.padLeft(20);
		
		
		
		tbResume = new TextButton("Resume", skin);
		tbExit = new TextButton("Menu", skin) ;		
		
		tbResume.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				table.removeActor(table.findActor("MENU"));
				pauseKey = false ;
			}
		});
		
		tbExit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				exitGame();
			}
		});
		
		window.padTop(20);
		window.debug();
		window.add(tbResume);
		window.row();
		window.add(tbExit);
		
		window.align(Align.center);
		
		table.addActor(window);
		}
		
		
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	
}
