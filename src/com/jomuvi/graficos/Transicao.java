package com.jomuvi.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.npc.NPCMarine;
import com.jomuvi.main.Game;

public class Transicao {
	public static BufferedImage loadingfloresta = Game.loadingfloresta.getSprite(0, 0, 127, 91);
	public static BufferedImage BarcoRight = Game.spritesheetImoveisFastRavel.getSprite(0, 4 * 16, 5 * 16, 4 * 16);
	public static BufferedImage BarcoLeft = Game.spritesheetImoveisFastRavel.getSprite(0, 0, 5 * 16, 4 * 16);

	public int framesBarcoRight = 0, framesBarcoLeft = 260, maxFramesBarco = 260, minFramesBarco = 0;
	public boolean right, left;

	public void tick() {
		if (right) {
			framesBarcoRight++;
			if (framesBarcoRight == maxFramesBarco) {
				framesBarcoRight = 0;
				Game.gameState = "NORMAL";
				NPCMarine.ativartransicao=false;
				right = false;
			}
		}
		if (left) {
			framesBarcoLeft--;
			if (framesBarcoLeft == minFramesBarco) {
				framesBarcoLeft = 260;
				Game.gameState = "NORMAL";
				NPCMarine.ativartransicao=false;
				left = false;
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		g.drawImage(loadingfloresta, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		if (right)
			g.drawImage(BarcoRight, framesBarcoRight, (Game.HEIGHT / 2) + 57, 5 * 16, 4 * 16, null);
		if (left)
			g.drawImage(BarcoLeft, framesBarcoLeft, (Game.HEIGHT / 2) + 57, 5 * 16, 4 * 16, null);
//		sombra 
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fillRect((Game.WIDTH / 3) + 10, 5, 110, 30);
//		--------
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString("Survivor", (Game.WIDTH / 3) + 20, 20);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("RPG", (Game.WIDTH / 2) + 25, (Game.HEIGHT / 2) - 100);

	}

}
