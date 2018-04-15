import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState;
	final int BONUS_LEVEL = 1;
	final int REGULAR_LEVEL = 2;
	final int HARD_LEVEL = 3;
	final int BOSS_LEVEL = 4;
	final int IMPOSSIBLE_LEVEL = 5;
	final int SPACE_LEVEL = 6;
	int currentLevel = REGULAR_LEVEL;
	Font title;
	Font directions;
	Font healthBar;
	Font scoreDisplay;
	Font G;
	Font A;
	Font M;
	Font E;
	Font O;
	Font V;
	Font E2;
	Font R;
	static Character character;
	public static Level level;
	static Sword sword;
	LevelDoor door1;
	LevelDoor door2;
	LevelDoor door3;
	LevelDoor door4;
	ObjectManager manager;
	public static BufferedImage laserSword;
	public static BufferedImage pixelBlood1;
	public static BufferedImage space;
	public static BufferedImage pixelSpace;

	public GamePanel() {
		currentState = MENU_STATE;
		manager = new ObjectManager();
		timer = new Timer(1000 / 60, this);
		title = new Font("Comic Sans", Font.BOLD, 50);
		directions = new Font("Arial", Font.BOLD, 25);
		healthBar = new Font("Comic Sans", Font.BOLD, 15);
		scoreDisplay = new Font("Comic Sans", Font.BOLD, 25);
		G = new Font("Hoefler", Font.BOLD, 100);
		A = new Font("Hoefler", Font.BOLD, 95);
		M = new Font("Hoefler", Font.BOLD, 105);
		E = new Font("Hoefler", Font.BOLD, 110);
		O = new Font("Hoefler", Font.BOLD, 90);
		V = new Font("Hoefler", Font.BOLD, 105);
		E2 = new Font("Hoefler", Font.BOLD, 110);
		R = new Font("Hoefler", Font.BOLD, 105);
		character = new Character(325, 275, 50, 50, 5, 5, 3, true);
		manager.addCharacter(character);
		sword = new Sword(character.x + 25, character.y + 25, 100, 100, 1, true);
		manager.addSword(sword);
		door1 = new LevelDoor(10, 255, 51, 70, 1, true);
		manager.addDoor(door1);
		door2 = new LevelDoor(639, 255, 51, 70, 1, true);
		manager.addDoor(door2);
		door3 = new LevelDoor(315, 10, 70, 51, 1, true);
		manager.addDoor(door3);
		door4 = new LevelDoor(315, 504, 70, 51, 1, true);
		manager.addDoor(door4);
		manager.addObject(level);
		try {
			laserSword = ImageIO.read(this.getClass().getResourceAsStream("lasersword.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pixelBlood1 = ImageIO.read(this.getClass().getResourceAsStream("pixelBlood1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			space = ImageIO.read(this.getClass().getResourceAsStream("space.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pixelSpace = ImageIO.read(this.getClass().getResourceAsStream("pixelSpace.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void startGame() {
		timer.start();
		level = manager.createLevel(20);
		manager.score = 0;
		currentState = GAME_STATE;
	}

	void updateMenuState() {
		
	}

	void updateGameState() {
		sword.update(character.x, character.y);
		manager.characterBoundaries(character, level);
		manager.update();
		manager.checkCollision();
		if (character.isAlive == false) {
			manager.purgeObjects();
			currentState = END_STATE;
		}
		
	}

	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 600);
		int random1 = new Random().nextInt(155);
		random1+=100;
		int random2 = new Random().nextInt(155);
		random2+=100;
		int random3 = new Random().nextInt(155);
		random3+=100;
		Color color = new Color(random1, random2, random3);
		g.setColor(color);
		Random rand = new Random();
		int randomX = rand.nextInt(10);
		randomX -= 5;
		int randomY = rand.nextInt(10);
		g.setFont(title);
		g.drawString("SPACE", 200 + randomX, 200 + randomY);
		g.setColor(Color.YELLOW);
		g.drawString("22,982,400 Seconds", 100, 100);
		g.drawString("SPACE", 200 + (randomX/2), 200 + (randomY/2));
		g.setFont(directions);
		g.drawString("in", 335, 130);
		g.drawString("Use the arrow keys to move", 40, 350);
		g.drawString("Use the spacebar to swing your sword", 100, 400);
	}

	void drawGameState(Graphics g) {
		g.fillRect(0, 0, 700, 600);
		level.draw(g);
		manager.drawDoors(g);
		character.draw(g);
		level.drawEnemy(g);
		g.setColor(Color.WHITE);
		g.setFont(healthBar);
		g.drawString("Health: " + character.health, character.x - 10, character.y - 10);
		g.setFont(scoreDisplay);
		g.drawString("Score: " + manager.score, 25, 35);
		sword.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 700, 600);
		g.setColor(Color.YELLOW);
		Random rand = new Random();
		int randomX = rand.nextInt(10);
		randomX -= 5;
		int randomY = rand.nextInt(10);
		randomY -= 5;
		int randomX1 = rand.nextInt(10);
		randomX1 -= 5;
		int randomY1 = rand.nextInt(10);
		randomY1 -= 5;
		int randomX2 = rand.nextInt(10);
		randomX2 -= 5;
		int randomY2 = rand.nextInt(10);
		randomY2 -= 5;
		int randomX3 = rand.nextInt(10);
		randomX3 -= 5;
		int randomY3 = rand.nextInt(10);
		randomY3 -= 5;
		int randomX4 = rand.nextInt(10);
		randomX4 -= 5;
		int randomY4 = rand.nextInt(10);
		randomY4 -= 5;
		int randomX5 = rand.nextInt(10);
		randomX5 -= 5;
		int randomY5 = rand.nextInt(10);
		randomY5 -= 5;
		int randomX6 = rand.nextInt(10);
		randomX6 -= 5;
		int randomY6 = rand.nextInt(10);
		randomY6 -= 5;
		int randomX7 = rand.nextInt(10);
		randomX7 -= 5;
		int randomY7 = rand.nextInt(10);
		randomY7 -= 5;
		int randomX8 = rand.nextInt(4);
		randomX8 -= 2;
		int randomY8 = rand.nextInt(4);
		randomY8 -= 2;
		g.setFont(G);
		g.drawString("G", 125 + randomX, 150 + randomY);
		g.setFont(A);
		g.drawString("A", 230 + randomX1, 155 + randomY1);
		g.setFont(M);
		g.drawString("M", 310 + randomX2, 145 + randomY2);
		g.setFont(E);
		g.drawString("E", 425 + randomX3, 155 + randomY3);
		g.setFont(O);
		g.drawString("O", 125 + randomX4, 255 + randomY4);
		g.setFont(V);
		g.drawString("V", 230 + randomX5, 255 + randomY5);
		g.setFont(E2);
		g.drawString("E", 335 + randomX6, 250 + randomY6);
		g.setFont(R);
		g.drawString("R", 415 + randomX7, 260 + randomY7);
		g.setFont(scoreDisplay);
		g.drawString("Score: " + manager.score, 260 + randomX8, 400 + randomY8);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
		System.out.println("draw");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		updateGameState();
		character.update();
		manager.characterBoundaries(character, level);
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Character.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Character.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Character.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Character.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			for (int i = 0; i < 10; i++) {
				sword.swing = true;
			}
		if (currentState == END_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				startGame();
			}
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (level.levelType != 6) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Character.right = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				Character.left = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Character.down = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Character.up = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			sword.swing = false;
		}
	}

}
