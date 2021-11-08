package com.jomuvi.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.jomuvi.main.Game;

public class Tile {

	public static BufferedImage TILE_BIOMA_NO = Game.spritesheetBlocos.getSprite(00 * 00, 00 * 00, 16, 16);
	public static BufferedImage TILE_BIOMA_SA = Game.spritesheetBlocos.getSprite(01 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_BIOMA_ST = Game.spritesheetBlocos.getSprite(02 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_BIOMA_SN = Game.spritesheetBlocos.getSprite(03 * 16, 00 * 00, 16, 16);

	public static BufferedImage TILE_BASE_WALL = Game.spritesheetBlocos.getSprite(04 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_BASE_AGUA = Game.spritesheetBlocos.getSprite(06 * 16, 00 * 00, 16, 16);

//	Caminho
	public static BufferedImage TILE_BASE_PATH = Game.spritesheetBlocos.getSprite(05 * 16, 00 * 00, 16, 16);

	public static BufferedImage TILE_BASE_PATH_V_E = Game.spritesheetBlocos.getSprite(03 * 16, 05 * 16, 16, 16);
	public static BufferedImage TILE_BASE_PATH_V_D = Game.spritesheetBlocos.getSprite(03 * 16, 06 * 16, 16, 16);
	public static BufferedImage TILE_BASE_PATH_H_C = Game.spritesheetBlocos.getSprite(02 * 16, 05 * 16, 16, 16);
	public static BufferedImage TILE_BASE_PATH_H_B = Game.spritesheetBlocos.getSprite(02 * 16, 06 * 16, 16, 16);

	public static BufferedImage TILE_BASE_PATH_H_C_V_D = Game.spritesheetBlocos.getSprite(01 * 16, 05 * 16, 16, 16);
	public static BufferedImage TILE_BASE_PATH_H_B_V_D = Game.spritesheetBlocos.getSprite(01 * 16, 06 * 16, 16, 16);
	public static BufferedImage TILE_BASE_PATH_H_C_V_E = Game.spritesheetBlocos.getSprite(00 * 00, 05 * 16, 16, 16);
	public static BufferedImage TILE_BASE_PATH_H_B_V_E = Game.spritesheetBlocos.getSprite(00 * 00, 06 * 16, 16, 16);

	public static BufferedImage TILE_CERCA = Game.spritesheetBlocos.getSprite(00 * 00, 01 * 16, 16, 16);
//Morro
	public static BufferedImage TILE_MORRO_H_B = Game.spritesheetBlocos.getSprite(07 * 16, 06 * 16, 16, 16);
	public static BufferedImage TILE_MORRO_H_C = Game.spritesheetBlocos.getSprite(06 * 16, 05 * 16, 16, 16);
	public static BufferedImage TILE_MORRO_V_E = Game.spritesheetBlocos.getSprite(06 * 16, 06 * 16, 16, 16);
	public static BufferedImage TILE_MORRO_V_D = Game.spritesheetBlocos.getSprite(07 * 16, 05 * 16, 16, 16);

//-------------------------------------------------------------------------------------------------------------	
//	RIO
	public static BufferedImage TILE_BORDA_RIO_D = Game.spritesheetBlocos.getSprite(9 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_BORDA_RIO_E = Game.spritesheetBlocos.getSprite(8 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_BORDA_RIO_C = Game.spritesheetBlocos.getSprite(8 * 16, 01 * 16, 16, 16);
	public static BufferedImage TILE_BORDA_RIO_B = Game.spritesheetBlocos.getSprite(9 * 16, 01 * 16, 16, 16);

// PONTE	
	public static BufferedImage TILE_PONTE = Game.spritesheetBlocosPonte.getSprite(0, 2 * 16, 16, 16);
	public static BufferedImage TILE_PONTE_PTCima = Game.spritesheetBlocosPonte.getSprite(0, 16, 16, 16);
	public static BufferedImage TILE_PONTE_PTBaixo = Game.spritesheetBlocosPonte.getSprite(0, 3 * 16, 16, 16);

	public static BufferedImage TILE_TroncoPonte = Game.spritesheetBlocosPonte.getSprite(3 * 16, 0, 16, 16);
	public static BufferedImage TILE_CordaPonte = Game.spritesheetBlocosPonte.getSprite(2 * 16, 16, 16, 16);

	public static BufferedImage TILE_PonteFlorestaInicioV = Game.spritesheetBlocosPonte.getSprite(4 * 16, 16, 32, 32);
	public static BufferedImage TILE_PonteFlorestaMeioV = Game.spritesheetBlocosPonte.getSprite(4 * 16, 2 * 16, 32, 32);
	public static BufferedImage TILE_PonteFlorestaFinalV = Game.spritesheetBlocosPonte.getSprite(4 * 16, 3 * 16, 32,
			32);

	public static BufferedImage TILE_PonteFlorestaInicioH = Game.spritesheetBlocosPonte.getSprite(4 * 16, 0, 32, 32);
	public static BufferedImage TILE_PonteFlorestaMeioH = Game.spritesheetBlocosPonte.getSprite(5 * 16, 0, 32, 32);
	public static BufferedImage TILE_PonteFlorestaFinalH = Game.spritesheetBlocosPonte.getSprite(6 * 16, 0, 32, 32);

//----------
	public static BufferedImage TILE_GUARDAE = Game.spritesheetNPC.getSprite(01 * 16, 0 * 00, 16, 16);
	public static BufferedImage TILE_GUARDAD = Game.spritesheetNPC.getSprite(02 * 16, 0 * 00, 16, 16);

	// PLANTAS
	public static BufferedImage TILE_ARBU = Game.spritesheetBlocos.getSprite(00 * 00, 2 * 16, 16, 16);
	public static BufferedImage TILE_FLOR = Game.spritesheetBlocos.getSprite(01 * 16, 2 * 16, 16, 16);

	// Arvore
	public static BufferedImage TILE_TREE_PT1 = Game.spritesheetImoveis.getSprite(04 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_TREE_PT2 = Game.spritesheetImoveis.getSprite(05 * 16, 00 * 00, 16, 16);
	public static BufferedImage TILE_TREE_PT3 = Game.spritesheetImoveis.getSprite(06 * 16, 00 * 00, 16, 16);

	public static BufferedImage TILE_TREE_PT4 = Game.spritesheetImoveis.getSprite(04 * 16, 01 * 16, 16, 16);
	public static BufferedImage TILE_TREE_PT5 = Game.spritesheetImoveis.getSprite(05 * 16, 01 * 16, 16, 16);
	public static BufferedImage TILE_TREE_PT6 = Game.spritesheetImoveis.getSprite(06 * 16, 01 * 16, 16, 16);

	public static BufferedImage TILE_TREE_PT7 = Game.spritesheetImoveis.getSprite(04 * 16, 02 * 16, 16, 16);
	public static BufferedImage TILE_TREE_PT8 = Game.spritesheetImoveis.getSprite(05 * 16, 02 * 16, 16, 16);
	public static BufferedImage TILE_TREE_PT9 = Game.spritesheetImoveis.getSprite(06 * 16, 02 * 16, 16, 16);

	public BufferedImage sprite;
	public int x, y;

	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}
}
