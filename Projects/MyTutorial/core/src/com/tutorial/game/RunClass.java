package com.tutorial.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class RunClass extends ApplicationAdapter{

	final int GAME_WORLD_WIDHT = 200 ;
	final int GAME_WORLD_HEIGHT = 200 ;
	
	GameScreen gS ;
	MenuScreen mS ;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		mS = new MenuScreen();
		mS.show();
		
	}
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		//gS.render(0);
		mS.render(1);
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		mS.dispose();
		//gS.dispose();
		
	}
}
