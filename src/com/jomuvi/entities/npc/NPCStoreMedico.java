package com.jomuvi.entities.npc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class NPCStoreMedico extends Entity {
	public String[] frases = new String[2];
	private static boolean ShowTexto = false;
	// fim

	private BufferedImage NPCMedico;

	public NPCStoreMedico(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		frases[0] = "Ol�. Bem vindo! Ao POSTO M�DICO";
		frases[1] = "Se quiser atendimento Pressione ENTER";
		NPCMedico = Game.spritesheetNPC.getSprite(04 * 16, 00 * 00, 16, 16);

	}

	public void tick() {
		if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) < 20) {
			Game.NextSomeNPC = true;
			ShowTexto = true;
		}
		if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) > 20) {
			ShowTexto = false;
			Game.NextSomeNPC = false;
		}
		if (Game.ShowPotion) {
			ShowTexto = false;
		}
	}

	public void render(Graphics g) {
		super.render(g);
		g.drawImage(NPCMedico, this.getX() - Camera.x, this.getY() - Camera.y, null);
		if (Game.NextSomeNPC && ShowTexto && !Game.ShowInventario) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(0, Game.HEIGHT - (Game.HEIGHT / 4), Game.WIDTH, (Game.HEIGHT / 2) / 2);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.drawString(frases[0], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 15) - (Game.HEIGHT / 4));
			g.drawString(frases[1], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 25) - (Game.HEIGHT / 4));
		}
	}

	public static boolean isShowTexto() {
		return ShowTexto;
	}

	public static void setShowTexto(boolean showTexto) {
		ShowTexto = showTexto;
	}
}
