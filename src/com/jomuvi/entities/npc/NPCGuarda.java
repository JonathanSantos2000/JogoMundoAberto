package com.jomuvi.entities.npc;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class NPCGuarda extends Entity {

	private BufferedImage NPCGuard;

	public NPCGuarda(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		NPCGuard = Game.spritesheetNPC.getSprite(00 * 00, 00 * 00, 16, 16);
	}

	public void tick() {
		if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) > 60) {
 		}
	}

	public void render(Graphics g) {
		g.drawImage(NPCGuard, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}
