package com.tutorial.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class RunClass extends ApplicationAdapter{

	final int GAME_WORLD_WIDHT = 200 ;
	final int GAME_WORLD_HEIGHT = 200 ;
	
	
	
	
	
	Stage stage ;
	World world ;
	MyCar actor;
	OrthographicCamera cam;
	
	private Skin skin ;
	
	
	DirectionGUI dG ;
	
	@Override
	public void create () {
		
		dG = new DirectionGUI();
		
		skin = new Skin(Gdx.files.internal("Gfont/uiskin.json"));
		
		final TextButton btn = new TextButton("hello", skin, "default"); 
		
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()){
			
		};
		
		cam.zoom = .5f ;
		cam.lookAt(0, 0, 0);
		
		
		
		cam.update();
		
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
	
	ScreenViewport viewport = new ScreenViewport(cam);
	
	
	viewport.setWorldSize(GAME_WORLD_WIDHT, GAME_WORLD_HEIGHT);
	stage = new Stage(viewport);
	
	world = new World();
	
	stage.addActor(world);
	stage.addActor(actor);
	
	//stage.setKeyboardFocus(actor);
	
	
	stage.addActor(dG);
	
	stage.addActor(btn);
	
	}

	@Override
	public void render () {
		
		
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
		super.dispose();
		stage.dispose();
	
	}
	public static void zoomControl(float speed,OrthographicCamera cam){
		
		if(cam.zoom >= .5f && cam.zoom <= 1f && speed/50 < .5f && speed > 0)
			cam.zoom = speed/50+.5f ;
	}
	
}
