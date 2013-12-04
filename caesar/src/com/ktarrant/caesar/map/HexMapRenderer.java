package com.ktarrant.caesar.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class HexMapRenderer {
	private TiledMap map;
	private OrthographicCamera cam;
	OrthogonalTiledMapRenderer renderer;
	
	public HexMapRenderer(TiledMap map) {
		this.map = map;
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(true, 30, 20); 	// desire 30x20 tiles in view
		this.cam.update();
		
		float unitScale = 1 / 16.0f;
		this.renderer = new OrthogonalTiledMapRenderer(map, unitScale);
	}

	public void render() {
		this.renderer.render();
	}

}
