package com.tutorial.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Character extends Actor {
	
	Sprite sprite ;
	public OrthographicCamera cam ;
	boolean selected =  true ; 
	
	public Character() {
		// TODO Auto-generated constructor stub
		TextureRegion[][] tr = TextureRegion.split(new Texture("Cars.png"), 40, 35);
		sprite = new Sprite(tr[3][0]);
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.zoom = .5f ;
		setBounds(getX(), getY(), sprite.getWidth(), sprite.getHeight());
		
	}
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		
		
		if(selected){
		
		cam.position.x = getX() ;
		cam.position.y = getY();
			
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
		setPosition(getX(), getY()+1);
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			setPosition(getX(), getY()-1);
		}
	
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				setPosition(getX()-1, getY());
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				setPosition(getX()+1, getY());
			}	
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
				enterCar();
			}
		}
		
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		if(selected)
		batch.draw(sprite,getX(),getY());
	}
	
	public void enterCar(){
		selected = false ;
	}
	
}
