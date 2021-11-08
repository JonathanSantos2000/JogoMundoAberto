package com.jomuvi.entities.npc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class NPCStoreInn extends Entity {
	public String[] frases = new String[4];

	// fim

	private BufferedImage NPCStoreInn;
	private boolean ShowTexto = false;

	public NPCStoreInn(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		frases[0] = "Olá. Bem vindo! Ao nosso Hotel";
//		frases[1] = "Se quiser atendimento Pressione ENTER";
		frases[1] = "no momento não estamos aberto.";
		frases[2] = "volte mais tarde (working in progress)";
		NPCStoreInn = Game.spritesheetNPC.getSprite(07 * 16, 00 * 00, 16, 16);

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
		g.drawImage(NPCStoreInn, this.getX() - Camera.x, this.getY() - Camera.y, null);
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
