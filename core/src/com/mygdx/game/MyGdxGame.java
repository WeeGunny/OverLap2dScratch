package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class MyGdxGame extends ApplicationAdapter {
	SceneLoader sceneLoader;

	
	@Override
	public void create () {
		Viewport viewport= new FitViewport(267,133);
		sceneLoader= new SceneLoader();
		sceneLoader.loadScene("TestScene",viewport);
		ItemWrapper root= new ItemWrapper(sceneLoader.getRoot());
		Player player= new Player();
		root.getChild("Sheep").addScript(player);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());


	}
}
