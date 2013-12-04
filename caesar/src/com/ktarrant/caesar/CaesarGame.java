package com.ktarrant.caesar;

import com.ktarrant.caesar.screens.GameScreen;

import com.badlogic.gdx.Game;

public class CaesarGame extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
