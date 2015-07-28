package com.tutorial.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class World extends Actor{
	
	Sprite world ;
	
	public World() {
	
		world = new Sprite(new Texture("map.png"));
	
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		super.draw(batch, parentAlpha);
		world.setPosition(getX(), getY());
		world.draw(batch);
		
	}
}
