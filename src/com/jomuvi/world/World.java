package com.jomuvi.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//import com.jomuvi.entities.BotPlayer;
import com.jomuvi.entities.Entity;
import com.jomuvi.entities.Player;
import com.jomuvi.entities.Placas.PlacasMapas1_10;
import com.jomuvi.entities.npc.NPCGuarda;
import com.jomuvi.entities.npc.NPCMarine;
import com.jomuvi.entities.npc.NPCStoreArmer;
import com.jomuvi.entities.npc.NPCStoreHairStyle;
import com.jomuvi.entities.npc.NPCStoreInn;
import com.jomuvi.entities.npc.NPCStoreMedico;
import com.jomuvi.entities.npc.NPCStoreStyler;
import com.jomuvi.entities.npc.Portal;
import com.jomuvi.entities.store.Ship;
import com.jomuvi.entities.store.Sleep;
import com.jomuvi.entities.store.Store_Drug;
import com.jomuvi.entities.store.Store_Guns;
import com.jomuvi.entities.store.Store_Salon;
import com.jomuvi.entities.store.Store_Style;
import com.jomuvi.graficos.Spritesheet;
import com.jomuvi.main.Game;

public class World {

	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;

	public static String[] NomesMapas = { "", "mapasDoJogo/Cidade.png", "mapasDoJogo/MapaLevel1-Cidade.png",
			"mapasDoJogo/MapaLevel2-MpL1.png", "mapasDoJogo/MapaLevel6-MpL1.png", "mapasDoJogo/MapaLevel7-MpL1.png",
			"mapasDoJogo/MapaLevel1-MpL2.png", "mapasDoJogo/MapaLevel9-MpL2.png", "mapasDoJogo/MapaLevel5-MpL3.png",
			"mapasDoJogo/MapaLevel6-MpL3.png", "mapasDoJogo/MapaLevel8-MpL3.png", "mapasDoJogo/MapaLevel5-MpL4.png",
			"mapasDoJogo/MapaLevel6-MpL4.png", "mapasDoJogo/MapaLevel7-MpL4.png", "mapasDoJogo/MapaLevel4-MpL5.png",
			"mapasDoJogo/MapaLevel3-MpL5.png", "mapasDoJogo/MapaLevel1-MpL6.png", "mapasDoJogo/MapaLevel3-MpL6.png",
			"mapasDoJogo/MapaLevel4-MpL6.png", "mapasDoJogo/MapaLevel9-MpL6.png", "mapasDoJogo/MapaLevel1-MpL7.png",
			"mapasDoJogo/MapaLevel4-MpL7.png", "mapasDoJogo/MapaLevel3-MpL8.png", "mapasDoJogo/MapaLevel9-MpL8.png",
			"mapasDoJogo/MapaLevel2-MpL9.png", "mapasDoJogo/MapaLevel6-MpL9.png", "mapasDoJogo/MapaLevel8-MpL9.png",
			"mapasDoJogo/MapaLevel10-MpL9.png", "mapasDoJogo/MapaLevel9-MpL10.png" };

	public static boolean stop = false;
	public static int qtEnemies01 = 0, maxQtEnemies01 = 22, qtEnemies01Map = 0;
	public static int[] xEnemies01 = new int[maxQtEnemies01 + 1];
	public static int[] yEnemies01 = new int[maxQtEnemies01 + 1];

	public static boolean stop2 = false;
	public static int qtEnemies02, maxQtEnemies02 = 22, qtEnemies02Map = 0;
	public static int[] xEnemies02 = new int[maxQtEnemies02 + 1];
	public static int[] yEnemies02 = new int[maxQtEnemies02 + 1];

	public static boolean stop3 = false;
	public static int qtEnemies03, maxQtEnemies03 = 22, qtEnemies03Map = 0;
	public static int[] xEnemies03 = new int[maxQtEnemies03 + 1];
	public static int[] yEnemies03 = new int[maxQtEnemies03 + 1];

	public static boolean stop4 = false;
	public static int qtEnemies04, maxQtEnemies04 = 22, qtEnemies04Map = 0;
	public static int[] xEnemies04 = new int[maxQtEnemies04 + 1];
	public static int[] yEnemies04 = new int[maxQtEnemies04 + 1];;

	public static boolean stop5 = false;
	public static int qtEnemies05, maxQtEnemies05 = 22, qtEnemies05Map = 0;
	public static int[] xEnemies05 = new int[maxQtEnemies05 + 1];
	public static int[] yEnemies05 = new int[maxQtEnemies05 + 1];

	public static boolean stop6 = false;
	public static int qtEnemies06 = 0, maxQtEnemies06 = 22, qtEnemies06Map = 0;
	public static int[] xEnemies06 = new int[maxQtEnemies06 + 6];
	public static int[] yEnemies06 = new int[maxQtEnemies06 + 1];

	public static boolean stop7 = false;
	public static int qtEnemies07, maxQtEnemies07 = 22, qtEnemies07Map = 0;
	public static int[] xEnemies07 = new int[maxQtEnemies07 + 1];
	public static int[] yEnemies07 = new int[maxQtEnemies07 + 1];

	public static boolean stop8 = false;
	public static int qtEnemies08, maxQtEnemies08 = 22, qtEnemies08Map = 0;
	public static int[] xEnemies08 = new int[maxQtEnemies08 + 1];
	public static int[] yEnemies08 = new int[maxQtEnemies08 + 1];

	public static boolean stop9 = false;
	public static int qtEnemies09, maxQtEnemies09 = 22, qtEnemies09Map = 0;
	public static int[] xEnemies09 = new int[maxQtEnemies09 + 1];
	public static int[] yEnemies09 = new int[maxQtEnemies09 + 1];;

	public static boolean stop10 = false;
	public static int qtEnemies10, maxQtEnemies10 = 22, qtEnemies10Map = 0;
	public static int[] xEnemies10 = new int[maxQtEnemies10 + 1];
	public static int[] yEnemies10 = new int[maxQtEnemies10 + 1];

	public static int xboss1, xboss2, xboss3, xboss4, xboss5, xboss6, xboss7, xboss8, xboss9, xboss10;
	public static int yboss1, yboss2, yboss3, yboss4, yboss5, yboss6, yboss7, yboss8, yboss9, yboss10;

	public static int mapaAntigo;

	public static int posicaoPlayer;

	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			for (int xx = 0; xx < map.getWidth(); xx++) {
				for (int yy = 0; yy < map.getHeight(); yy++) {
					int pixelAtual = pixels[xx + (yy * map.getWidth())];
					tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
//Biomas
//Normal
					if (pixelAtual == 0xFF000000) {

						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);

					}

// Sand
					else if (pixelAtual == 0xFFF7C995) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BIOMA_SA);
					}
//Stone
					else if (pixelAtual == 0xFF909090) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BIOMA_ST);
					}
//Snow
					else if (pixelAtual == 0xFFE3F3F3) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BIOMA_SN);
					} else if (pixelAtual == 0xFF404040) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_SN);
					}
//fim Biomas
//					RIO
					else if (pixelAtual == 0xFFFF00D0) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
					} else if (pixelAtual == 0xFFFF00D1) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BORDA_RIO_E);
					} else if (pixelAtual == 0xFFFF00D2) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BORDA_RIO_C);
					} else if (pixelAtual == 0xFFFF00D3) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BORDA_RIO_D);
					} else if (pixelAtual == 0xFFFF00D4) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BORDA_RIO_B);
					}
//Ponte
					else if (pixelAtual == 0xFF9E7653) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_PONTE);
					} else if (pixelAtual == 0xFF9E7654) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PONTE);
					} else if (pixelAtual == 0xFF9E7100) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PONTE_PTCima);
					} else if (pixelAtual == 0xFF9E7200) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PONTE_PTBaixo);
					}

					else if (pixelAtual == 0xFF9E7658) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TroncoPonte);
					} else if (pixelAtual == 0xFF4C3B26) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_CordaPonte);
					}

//					Ponte Mapas					
					else if (pixelAtual == 0xFF9E1000) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PonteFlorestaInicioH);
					} else if (pixelAtual == 0xFF9E1010) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PonteFlorestaMeioH);
					} else if (pixelAtual == 0xFF9E1020) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PonteFlorestaFinalH);
					}
//					
					else if (pixelAtual == 0xFF9E1030) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PonteFlorestaInicioV);
					} else if (pixelAtual == 0xFF9E1040) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PonteFlorestaMeioV);
					} else if (pixelAtual == 0xFF9E1050) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_PonteFlorestaFinalV);
					} else if (pixelAtual == 0xFF0093FF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_AGUA);
					}

//					Caminho
					else if (pixelAtual == 0xFFADD8E6) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
					} else if (pixelAtual == 0xFF4800F0) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_V_D);
					} else if (pixelAtual == 0xFF4800F1) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_V_E);
					} else if (pixelAtual == 0xFF4800F2) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_H_C);
					} else if (pixelAtual == 0xFF4800F3) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_H_B);
					} //
					else if (pixelAtual == 0xFF4800F4) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_H_C_V_D);
					} else if (pixelAtual == 0xFF4800F5) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_H_B_V_D);
					} else if (pixelAtual == 0xFF4800F6) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_H_B_V_E);
					} else if (pixelAtual == 0xFF4800F7) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH_H_C_V_E);
					}
//-----------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------					
					else if (pixelAtual == 0xFF008080) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_WALL);
					} else if (pixelAtual == 0xFFFFFFFF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
					}  else if (pixelAtual == 0xFF0026BE) {
						// GUARDA
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_GUARDAE);
					} else if (pixelAtual == 0xFF0026BF) {
						// GUARDA
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_GUARDAD);
					} else if (pixelAtual == 0xFF6D7F3F) {
						// FLOR
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_FLOR);
					}

					// ARBUSTO
					else if (pixelAtual == 0xFF3F4971) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_ARBU);
					}
//-------------------------------------------
// Transporte
					else if (pixelAtual == 0xFF009300) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_AGUA);
						Ship Ship = new Ship(xx * 16, yy * 16, 16, 16, Entity.SalonStore);
						Game.entities.add(Ship);
					} else if (pixelAtual == 0xFF009310) {
						NPCMarine marineL1 = new NPCMarine(xx * 16, yy * 16, 16, 16, Entity.NPCMarine, "MapaLv1");
						Game.entities.add(marineL1);
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_CERCA);
					} else if (pixelAtual == 0xFF009311) {
						NPCMarine marineL11 = new NPCMarine(xx * 16, yy * 16, 16, 16, Entity.NPCMarine, "MapaLv11");
						Game.entities.add(marineL11);
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_CERCA);
					} else if (pixelAtual == 0xFF009312) {
						NPCMarine marineL21 = new NPCMarine(xx * 16, yy * 16, 16, 16, Entity.NPCMarine, "MapaLv21");
						Game.entities.add(marineL21);
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_CERCA);
					} else if (pixelAtual == 0xFF009313) {
						NPCMarine marineL31 = new NPCMarine(xx * 16, yy * 16, 16, 16, Entity.NPCMarine, "MapaLv31");
						Game.entities.add(marineL31);
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_CERCA);
					} else if (pixelAtual == 0xFF009314) {
						NPCMarine marineCidade = new NPCMarine(xx * 16, yy * 16, 16, 16, Entity.NPCMarine, "Cidade");
						Game.entities.add(marineCidade);
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_CERCA);
					}
// Tenda Farmacia e medico
					else if (pixelAtual == 0xFFFF6070) {
						Store_Drug farmacia = new Store_Drug(xx * 16, yy * 16, 16, 16, Entity.DrugStore);
						Game.entities.add(farmacia);
					} else if (pixelAtual == 0xFFFF6063) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
						NPCStoreMedico me = new NPCStoreMedico(xx * 16, yy * 16, 16, 16, Entity.NPCMedico);
						Game.entities.add(me);
					}
// -----------------
// Tenda Armas e armeiro
					else if (pixelAtual == 0xFF7F3300) {
						Store_Guns farmacia = new Store_Guns(xx * 16, yy * 16, 16, 16, Entity.GunsStore);
						Game.entities.add(farmacia);
					} else if (pixelAtual == 0xFF6B282A) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
						NPCStoreArmer ar = new NPCStoreArmer(xx * 16, yy * 16, 16, 16, Entity.NPCArmer);
						Game.entities.add(ar);
					}
//------------------
//Mall 
					else if (pixelAtual == 0xFFA17FF0) {
						Store_Style Mall = new Store_Style(xx * 16, yy * 16, 16, 16, Entity.StyleStore);
						Game.entities.add(Mall);
					} else if (pixelAtual == 0xFFFF3251) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
						NPCStoreStyler st = new NPCStoreStyler(xx * 16, yy * 16, 16, 16, Entity.NPCStyler);
						Game.entities.add(st);
					}
// -----------------
//Inn
					else if (pixelAtual == 0xFFFF7FB6) {
						Sleep inn = new Sleep(xx * 16, yy * 16, 16, 16, Entity.inn);
						Game.entities.add(inn);
					} else if (pixelAtual == 0xFFFF7FC0) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
						NPCStoreInn tar = new NPCStoreInn(xx * 16, yy * 16, 16, 16, Entity.NPCInn);
						Game.entities.add(tar);
					}
// ------
//Salon
					else if (pixelAtual == 0xFFFFE8FD) {
						Store_Salon salon = new Store_Salon(xx * 16, yy * 16, 16, 16, Entity.SalonStore);
						Game.entities.add(salon);
					} else if (pixelAtual == 0xFFFFE8FF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BIOMA_NO);
						NPCStoreHairStyle HrSt = new NPCStoreHairStyle(xx * 16, yy * 16, 16, 16, Entity.NPCHairStyle);
						Game.entities.add(HrSt);
					}

//--------------------------
//Portais mapas
//				portais level 1
					else if (pixelAtual == 0xFF01DF00) {
						Portal PortalMp1paraMp2 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp1paraMp2");
						Game.entities.add(PortalMp1paraMp2);
					} else if (pixelAtual == 0xFF01DF01) {
						Portal PortalMp1paraMp6 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp1paraMp6");
						Game.entities.add(PortalMp1paraMp6);
					} else if (pixelAtual == 0xFF01DF02) {
						Portal PortalMp1paraMp7 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp1paraMp7");
						Game.entities.add(PortalMp1paraMp7);
					}
//				portais level 2
					else if (pixelAtual == 0xFF01DF03) {
						Portal PortalMp2paraMp1 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp2paraMp1");
						Game.entities.add(PortalMp2paraMp1);
					} else if (pixelAtual == 0xFF01DF04) {
						Portal PortalMp2paraMp9 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp2paraMp9");
						Game.entities.add(PortalMp2paraMp9);
					}
//				portais level 3
					else if (pixelAtual == 0xFF01DF07) {
						Portal PortalMp3paraMp5 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp3paraMp5");
						Game.entities.add(PortalMp3paraMp5);
					} else if (pixelAtual == 0xFF01DF05) {
						Portal PortalMp3paraMp6 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp3paraMp6");
						Game.entities.add(PortalMp3paraMp6);
					} else if (pixelAtual == 0xFF01DF06) {
						Portal PortalMp3paraMp8 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp3paraMp8");
						Game.entities.add(PortalMp3paraMp8);
					}
//				portais level 4
					else if (pixelAtual == 0xFF01DF08) {
						Portal PortalMp4paraMp5 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp4paraMp5");
						Game.entities.add(PortalMp4paraMp5);
					} else if (pixelAtual == 0xFF01DF09) {
						Portal PortalMp4paraMp6 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp4paraMp6");
						Game.entities.add(PortalMp4paraMp6);
					} else if (pixelAtual == 0xFF01DF0A) {
						Portal PortalMp4paraMp7 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp4paraMp7");
						Game.entities.add(PortalMp4paraMp7);
					}
//				portais level 5
					else if (pixelAtual == 0xFF01DF0C) {
						Portal PortalMp5paraMp4 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp5paraMp4");
						Game.entities.add(PortalMp5paraMp4);
					} else if (pixelAtual == 0xFF01DF0B) {
						Portal PortalMp5paraMp3 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp5paraMp3");
						Game.entities.add(PortalMp5paraMp3);
					}
//				portais level 6
					else if (pixelAtual == 0xFF01DF10) {
						Portal PortalMp6paraMp1 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp6paraMp1");
						Game.entities.add(PortalMp6paraMp1);
					} else if (pixelAtual == 0xFF01DF0D) {
						Portal PortalMp6paraMp3 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp6paraMp3");
						Game.entities.add(PortalMp6paraMp3);
					} else if (pixelAtual == 0xFF01DF0E) {
						Portal PortalMp6paraMp4 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp6paraMp4");
						Game.entities.add(PortalMp6paraMp4);
					} else if (pixelAtual == 0xFF01DF0F) {
						Portal PortalMp6paraMp9 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp6paraMp9");
						Game.entities.add(PortalMp6paraMp9);
					}
//				portais level 7
					else if (pixelAtual == 0xFF01DF12) {
						Portal PortalMp7paraMp1 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp7paraMp1");
						Game.entities.add(PortalMp7paraMp1);
					} else if (pixelAtual == 0xFF01DF11) {
						Portal PortalMp7paraMp4 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp7paraMp4");
						Game.entities.add(PortalMp7paraMp4);
					}
//				portais level 8
					else if (pixelAtual == 0xFF01DF13) {
						Portal PortalMp8paraMp3 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp8paraMp3");
						Game.entities.add(PortalMp8paraMp3);
					} else if (pixelAtual == 0xFF01DF14) {
						Portal PortalMp8paraMp9 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp8paraMp9");
						Game.entities.add(PortalMp8paraMp9);
					}
//				portais level 9
					else if (pixelAtual == 0xFF01DF18) {
						Portal PortalMp9paraMp2 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp9paraMp2");
						Game.entities.add(PortalMp9paraMp2);
					} else if (pixelAtual == 0xFF01DF17) {
						Portal PortalMp9paraMp6 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp9paraMp6");
						Game.entities.add(PortalMp9paraMp6);
					} else if (pixelAtual == 0xFF01DF15) {
						Portal PortalMp9paraMp8 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp9paraMp8");
						Game.entities.add(PortalMp9paraMp8);
					} else if (pixelAtual == 0xFF01DF16) {
						Portal PortalMp9paraMp10 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp9paraMp10");
						Game.entities.add(PortalMp9paraMp10);
					}
//				portais level 10
					else if (pixelAtual == 0xFF01DF19) {
						Portal PortalMp10paraMp9 = new Portal(xx * 16, yy * 16, 16, 16, Entity.Portal,
								"PortalMp10paraMp9");
						Game.entities.add(PortalMp10paraMp9);
					}
//----------------------------
//					placa level /1
					else if (pixelAtual == 0xFF8D8270) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Acima = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 1, 2);
						Game.entities.add(Acima);
					} else if (pixelAtual == 0xFF8D8271) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 1, 1);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D8272) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 esquerda = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 1, 3);
						Game.entities.add(esquerda);
					} else if (pixelAtual == 0xFF8D8273) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 1, 4);
						Game.entities.add(Abaixo);
					}
//					placa level /2
					else if (pixelAtual == 0xFF8D8274) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 2, 1);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D8275) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 2, 2);
						Game.entities.add(Abaixo);
					}
//					placa level /3
					else if (pixelAtual == 0xFF8D8276) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 3, 3);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D8277) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Acima = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 3, 2);
						Game.entities.add(Acima);
					} else if (pixelAtual == 0xFF8D8278) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 esquerda = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 3, 1);
						Game.entities.add(esquerda);
					}
//					placa level /4
					else if (pixelAtual == 0xFF8D8279) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 4, 1);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D827A) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Acima = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 4, 2);
						Game.entities.add(Acima);
					} else if (pixelAtual == 0xFF8D827B) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 4, 3);
						Game.entities.add(Abaixo);
					}
//					placa level /5
					else if (pixelAtual == 0xFF8D827C) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 5, 1);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D827D) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 5, 2);
						Game.entities.add(Abaixo);
					}
//					placa level /6
					else if (pixelAtual == 0xFF8D827E) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Acima = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 6, 2);
						Game.entities.add(Acima);
					} else if (pixelAtual == 0xFF8D8281) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 6, 3);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D8280) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 esquerda = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 6, 1);
						Game.entities.add(esquerda);
					} else if (pixelAtual == 0xFF8D827F) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 6, 4);
						Game.entities.add(Abaixo);
					}
//					placa level /7
					else if (pixelAtual == 0xFF8D8282) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 esquerda = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 7, 2);
						Game.entities.add(esquerda);
					} else if (pixelAtual == 0xFF8D8283) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 7, 1);
						Game.entities.add(Abaixo);
					}
//					placa level /8
					else if (pixelAtual == 0xFF8D8284) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 8, 2);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D8285) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Acima = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 8, 1);
						Game.entities.add(Acima);
					}
//					placa level /9
					else if (pixelAtual == 0xFF8D8286) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 9, 1);
						Game.entities.add(direita);
					} else if (pixelAtual == 0xFF8D8287) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Acima = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 9, 2);
						Game.entities.add(Acima);
					} else if (pixelAtual == 0xFF8D8288) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 esquerda = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 9, 3);
						Game.entities.add(esquerda);
					} else if (pixelAtual == 0xFF8D8289) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 Abaixo = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 9, 4);
						Game.entities.add(Abaixo);
					}
//					placa level /10
					else if (pixelAtual == 0xFF8D828A) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
						PlacasMapas1_10 direita = new PlacasMapas1_10(xx * 16, yy * 16, 16, 16, Entity.placa, 10, 1);
						Game.entities.add(direita);
					}
//----------------------------
					// Arvore
					else if (pixelAtual == 0xFFFFE970) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT1);
					} else if (pixelAtual == 0xFFFFE971) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT2);
					} else if (pixelAtual == 0xFFFFE972) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT3);
					} else if (pixelAtual == 0xFFFFE973) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT4);
					} else if (pixelAtual == 0xFFFFE974) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT5);
					} else if (pixelAtual == 0xFFFFE975) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT6);
					} else if (pixelAtual == 0xFFFFE976) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT7);
					} else if (pixelAtual == 0xFFFFE977) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT8);
					} else if (pixelAtual == 0xFFFFE978) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_TREE_PT9);
					}
//					Player
					else if (pixelAtual == 0XFF0026FF) {
						Game.player.setX(xx * 16);
						Game.player.setY(yy * 16);
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
					}
//					bot
					else if (pixelAtual == 0XFFF32FFF) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
//						BotPlayer Bot = new BotPlayer(xx * 16, yy * 16, 16, 16, Entity.BOT_LEFT_EN);
//						Game.entities.add(Bot);
					}
//					npc
					else if (pixelAtual == 0xFF0026B0) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						NPCGuarda gu = new NPCGuarda(xx * 16, yy * 16, 16, 16, Entity.NPCGuarda);
						Game.entities.add(gu);
					}
//					Enimigo
					else if (pixelAtual == 0xFFFF0000) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies01[qtEnemies01Map] = xx;
						yEnemies01[qtEnemies01Map] = yy;
						if (qtEnemies01 >= 0) {
							if (stop == false) {
								qtEnemies01++;
								qtEnemies01Map++;
								if (qtEnemies01 >= maxQtEnemies01) {
									stop = true;
									qtEnemies01 = 0;
								}
							}
						}
					} else if (pixelAtual == 0xFFFF0001) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies02[qtEnemies02Map] = xx;
						yEnemies02[qtEnemies02Map] = yy;
						if (qtEnemies02 >= 0) {
							if (stop2 == false) {
								qtEnemies02++;
								qtEnemies02Map++;
								if (qtEnemies02 >= maxQtEnemies02) {
									stop2 = true;
									qtEnemies02 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0002) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies03[qtEnemies03Map] = xx;
						yEnemies03[qtEnemies03Map] = yy;
						if (qtEnemies03 >= 0) {
							if (stop3 == false) {
								qtEnemies03++;
								qtEnemies03Map++;
								if (qtEnemies03 >= maxQtEnemies03) {
									stop3 = true;
									qtEnemies03 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0003) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies04[qtEnemies04Map] = xx;
						yEnemies04[qtEnemies04Map] = yy;
						if (qtEnemies04 >= 0) {
							if (stop4 == false) {
								qtEnemies04++;
								qtEnemies04Map++;
								if (qtEnemies04 >= maxQtEnemies04) {
									stop4 = true;
									qtEnemies04 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0004) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies05[qtEnemies05Map] = xx;
						yEnemies05[qtEnemies05Map] = yy;
						if (qtEnemies05 >= 0) {
							if (stop5 == false) {
								qtEnemies05++;
								qtEnemies05Map++;
								if (qtEnemies05 >= maxQtEnemies05) {
									stop5 = true;
									qtEnemies05 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0005) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies06[qtEnemies06Map] = xx;
						yEnemies06[qtEnemies06Map] = yy;
						if (qtEnemies06 >= 0) {
							if (stop6 == false) {
								qtEnemies06++;
								qtEnemies06Map++;
								if (qtEnemies06 >= maxQtEnemies06) {
									stop6 = true;
									qtEnemies06 = 0;
								}
							}
						}
					} else if (pixelAtual == 0xFFFF0006) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies07[qtEnemies07Map] = xx;
						yEnemies07[qtEnemies07Map] = yy;
						if (qtEnemies07 >= 0) {
							if (stop7 == false) {
								qtEnemies07++;
								qtEnemies07Map++;
								if (qtEnemies07 >= maxQtEnemies07) {
									stop7 = true;
									qtEnemies07 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0007) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies08[qtEnemies08Map] = xx;
						yEnemies08[qtEnemies08Map] = yy;
						if (qtEnemies08 >= 0) {
							if (stop8 == false) {
								qtEnemies08++;
								qtEnemies08Map++;
								if (qtEnemies08 >= maxQtEnemies08) {
									stop8 = true;
									qtEnemies08 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0008) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies09[qtEnemies09Map] = xx;
						yEnemies09[qtEnemies09Map] = yy;
						if (qtEnemies09 >= 0) {
							if (stop9 == false) {
								qtEnemies09++;
								qtEnemies09Map++;
								if (qtEnemies09 >= maxQtEnemies09) {
									stop9 = true;
									qtEnemies09 = 0;
								}
							}

						}
					} else if (pixelAtual == 0xFFFF0009) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_BASE_PATH);
						xEnemies10[qtEnemies10Map] = xx;
						yEnemies10[qtEnemies10Map] = yy;
						if (qtEnemies10 >= 0) {
							if (stop10 == false) {
								qtEnemies10++;
								qtEnemies10Map++;
								if (qtEnemies10 >= maxQtEnemies10) {
									stop10 = true;
									qtEnemies10 = 0;
								}
							}
						}
					}
//-----------------------------						
				}
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isfree(int xNext, int yNext) {
		int x1 = xNext / TILE_SIZE;
		int y1 = yNext / TILE_SIZE;

		int x2 = (xNext + TILE_SIZE - 1) / TILE_SIZE;
		int y2 = yNext / TILE_SIZE;

		int x3 = xNext / TILE_SIZE;
		int y3 = (yNext + TILE_SIZE - 1) / TILE_SIZE;

		int x4 = (xNext + TILE_SIZE - 1) / TILE_SIZE;
		int y4 = (yNext + TILE_SIZE - 1) / TILE_SIZE;

		return !((tiles[x1 + (y1 * World.WIDTH)] instanceof WallTile)
				|| (tiles[x2 + (y2 * World.WIDTH)] instanceof WallTile)
				|| (tiles[x3 + (y3 * World.WIDTH)] instanceof WallTile)
				|| (tiles[x4 + (y4 * World.WIDTH)] instanceof WallTile));
	}

	public static void restartGame(String level) {
		double qtxp = Game.player.xp, vida = Game.player.life, dano = Player.dano;
		Game.entities.clear();
		Game.enemies01.clear();
		Game.enemies02.clear();
		Game.enemies03.clear();
		Game.enemies04.clear();
		Game.enemies05.clear();
		Game.enemies06.clear();
		Game.enemies07.clear();
		Game.enemies08.clear();
		Game.enemies09.clear();
		Game.enemies10.clear();

		Game.entities = new ArrayList<Entity>();
		Game.spritesheet = new Spritesheet("/spritesheet.png");
		Game.spritesheetBlocos = new Spritesheet("/spritesheetBlocos.png");
		Game.spritesheetGuns = new Spritesheet("/spritesheetGuns.png");
		Game.spritesheetImoveis = new Spritesheet("/spritesheetImoveis.png");
		Game.spritesheetItens = new Spritesheet("/spritesheetItens.png");
		Game.spritesheetMobs = new Spritesheet("/spritesheetMobs.png");
		Game.spritesheetNPC = new Spritesheet("/spritesheetNPC.png");
		Game.spritesheetBossOrk = new Spritesheet("/spritesheetBossOrk.png");
		Game.spritesheetBossLisard = new Spritesheet("/spritesheetBossLisard.png");

		Game.player = new Player(0, 0, 16, 16, Game.spritesheet.getSprite(32, 0, 16, 16));

		Game.player.xp = qtxp;
		Game.player.life = vida;
		Player.dano = (int) dano;
		Game.entities.add(Game.player);
		Game.world = new World("/" + level);
		ZombieCreator.RespawMp("0");
		return;
	}

	public void render(Graphics g) {
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;

		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);

		for (int xx = xstart; xx <= xfinal; xx++) {
			for (int yy = ystart; yy <= yfinal; yy++) {
				if (xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(g);

			}
		}
	}
}
