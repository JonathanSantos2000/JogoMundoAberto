package com.jomuvi.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.jomuvi.entities.BotPlayer;
import com.jomuvi.entities.BulletShoot;
import com.jomuvi.entities.Entity;
import com.jomuvi.entities.FireBallShoot;
import com.jomuvi.entities.Player;
import com.jomuvi.entities.enemies.Enemy01;
import com.jomuvi.entities.enemies.Enemy02;
import com.jomuvi.entities.enemies.Enemy03;
import com.jomuvi.entities.enemies.Enemy04;
import com.jomuvi.entities.enemies.Enemy05;
import com.jomuvi.entities.enemies.Enemy06;
import com.jomuvi.entities.enemies.Enemy07;
import com.jomuvi.entities.enemies.Enemy08;
import com.jomuvi.entities.enemies.Enemy09;
import com.jomuvi.entities.enemies.Enemy10;
import com.jomuvi.entities.npc.NPCGuarda;
import com.jomuvi.entities.npc.NPCStoreArmer;
import com.jomuvi.entities.npc.NPCStoreMedico;
import com.jomuvi.entities.store.Store_Drug;
import com.jomuvi.entities.store.Store_Guns;
import com.jomuvi.graficos.Inventario;
import com.jomuvi.graficos.ItensArmer;
import com.jomuvi.graficos.ItensMunicao;
import com.jomuvi.graficos.ItensPocoes;
import com.jomuvi.graficos.ShopArm;
import com.jomuvi.graficos.ShopPotions;
import com.jomuvi.graficos.Spritesheet;
import com.jomuvi.graficos.Transicao;
import com.jomuvi.graficos.UI;
import com.jomuvi.world.World;
import com.jomuvi.world.ZombieCreator;

public class Game extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;

	private boolean restarGame = false;

	public static final int WIDTH = 340;
	public static final int HEIGHT = 260;
	public static final int SCALE = 3;

	private BufferedImage image;

	public static List<Entity> entities;
	public static List<Enemy01> enemies01;
	public static List<Enemy02> enemies02;
	public static List<Enemy03> enemies03;
	public static List<Enemy04> enemies04;
	public static List<Enemy05> enemies05;
	public static List<Enemy06> enemies06;
	public static List<Enemy07> enemies07;
	public static List<Enemy08> enemies08;
	public static List<Enemy09> enemies09;
	public static List<Enemy10> enemies10;

	public static List<BulletShoot> Bullets;
	public static List<FireBallShoot> fireBall;
	public static int[] miniMapaPixels;
	// Spritesheet
	public static Spritesheet spritesheet;
	public static Spritesheet numerosInventario;
	public static Spritesheet selecionado;
	public static Spritesheet spritesheetBlocos;
	public static Spritesheet spritesheetGuns;
	public static Spritesheet spritesheetImoveis;
	public static Spritesheet spritesheetItens;
	public static Spritesheet spritesheetMobs;
	public static Spritesheet spritesheetNPC;
	public static Spritesheet spritesheetBossOrk;
	public static Spritesheet spritesheetBossLisard;
	public static Spritesheet spritesheetBossSlime;
	public static Spritesheet spritesheetImoveisFastRavel;
	public static Spritesheet spritesheetBlocosPonte;
	public static Spritesheet spritesheetPlacasLvMapas;
	public static Spritesheet BarraRapida;
	public static Spritesheet loadingfloresta;
	// Planos de fundo

	public static Spritesheet imgMenu;
	public static Player player;

	// ------
	public static NPCGuarda guarison;
	public static World world;
	public static Inventario inven;
	public static ItensPocoes invenPotions;
	public static ItensArmer invenArmer;
	public static ItensMunicao invenMuni;
	public static Drops drop;
	public static verificarItens verItens;

	public static Store_Drug storesDrug;
	public static Store_Guns storesGuns;

	public static ZombieCreator creator;
	public static SistemasDeMoedas SDM;

	public static int CUR_LEVEL = 1;
	public static String modoDeJogo = "NORMAL";
	public static Boolean RespawMobs = false;
	public static UI ui;
	public static Random rand;
	public static String gameState = "MENU";
	public static Menu menu;
	public static Transicao transi;
	public static boolean saveGame = false, canWalk = true, canStop = true;
	public static boolean ShowInventario = false;
	public static boolean ShowUI = true, NextSomeNPC = false;

// Variaveis loja farmacia

	// mostrar as poções
	public static boolean ShowPotion = false, ShowArmer = false;
	// Comprar itens ou vender
	public static boolean BuyItem = false;
	public static boolean SoldItem = false;
//	--------------------------------------------
	public static ShopPotions potion;
	public static ShopArm armer;

	// ----------

	public static BufferedImage minimapa;

	public Game() {
		rand = new Random();
		addKeyListener(this);
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		initFrame();

		// Iniciando objetos
		ui = new UI();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		entities = new ArrayList<Entity>();
		enemies01 = new ArrayList<Enemy01>();
		enemies02 = new ArrayList<Enemy02>();
		enemies03 = new ArrayList<Enemy03>();
		enemies04 = new ArrayList<Enemy04>();
		enemies05 = new ArrayList<Enemy05>();
		enemies06 = new ArrayList<Enemy06>();
		enemies07 = new ArrayList<Enemy07>();
		enemies08 = new ArrayList<Enemy08>();
		enemies09 = new ArrayList<Enemy09>();
		enemies10 = new ArrayList<Enemy10>();
		// Powers
		Bullets = new ArrayList<BulletShoot>();
		fireBall = new ArrayList<FireBallShoot>();
		// Planos de fundo
		// Menu
		imgMenu = new Spritesheet("/Menu.png");
		// Fim Planos de fundo

		// Spritesheet
		spritesheet = new Spritesheet("/spritesheet.png");
		spritesheetBlocos = new Spritesheet("/spritesheetBlocos.png");
		spritesheetGuns = new Spritesheet("/spritesheetGuns.png");
		spritesheetImoveis = new Spritesheet("/spritesheetImoveis.png");
		spritesheetItens = new Spritesheet("/spritesheetItens.png");
		spritesheetMobs = new Spritesheet("/spritesheetMobs.png");
		spritesheetNPC = new Spritesheet("/spritesheetNPC.png");
		spritesheetBossOrk = new Spritesheet("/spritesheetBossOrk.png");
		spritesheetBossLisard = new Spritesheet("/spritesheetBossLisard.png");
		spritesheetBossSlime = new Spritesheet("/spritesheetBossSlime.png");
		numerosInventario = new Spritesheet("/numerosInventario.png");
		selecionado = new Spritesheet("/selecionado.png");
		spritesheetImoveisFastRavel = new Spritesheet("/spritesheetImoveisFastRavel.png");
		spritesheetBlocosPonte = new Spritesheet("/mapasDoJogo/Blocos/spritesheetBlocosPonte.png");
		spritesheetPlacasLvMapas = new Spritesheet("/mapasDoJogo/Blocos/spritesheetPlacasLvMapas.png");
		BarraRapida = new Spritesheet("/BarraRapida.png");
		loadingfloresta = new Spritesheet("/loadingfloresta.png");
		// Fim Spritesheet

		player = new Player(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		entities.add(player);

		world = new World("/mapasDoJogo/Cidade.png");
		minimapa = new BufferedImage(World.WIDTH, World.HEIGHT, BufferedImage.TYPE_INT_RGB);

		miniMapaPixels = ((DataBufferInt) minimapa.getRaster().getDataBuffer()).getData();
		creator = new ZombieCreator();
		inven = new Inventario();
		invenPotions = new ItensPocoes();
		invenArmer = new ItensArmer();
		invenMuni = new ItensMunicao();

		potion = new ShopPotions();
		armer = new ShopArm();

		drop = new Drops();
		verItens= new verificarItens();
		SDM = new SistemasDeMoedas();
		menu = new Menu();
		transi = new Transicao();
	}

	public void initFrame() {
		frame = new JFrame("Survivor rpg");
		frame.add(this);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();

	}

	public synchronized void stop() {

	}

	public static void main(String arg[]) {
		Game game = new Game();
		game.start();
	}

	public void tick() {
		ui.tick();
		if (gameState == "NORMAL") {
			this.restarGame = false;
			if (RespawMobs == true) {
				creator.tick();
			}
			if (NextSomeNPC || ShowInventario) {
				ShowUI = false;
			} else {
				ShowUI = true;
			}
			armer.tick();
			potion.tick();
			inven.tick();
			verItens.tick();
			
			for (int i = 0; i < entities.size(); i++) {
				Entity e = entities.get(i);
				e.tick();
			}
			for (int i = 0; i < Bullets.size(); i++) {
				Bullets.get(i).tick();
			}
			for (int i = 0; i < fireBall.size(); i++) {
				fireBall.get(i).tick();
			}
			if (Game.player.xp > Game.player.maxXp)
				Drops.VerificarNivelXP();
		} else if (gameState == "GAME_OVER") {
			if (restarGame && gameState == "GAME_OVER") {
				Game.RespawMobs = false;
				this.restarGame = false;
				Game.gameState = "NORMAL";
				String newWorld = "mapasDoJogo/Cidade.png";
				World.restartGame(newWorld);
			}
		} else if (gameState == "MENU") {
			if (Game.saveGame) {
				Game.saveGame = false;
				String[] opt1 = { "level", "vida", "maxLife", "xp", "maxXp" };

				int[] opt2 = { Game.CUR_LEVEL, (int) player.life, (int) player.maxLife, (int) player.xp,
						(int) player.maxXp };
				Menu.saveGame(opt1, opt2, 10);
			}
//			Sound.music.stop();
//			Sound.musicMenu.loop();
			menu.tick();
		} else if (gameState == "TRASICAO") {
			transi.tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//
		world.render(g);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		for (int i = 0; i < Bullets.size(); i++) {
			Bullets.get(i).render(g);
		}
		for (int i = 0; i < fireBall.size(); i++) {
			fireBall.get(i).render(g);
		}
		ui.render(g);
		if (ShowInventario)
			inven.render(g);
		if (ShowPotion)
			potion.render(g);
		if (ShowArmer)
			armer.render(g);

		// ____________
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height, null);
		bs.show();
	}

	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		@SuppressWarnings("unused")
		int frames = 0;
		double timer = System.currentTimeMillis();
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if (System.currentTimeMillis() - timer >= 1000) {
//				System.out.println("FPS: " + frames); 
				frames = 0;
				timer += 1000;
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (modoDeJogo == "NORMAL" && canWalk)
				player.Right = true;
			if (ShowPotion) {
				potion.right = true;
			}
			if (ShowArmer) {
				armer.right = true;
			}
			if (ShowInventario) {
				inven.right = true;
			}

		}
//		
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (modoDeJogo == "NORMAL" && canWalk)
				player.Left = true;
			if (ShowPotion) {
				potion.left = true;
			}
			if (ShowArmer) {
				armer.left = true;
			}
			if (ShowInventario) {
				inven.left = true;
			}
		}
//		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (modoDeJogo == "NORMAL" && canWalk)
				player.Up = true;

			if (gameState == "MENU") {
				menu.up = true;
			}
			if (ShowPotion) {
				potion.up = true;
			}
			if (ShowArmer) {
				armer.up = true;
			}
			if (ShowInventario) {
				inven.up = true;
			}
		}
//		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (modoDeJogo == "NORMAL" && canWalk)
				player.Down = true;

			if (gameState == "MENU") {
				menu.down = true;
			}
			if (ShowPotion) {
				potion.down = true;
			}
			if (ShowArmer) {
				armer.down = true;
			}
			if (ShowInventario) {
				inven.down = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (ShowInventario) {
				inven.A = true;
			}
			if (ShowArmer) {
				armer.A = true;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (ShowInventario) {
				inven.D = true;
			}
			if (ShowArmer) {
				armer.D = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.restarGame = true;
			if (gameState == "MENU") {
				menu.enter = true;
			}
			if (modoDeJogo == "CUTSCENE") {
				ui.enter = true;
			}
			if (ShowInventario) {
				inven.enter = true;
			}
			// Loja medicines
			if (gameState == "NORMAL") {
				if (NextSomeNPC) {
					if (NPCStoreMedico.isShowTexto()) {
						ShowUI = false;
						ShowPotion = true;
						canWalk = false;
						canStop = false;
					}
					if (ShopPotions.Pagar) {
						ShopPotions.Pagar = false;
						if (ShopPotions.comprado) {
							ShopPotions.comprado = false;
						} else if (ShopPotions.semdinheiro) {
							ShopPotions.semdinheiro = false;
						}
					}
					if (NPCStoreArmer.isShowTexto()) {
						ShowUI = false;
						ShowArmer = true;
						canWalk = false;
						canStop = false;
					}

				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (gameState == "NORMAL" && canStop) {
				gameState = "MENU";
				Menu.pausa = true;
			} else if (menu.IouDTexto == 1) {
				gameState = "NORMAL";
				Menu.pausa = false;
			}
			if (ShowInventario) {
				ShowUI = true;
				ShowInventario = false;
				canWalk = true;
				canStop = true;
			}
			if (ShowPotion) {
				ShowPotion = false;
				ShowUI = true;
				canWalk = true;
				canStop = true;
			}
			if (ShowArmer) {
				ShowArmer = false;
				ShowUI = true;
				canWalk = true;
				canStop = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (modoDeJogo == "NORMAL" && !ShowInventario) {
				player.shoot = true;
				BotPlayer.shoot = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_E) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (!ShowInventario) {
					ShowInventario = true;
					ShowUI = false;
					canWalk = false;
					canStop = false;
				} else {
					ShowInventario = false;
				}
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_C) {
			if (ShowPotion) {
				potion.buy = true;
			}
			if (ShowArmer) {
				armer.buy = true;
			}
		}
		// ------
		if (e.getKeyCode() == KeyEvent.VK_V) {
			if (ShowPotion) {
				potion.sell = true;
			}
		}
		// -----
		if (e.getKeyCode() == KeyEvent.VK_I) {
			if (ShowInventario) {
				inven.curretInf = 0;
				if (!inven.ShowInfo) {
					inven.ShowInfo = true;
				} else {
					inven.ShowInfo = false;
				}
			}
		}
		// --
		if (e.getKeyCode() == KeyEvent.VK_ADD) {
			if (ShowInventario) {
				if (inven.ShowInfo) {
					if (inven.curretInf < 2)
						inven.curretInf++;
					else
						inven.curretInf = 0;
				}
			}

		}
		// --
		if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
			if (ShowInventario) {
				if (inven.ShowInfo) {
					if (inven.curretInf > 0)
						inven.curretInf--;
					else
						inven.curretInf = 2;
				}
			}
		}

		// -----

		if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (Game.inven.ItensNoInventarioRapido[0] != null && Game.player.life < Game.player.maxLife && !ShowInventario) {
					
					Game.invenPotions.usarItem(0);
				}
			}
			if (ShowInventario) {
				verItens.one = true;
				ui.showFastBar = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (Game.inven.ItensNoInventarioRapido[1] != null && Game.player.life < Game.player.maxLife && !ShowInventario) {
					Game.invenPotions.usarItem(1);
				}
			}
			if (ShowInventario) {
				verItens.two = true;
				ui.showFastBar = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (Game.inven.ItensNoInventarioRapido[2] != null && Game.player.life < Game.player.maxLife && !ShowInventario) {
					Game.invenPotions.usarItem(2);
				}
			}
			if (ShowInventario) {
				verItens.three = true;
				ui.showFastBar = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (Game.inven.ItensNoInventarioRapido[3] != null && Game.player.life < Game.player.maxLife && !ShowInventario) {
					Game.invenPotions.usarItem(3);
				}
			}
			if (ShowInventario) {
				verItens.four = true;
				ui.showFastBar = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (Game.inven.ItensNoInventarioRapido[4] != null && Game.player.life < Game.player.maxLife && !ShowInventario) {
					Game.invenPotions.usarItem(4);
				}
			}
			if (ShowInventario) {
				verItens.five = true;
				ui.showFastBar = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
			if (gameState == "NORMAL" && modoDeJogo == "NORMAL") {
				if (Game.inven.ItensNoInventarioRapido[5] != null && Game.player.life < Game.player.maxLife && !ShowInventario) {
					Game.invenPotions.usarItem(5);
				}
			}
			if (ShowInventario) {
				verItens.six = true;
				ui.showFastBar = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.Right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.Left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.Up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.Down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {

		}
		if (e.getKeyCode() == KeyEvent.VK_V) {

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
