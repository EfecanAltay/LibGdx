package game.WriseGame.Lib;

import WriseGame.StandartLib.Button;
import WriseGame.StandartLib.Clickable;
import WriseGame.StandartLib.Image;
import WriseGame.StandartLib.Label;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class RunClass extends ApplicationAdapter {
	SpriteBatch batch;
	Image image ;
	Button btnPlay ;
	Button btnQuit ;
	Label text ;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		btnPlay = new Button();
		btnPlay.setHeightIWight(150, 50);
		btnPlay.setPosition(Gdx.graphics.getWidth()/2 - btnPlay.getWight()/2,Gdx.graphics.getHeight()/2- btnPlay.getHeight()/2);
		text = new Label("play");
		text.setPosition(btnPlay.getPosition().x + btnPlay.getWight()/2 - 10 ,btnPlay.getPosition().y + btnPlay.getHeight()/2 +8);
		
		btnQuit = new Button();
		btnQuit.setHeightIWight(150, 50);
		btnQuit.setPosition(btnPlay.getPosition().x,btnPlay.getPosition().y - btnPlay.getHeight() - 10);
		
		
		image = new Image("badlogic.jpg");
		
		btnPlay.setOnClick(new Clickable(btnPlay) {
			
			@Override
			public void OnClick() {
				// TODO Auto-generated method stub
				image.Transform(1, 1);
				
			}
		});
	
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		image.Show(batch);
		btnPlay.Show(batch);
		btnQuit.Show(batch);
		text.Show(batch);
		
		
		batch.end();
	}
}
