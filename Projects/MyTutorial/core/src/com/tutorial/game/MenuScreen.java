package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen{

	Stage stage ;
	Table table ;
	TextButton btn ;
	
	ScrollPane sp ;
	
	List list ;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(new ScreenViewport());		
		
		
		
		TextureAtlas atlas = new TextureAtlas("UI/Atlas.pack");
		Skin skin = new Skin(Gdx.files.internal("UI/uiskin.json"),atlas);
		
		
		
		
		list= new List(skin);
		
		list.setItems(new String[] {"one", "two", "three", "four"});
		
		Window window = new Window("hello", skin){
			
		};
		
		window.setMovable(true);
		window.setSize(100, 100);
		
		
		sp = new ScrollPane(list,skin);
		
		sp.setWidth(100);
		
		//btn = new TextButton("hello",skin);
		
		
		//sp.addActor(btn);
		
		
		table = new Table();
		
		table.align(Align.center);
		
		table.setPosition(0, 0);
		table.setBounds(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		table.add(sp);
		
		stage.addActor(table);
		
		stage.addActor(window);
		
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
		
	}

	
	
}
