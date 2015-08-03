package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DirectionGUI extends Actor {

	Sprite sprite = new  Sprite(new Texture("Direksiyon.png"));
	public DirectionGUI() {
		// TODO Auto-generated constructor stub
		sprite.setScale(.5f);
		setBounds(getX(), getY(), sprite.getWidth(), sprite.getHeight());
		setSize(sprite.getWidth(), sprite.getHeight());
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		
		sprite.setPosition(
				getX(),
				getY());
		sprite.setRotation(getRotation());
		
		sprite.setScale(getScaleX(), getScaleY());
		sprite.setSize(getWidth(), getHeight());
		
		sprite.draw(batch);
		
	}
	
}
