package com.jomuvi.entities.npc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class NPCStoreHairStyle extends Entity {
	// novo
	public static boolean NextA = false;
	public static int timeLeg = 0, maxTimeLeg = 60 * 4;
	public String[] frases = new String[4];

	// fim

	private BufferedImage NPCStoreHairStyle;
	private boolean ShowTexto = false;

	public NPCStoreHairStyle(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		frases[0] = "Ol�. Bem vindo! Ao cabeleireiro";
		frases[1] = "no momento n�o estamos aberto";
		frases[2] = "volte mais tarde (working in progress)";
		NPCStoreHairStyle = Game.spritesheetNPC.getSprite(05 * 16, 00 * 00, 16, 16);

	}

	public void tick() {

		if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) < 20) {
			Game.NextSomeNPC = true;
			this.ShowTexto = true;
		}
		if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) > 20) {
			ShowTexto = false;
		}
	}

	public void render(Graphics g) {
		super.render(g);
		g.drawImage(NPCStoreHairStyle, this.getX() - Camera.x, this.getY() - Camera.y, null);
		if (Game.NextSomeNPC && this.ShowTexto) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(0, Game.HEIGHT - (Game.HEIGHT / 4), Game.WIDTH, (Game.HEIGHT / 2) / 2);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.drawString(frases[0], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 15) - (Game.HEIGHT / 4));
			g.drawString(frases[1], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 25) - (Game.HEIGHT / 4));
			g.drawString(frases[2], (Game.WIDTH / 5) - 3, (Game.HEIGHT +35) - (Game.HEIGHT / 4));
		}
	}
}
