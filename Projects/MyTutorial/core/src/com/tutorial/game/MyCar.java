package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyCar extends Actor {

	TextureRegion region = new TextureRegion(new Texture("Cars.png"));
	
	
	Vector2 direction ;
	float directionDgree; 
	
	Sprite sprite ;
	float speed = 0;
	final float maxSpeed = 5  ;
	final float minSpeed = 3 ;
	
	
	
	public MyCar() {
		// TODO Auto-generated constructor stub
		direction = new Vector2();
		
		TextureRegion[][] cars  = region.split(43, 100);
		sprite = new Sprite(cars[0][0]);
		sprite.setScale(.5f);
		setBounds(getX(), getY(), getWidth(), getHeight());
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		sprite.setPosition(getX() - sprite.getWidth()/2, getY() - sprite.getHeight()/2 );
		sprite.setRotation(getRotation()-90);
		sprite.draw(batch);
		
		super.draw(batch, parentAlpha);
	}
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		
		this.setPosition((float)(getX() + Math.cos(getRotation()*Math.PI/180) * speed),(float)(getY() + Math.sin(getRotation()*Math.PI/180) * speed));
		
		if(speed >.5f )
			this.setRotation(getRotation() + directionDgree);
		else if(speed < -.5f)
			this.setRotation(getRotation() + directionDgree);
		
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			if(speed < maxSpeed)
			speed+= .1f;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			if(speed > -minSpeed)
			speed-= .1f;
		}
		else {
			if(speed > .1f)
			speed -= .1f;
			else if(speed < -.1f)
			speed += .1f;
			else 
			speed = 0 ;
		}
		
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				if(directionDgree <= 2f)
					directionDgree += .1f;
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				if(directionDgree >= -2f )
				directionDgree -= .1f  ;
			}
			else {
				if(directionDgree > 1f)
					directionDgree -= .2f;
					else if(directionDgree < -1f)
						directionDgree += .2f;
					else 
						directionDgree = 0 ;	
			}
	
	}
	public float getSpeed(){
		return speed;
	}
	public float getDirectionDgree(){
		return (float)((directionDgree*Math.PI)/180);
	}
	
}
