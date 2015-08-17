package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;

public class Car extends Actor {

	TextureRegion region = new TextureRegion(new Texture("Cars.png"));
	
	
	Vector2 direction ;
	float directionDgree; 
	
	Sprite sprite ;
	float speed = 0;
	final float maxSpeed = 5  ;
	final float minSpeed = 3 ;
	
	OrthographicCamera cam ;
	
	DirectionGUI dG;
	
	boolean selected =  false; 
	
	public Car() {
		// TODO Auto-generated constructor stub
		direction = new Vector2();
		
		TextureRegion[][] cars  = region.split(43, 100);
		sprite = new Sprite(cars[0][0]);
		sprite.setScale(.5f);
		setBounds(getX(), getY(), getWidth(), getHeight());
		
		sprite.setPosition(getX() - sprite.getWidth()/2, getY() - sprite.getHeight()/2 );
		sprite.setRotation(getRotation()-90);
		
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.zoom = .5f ;
		cam.lookAt(0, 0, 0);
		
		cam.update();
		
		dG = new DirectionGUI();
		dG.setScale(.5f * cam.zoom);
		dG.setPosition(cam.position.x, cam.position.y);
		
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		sprite.draw(batch);
		
	}
	
	@Override
	protected void positionChanged() {
		
		
		
		sprite.setPosition(getX() - sprite.getWidth()/2, getY() - sprite.getHeight()/2 );
		sprite.setRotation(getRotation()-90);
		setOrigin(getX() - sprite.getWidth()/2, getY() - sprite.getHeight()/2 );
		
		dG.setScale(.5f * cam.zoom);
		//System.out.println(dG.getScaleX());
		dG.setPosition(this.getOriginX(), this.getOriginY());
		
		super.positionChanged();
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
		
		
		if(selected){
			
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
			
			
			zoomControl(this.getSpeed(), cam);
			
			dG.setRotation(this.directionDgree * 180/ 3.14f * 2);
			
			cam.position.set(this.getX(), this.getY(), 0);

			if(Gdx.input.isKeyJustPressed(Keys.C)){
				exitCar();
			}
			
			
		}
		else{
			if(speed > .1f)
				speed -= .1f;
				else if(speed < -.1f)
				speed += .1f;
				else 
				speed = 0 ;
		}
			
			
	}
	public float getSpeed(){
		return speed;
	}
	public float getDirectionDgree(){
		return (float)((directionDgree*Math.PI)/180);
	}
	public static void zoomControl(float speed,OrthographicCamera cam){
		
		if(cam.zoom >= .5f && cam.zoom <= 1f && speed/50 < .5f && speed > 0)
			cam.zoom = speed/50+.5f ;
	}
	public void exitCar(){
		selected = false ;
		
	}
	
	
}
