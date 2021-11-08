package com.jomuvi.entities.store;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class Ship extends Entity {

	private BufferedImage Store_Ship;

	public Ship(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		Store_Ship = Game.spritesheetImoveisFastRavel.getSprite(0, 0, 5 * 16, 4 * 16);
	}

	public void render(Graphics g) {
		g.drawImage(Store_Ship, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}
//0 0
//3 5