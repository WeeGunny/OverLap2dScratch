package com.mygdx.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Luke on 2016-05-19.
 */
public class Player implements IScript{
    private Entity player;
    TransformComponent tc;
    Vector2 vPosition;
    float fJump=50;
    float fGravity=100;

    @Override
    public void init(Entity entity) {
        player= entity;
        tc= ComponentRetriever.get(entity,TransformComponent.class);
        vPosition= new Vector2(100,0);

    }

    @Override
    public void act(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            tc.x-=vPosition.x*delta;
            tc.scaleX = 1;

        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            tc.x+=vPosition.x*delta;
            tc.scaleX = 1;

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            vPosition.y= fJump;
        }
        vPosition.y -=fGravity*delta;

        tc.y += vPosition.y*delta;

        if(tc.y<=7){
            vPosition.y=0;
            tc.y=7;
        }

    }

    @Override
    public void dispose() {

    }
}
