package com.ktarrant.caesar.screens;

import com.ktarrant.caesar.Logger;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.GL10;

public class GameScreen implements Screen {
	Logger log;
	private TiledMap map = null;
	private TiledMapRenderer renderer = null;
	
	
	
	public GameScreen() {
		log = new Logger("GameScreen");
	}
	

	@Override
	public void show() {
		log.out("Showing game screen.");
		if (map == null) {
			this.map = Loader.getInstance().loadMap("data/wallpaper.tmx");
		}
		if (renderer == null) {
			float unitScale = 1 / 16f;
			OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(map, unitScale);
		}
	}

	@Override
	public void render(float delta) {
		if (!Loader.getInstance().isLoading()) {
			log.out("Rendering... ", false);
			Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			renderer.render();
			log.out("Done!");
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}