package com.jomuvi.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.jomuvi.world.World;

public class Menu {
	public static BufferedImage Menu = Game.imgMenu.getSprite(0, 0, 50, 50);

	public String[] options = { "Novo Jogo", "Carregar jogo", "Sair" };

	public int curretOpition = 0;
	public int IouD = 0;
	public int IouDTexto = 0;
	public int maxOpition = options.length - 1;
	public boolean up, down, enter;

	public static boolean pausa = false;
	public static boolean saveExists = false;
	public static boolean saveGame = false;

	public void tick() {
		File file = new File("save.txt");
		if (file.exists()) {
			saveExists = true;
		} else {
			saveExists = false;
		}
		if (up) {
			up = false;
			curretOpition--;

			if (curretOpition < 0) {
				curretOpition = maxOpition;
			}
		}
		if (down) {
			down = false;
			curretOpition++;
			if (curretOpition > maxOpition) {
				curretOpition = 0;
			}
		}
		if (enter) {
			enter = false;
			if (options[curretOpition] == "Novo Jogo" || options[curretOpition] == "Continuar") {
				if (IouDTexto == 0) {
					file = new File("save.txt");
					file.delete();
					Game.gameState = "NORMAL";
					Game.modoDeJogo = "CUTSCENE";
					pausa = false;
				} else if (IouDTexto == 1) {
					file = new File("save.txt");
					file.delete();
					Game.gameState = "NORMAL";
					Game.modoDeJogo = "NORMAL";
					pausa = false;
				}

			} else if (options[curretOpition] == "Carregar jogo" || options[curretOpition] == "Salvar jogo") {
				if (IouD == 0) {
					file = new File("save.txt");
					if (file.exists()) {
						String saver = LoadGame(10);
						applySave(saver);
					}
				} else if (IouD == 1) {
					Game.saveGame = true;
				}

			} else if (options[curretOpition] == "Sair") {
				System.exit(1);
			}
		}
	}

	public static void applySave(String str) {
		String[] spl = str.split("/");
		for (int i = 0; i < spl.length; i++) {
			String[] spl2 = spl[i].split(":");
			switch (spl2[0]) {
			case "level":
				World.restartGame(World.NomesMapas[Integer.parseInt(spl2[1])]);
				Game.gameState = "NORMAL";
				pausa = false;
				break;
			case "vida":
				Game.player.life = Integer.parseInt(spl2[1]);
				break;
			case "maxLife":
				Game.player.maxLife = Integer.parseInt(spl2[1]);
				break;
			case "xp":
				Game.player.xp = Integer.parseInt(spl2[1]);
				break;
			case "maxXp":
				Game.player.maxXp = Integer.parseInt(spl2[1]);
				break;
			}
		}
	}

	public static String LoadGame(int encode) {
		String line = "";
		File file = new File("save.txt");
		if (file.exists()) {
			try {
				String singleLine = null;
				BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
				try {
					while ((singleLine = reader.readLine()) != null) {
						String[] trans = singleLine.split(":");
						System.out.println(trans[1].toCharArray());
						char[] val = trans[1].toCharArray();
						trans[1] = "";
						for (int i = 0; i < val.length; i++) {
							val[i] -= encode;
							trans[1] += val[i];
						}
						line += trans[0];
						line += ":";
						line += trans[1];
						line += "/";

					}
				} catch (IOException e) {
				}

			} catch (FileNotFoundException e) {
			}

		}
		return line;
	}

	public static void saveGame(String[] val1, int[] val2, int encode) {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("save.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < val1.length; i++) {
			String current = val1[i];
			current += ":";
			char[] value = Integer.toString(val2[i]).toCharArray();
			for (int n = 0; n < value.length; n++) {
				value[n] += encode;
				current += value[n];
			}
			try {
				write.write(current);
				if (i < val1.length - 1)
					;
				write.newLine();

			} catch (IOException e) {
			}
		}
		try {
			write.flush();
			write.close();
		} catch (IOException e) {
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		g.drawImage(Menu, 0, 0, Game.WIDTH, Game.HEIGHT, null);
//		sombra 
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fillRect((Game.WIDTH / 3) + 10, 5, 110, 110);
//		--------
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.BOLD, 16));
		g.drawString("Survivor", (Game.WIDTH / 3) + 20, 20);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("RPG", (Game.WIDTH / 2) + 25, (Game.HEIGHT / 2) - 100);

//	Opições
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		if (!pausa) {
			IouDTexto = 0;
			g.drawString("Novo Jogo", (Game.WIDTH / 3) + 20, 45);
		} else {
			IouDTexto = 1;
			g.drawString("Continuar", (Game.WIDTH / 3) + 20, 45);
		}
		if (!pausa) {
			IouD = 0;
			g.drawString("Carregar jogo", (Game.WIDTH / 3) + 20, 65);
		} else {
			IouD = 1;
			g.drawString("Salvar jogo", (Game.WIDTH / 3) + 20, 65);
		}
		g.drawString("Sair", (Game.WIDTH / 3) + 20, 85);

// escolha
		g.setColor(new Color(219, 219, 112));
		g.setFont(new Font("arial", Font.BOLD, 12));

		if (options[curretOpition] == "Novo Jogo") {
			g.drawString(">", (Game.WIDTH / 3) + 13, 47);
		} else if (options[curretOpition] == "Carregar jogo") {
			g.drawString(">", (Game.WIDTH / 3) + 13, 67);
		} else if (options[curretOpition] == "Sair") {
			g.drawString(">", (Game.WIDTH / 3) + 13, 87);
		}
	}
}
