package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen{

	Stage stage ;
	Table table ;
	TextButton btn ;
	
	ScrollPane sp ;
	
	List list ;
	
	TextureAtlas atlas = new TextureAtlas("UI/Atlas.pack");
	
	Skin skin = new Skin(Gdx.files.internal("UI/uiskin.json"),atlas);
	
	final Dialog dialog = new Dialog("Hello player", skin);
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(new ScreenViewport());		
		
		

		
		
		
		
		
		//list= new List(skin);
		
		//list.setItems(new String[] {"one", "two", "three", "four"});
		
		
		final TextButton btn = new TextButton("hello",skin);
		
		
		//sp.addActor(btn);
		
		
		
		
		
		
		table = new Table();
		
		table.align(Align.center | Align.bottom );
		
		table.setPosition(0, 0);
		table.setBounds(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		table.add(btn);
		
		btn.addListener( new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				
				dialog.show(stage);
				
				Timer.schedule(new Timer.Task() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("dialog Showing");
						dialog.remove();
						dialog.hide();
					
					}
				}, 3f);
				
			}
		});
		
		
		stage.addActor(table);
			
		Gdx.input.setInputProcessor(stage);
		
		
		
		
	}
	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		stage.draw();
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		dialog.remove();
	}
	
	
	
}
