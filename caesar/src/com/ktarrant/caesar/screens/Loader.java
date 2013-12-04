package com.ktarrant.caesar.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.ktarrant.caesar.Logger;

public class Loader {
	
	private static Loader instance = null;
	
	protected Loader() {
		// Singleton
	}
	
	public static Loader getInstance() {
		if (instance == null) {
			instance = new Loader();
		}
		return instance;
	}

	AssetManager assetManager = new AssetManager();
	Logger log = new Logger("Loader");
	
	public TiledMap loadMap(String assetPath) {
		log.out("Loading map '" + assetPath + "'... ", false);
		assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		assetManager.load(assetPath, TiledMap.class);
		assetManager.finishLoading();
		log.out("Done!");
		return assetManager.get(assetPath);
	}
	
	public boolean isLoading() {
		return !assetManager.update();
	}
}
