import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = GAME_STATE;
	final int BONUS_LEVEL = 1;
	final int REGULAR_LEVEL = 2;
	final int HARD_LEVEL = 3;
	final int BOSS_LEVEL = 4;
	final int IMPOSSIBLE_LEVEL = 5;
	final int SPACE_LEVEL = 6;
	int currentLevel = REGULAR_LEVEL;
	Font title;
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
		manager = new ObjectManager();
		timer = new Timer(1000 / 60, this);
		title = new Font("W", Font.PLAIN, 50);
		character = new Character(325, 275, 50, 50, 4, 4, 3, true);
		manager.addCharacter(character);
		sword = new Sword(character.x, character.y, 100, 100, 1, true);
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
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.checkCollision();
		if (character.isAlive == false) {
			currentState = END_STATE;
			// manager.reset();
			// character = new Character(225, 200, 50, 50, 0, 0, 3, true);
			// manager.addObject(character);
		}

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 600);
		g.setColor(Color.YELLOW);
		g.setFont(title);
		g.drawString("Idk a name for this game yet", 0, 100);

	}

	void drawGameState(Graphics g) {
		g.fillRect(0, 0, 700, 600);
		level.draw(g);
		manager.drawDoors(g);
		character.draw(g);
		// System.out.println("update");
		level.drawEnemy(g);
		sword.update(character.x, character.y);
		sword.draw(g);
	}

	void drawEndState(Graphics g) {

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		character.update();
		manager.characterBoundaries(character, level);
		manager.checkCollision();
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
			System.out.println("right true");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Character.left = true;
			System.out.println("left true");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Character.down = true;
			System.out.println("down true");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Character.up = true;
			System.out.println("up true");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			for (int i = 0; i < 10; i++) {
				sword.update(character.x, character.y);
				sword.swing = true;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (level.levelType != 6) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Character.right = false;
				System.out.println("right false");
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				Character.left = false;
				System.out.println("left false");
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Character.down = false;
				System.out.println("down false");
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Character.up = false;
				System.out.println("up false");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			sword.swing = false;
		}
	}

}
