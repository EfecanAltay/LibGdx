package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {

	Stage stage ;
	Table table ;
	
	TextureAtlas atlas = new TextureAtlas("UI/uIDesing.pack");
	
	Skin skin = new Skin(Gdx.files.internal("UI/uIDesing.json"),atlas);
	
	final TextButton btnStartGame = new TextButton("Start Game",skin);
	final TextButton btnQuitGame = new TextButton("Quit Game",skin);
	
	public MenuScreen() {
		// TODO Auto-generated method stub
		stage = new Stage(new ScreenViewport());
		
		table = new Table();
		
		table.align(Align.center);
		
		
		table.setPosition(0, 0);
		table.setBounds(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		table.padTop(5);
		table.add(btnStartGame);
		table.row();
		table.add(btnQuitGame);
		
		
		stage.addActor(table);
	
		
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
	public void startGame(ClickListener cl){
		btnStartGame.addListener(cl);
	}
	public void quitGame(ClickListener cl){
		btnQuitGame.addListener(cl);
	}
	public void setInputProcessor(){
		Gdx.input.setInputProcessor(stage);
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
