package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen {
	
	Stage stage ;
	World world ;
	MyCar actor;
	OrthographicCamera cam;
	
	
	DirectionGUI dG ;
	
	@Override
	public void show () {
		
		dG = new DirectionGUI();
		
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()){
			
		};
		
		cam.zoom = .5f ;
		cam.lookAt(0, 0, 0);
		
		
		cam.update();
		
	
	//ScreenViewport viewport = new ScreenViewport(cam);
	//viewport.setWorldSize(GAME_WORLD_WIDHT, GAME_WORLD_HEIGHT);
	
	stage = new Stage(new ScreenViewport(cam));
	
	world = new World();
	
	
	actor = new MyCar(){
		@Override
		protected void positionChanged() {
			// TODO Auto-generated method stub
			super.positionChanged();
			dG.setScale(.5f * cam.zoom);
			System.out.println(dG.getScaleX());
			dG.setPosition(actor.getOriginX(), actor.getOriginY());
		}
	};
	
	stage.addActor(world);
	
	stage.addActor(actor);
	
	//stage.setKeyboardFocus(actor);
	
	
	stage.addActor(dG);
	
	

	}


	@Override
	public void render (float delta) {
		
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		zoomControl(actor.getSpeed(), cam);
		
		dG.setRotation(actor.directionDgree * 180/ 3.14f * 2);
		
		stage.getCamera().position.set(actor.getX(), actor.getY(), 0);
		
		//dG.setPosition(stage.getCamera().position.x,stage.getCamera().position.y);
		
		stage.act();
		stage.draw();
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
	
	}
	public static void zoomControl(float speed,OrthographicCamera cam){
		
		if(cam.zoom >= .5f && cam.zoom <= 1f && speed/50 < .5f && speed > 0)
			cam.zoom = speed/50+.5f ;
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

	
}
