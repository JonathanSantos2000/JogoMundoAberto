package com.jomuvi.entities.npc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.entities.Player;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;
import com.jomuvi.world.ZombieCreator;

public class NPCMarine extends Entity {

	private BufferedImage NPCMarine;
	private String[] lvMapa = { "Cidade", "MapaLv1", "MapaLv11", "MapaLv21", "MapaLv31" };
	private String mapa;
	public String[] frases = new String[4];
	private boolean ShowTexto = false;
	public static boolean ativartransicao = false;

	public NPCMarine(int x, int y, int width, int height, BufferedImage sprite, String LvMapa) {
		super(x, y, width, height, sprite);
		frases[0] = "Olá. Bem vindo!";
//		frases[1] = "Se quiser atendimento Pressione ENTER";
		frases[1] = "no momento não estamos ";
		frases[2] = "viajando para essas areas.";
		frases[3] = "volte mais tarde (working in progress)";
		this.mapa = LvMapa;
		NPCMarine = Game.spritesheetNPC.getSprite(8 * 16, 00 * 00, 16, 16);
	}

	public void tick() {
		for (int i = 0; i < lvMapa.length; i++) {
			if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) < 20
					&& lvMapa[i] == mapa) {
				if (this.mapa == lvMapa[0]) {

					Game.CUR_LEVEL = i + 1;
					ZombieCreator.RespawMp(Integer.toString(i));
					World.restartGame(World.NomesMapas[i + 1]);
					Player.arma = false;
					ativartransicao = true;
				}
				if (this.mapa == lvMapa[1]) {
					Game.CUR_LEVEL = i + 1;
					ZombieCreator.RespawMp(Integer.toString(i));
					World.restartGame(World.NomesMapas[i + 1]);
					ativartransicao = true;
				}
				if (this.mapa == lvMapa[2]) {
					Game.NextSomeNPC = true;
					ShowTexto = true;
				}
				if (this.mapa == lvMapa[3]) {
					Game.NextSomeNPC = true;
					ShowTexto = true;
				}
				if (this.mapa == lvMapa[4]) {
					Game.NextSomeNPC = true;
					ShowTexto = true;
				}

				if (ativartransicao) {
					Game.gameState = "TRASICAO";
					if (i == 0) {
						Game.RespawMobs = false;
						Game.transi.left = true;
						break;
					} else {
						Game.transi.right = true;
						Game.RespawMobs = true;
						break;
					}
				}
			}
			if (calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) > 20) {
				ShowTexto = false;
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(NPCMarine, this.getX() - Camera.x, this.getY() - Camera.y, null);
		if (this.ShowTexto) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(0, Game.HEIGHT - (Game.HEIGHT / 4), Game.WIDTH, (Game.HEIGHT / 2) / 2);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.drawString(frases[0], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 15) - (Game.HEIGHT / 4));
			g.drawString(frases[1], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 25) - (Game.HEIGHT / 4));
			g.drawString(frases[2], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 35) - (Game.HEIGHT / 4));
			g.drawString(frases[3], (Game.WIDTH / 5) - 3, (Game.HEIGHT + 45) - (Game.HEIGHT / 4));
		}
	}
}
