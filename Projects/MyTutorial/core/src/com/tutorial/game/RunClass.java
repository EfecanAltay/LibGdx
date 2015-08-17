package com.tutorial.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class RunClass extends Game  {

	final int GAME_WORLD_WIDHT = 200 ;
	final int GAME_WORLD_HEIGHT = 200 ;
	
	MenuScreen mS ;
	GameScreen gS ;
	
	@Override
	public void create() {
		mS = new MenuScreen();
		gS = new GameScreen(){
			@Override
			public void exitGame() {
				// TODO Auto-generated method stub
				super.exitGame();
				setScreen(mS);
				mS.setInputProcessor();
			}
		};
		setScreen(mS);
		mS.setInputProcessor();
//---------------------
		mS.startGame(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				setScreen(gS);
				gS.setInputProcessor();
			}
		});
		mS.quitGame(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				Gdx.app.exit();
			}
		});
	}
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
}
