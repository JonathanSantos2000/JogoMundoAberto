package com.jomuvi.entities.npc;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.entities.Player;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;
import com.jomuvi.world.ZombieCreator;

public class Portal extends Entity {

	private BufferedImage Portal;
	private String[] LvMapa = { "PortalMp1paraMp2", "PortalMp1paraMp6", "PortalMp1paraMp7", "PortalMp2paraMp1",
			"PortalMp2paraMp9", "PortalMp3paraMp5", "PortalMp3paraMp6", "PortalMp3paraMp8", "PortalMp4paraMp5",
			"PortalMp4paraMp6", "PortalMp4paraMp7", "PortalMp5paraMp4", "PortalMp5paraMp3", "PortalMp6paraMp1",
			"PortalMp6paraMp3", "PortalMp6paraMp4", "PortalMp6paraMp9", "PortalMp7paraMp1", "PortalMp7paraMp4",
			"PortalMp8paraMp3", "PortalMp8paraMp9", "PortalMp9paraMp2", "PortalMp9paraMp6", "PortalMp9paraMp8",
			"PortalMp9paraMp10", "PortalMp10paraMp9" };
	private int[] liberarInimigo = { 2, 6, 7, 1, 9, 5, 6, 8, 5, 6, 7, 4, 3, 1, 3, 4, 9, 1, 4, 3, 9, 2, 6, 8, 10, 9 };
	private int[] numeroMapa = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
			26, 27, 28 };

	private String mapa;

	public Portal(int x, int y, int width, int height, BufferedImage sprite, String LvMapa) {
		super(x, y, width, height, sprite);
		this.mapa = LvMapa;
		Portal = Game.spritesheetBlocosPonte.getSprite(7 * 16, 0, 16, 16);
	}

	public void tick() {
		Player.arma = true;
		for (int i = 0; i < LvMapa.length; i++) {
			if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) < 20
					&& LvMapa[i] == mapa) {
				Game.CUR_LEVEL = numeroMapa[i];
				Game.gameState = "TRASICAO";
				Game.transi.right = true;
				Game.RespawMobs = true;
				ZombieCreator.RespawMp(Integer.toString(liberarInimigo[i]));
				World.restartGame(World.NomesMapas[numeroMapa[i]]);
				break;
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(Portal, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}
