package com.ktarrant.caesar.map;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;

public class Tile {
	
	/** Class for triangular game tiles **/
	boolean isWireframe = false;
	
	static final float TILE_WIDTH = 1.0f;
	static final float TILE_PITCH = 60.0f; // 0 < TILE_PITCH < 90
	static final float TILE_XC = MathUtils.cosDeg(TILE_PITCH);
	static final float TILE_YC = MathUtils.sinDeg(TILE_PITCH);
	static final float TILE_AC = 1/(2*TILE_XC);
	static final float TILE_BC = 1/(2*TILE_YC);
	
	Vector2 hexPosition = new Vector2();
	Rectangle bounds = new Rectangle();
	
	public Tile (Vector2 hexPosition) {
		isWireframe = true;
		this.hexPosition = hexPosition;
		this.bounds.width = 2 * TILE_WIDTH * TILE_XC;
		this.bounds.height = 2 * TILE_WIDTH * TILE_YC;
	}
	
	public Vector2 getHexPosition() {
		return this.hexPosition;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}
	
	public static Vector2 hexToDraw(Vector2 hexPosition) {
		Vector2 drawPos = new Vector2();
		
		drawPos.x = TILE_AC * (hexPosition.x + hexPosition.y);
		drawPos.y = TILE_BC * (hexPosition.y - hexPosition.x);
		
		return drawPos;
	}
	
	public static Vector2 drawToHex(Vector2 drawPosition) {
		Vector2 hexPos = new Vector2();
		
		hexPos.x = TILE_XC * drawPosition.x - TILE_YC * drawPosition.y;
		hexPos.x = TILE_XC * drawPosition.x + TILE_YC * drawPosition.y;
		
		return hexPos;
	}	
	
	public Vector2 getDrawPosition() {
		return hexToDraw(this.hexPosition);
	}
}
