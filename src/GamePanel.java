import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
	int currentState = GAME_STATE;
	Font title;
	Character character;
	Level level;
	LevelDoor door1;
	LevelDoor door2;
	LevelDoor door3;
	LevelDoor door4;
	ObjectManager manager;
	public static BufferedImage pixelBlood1;
	public static BufferedImage space;
	public static BufferedImage pixelSpace;

	public GamePanel() {
		manager = new ObjectManager();
		timer = new Timer(1000 / 60, this);
		title = new Font("W", Font.PLAIN, 50);
		character = new Character(225, 200, 50, 50, 4, 4, 3, true);
		manager.addCharacter(character);
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
		int random = new Random().nextInt(100);
		level = manager.createLevel(random);
		
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.checkCollision();
		if (character.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			character = new Character(225, 200, 50, 50, 0, 0, 3, true);
			manager.addObject(character);
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
		// if (character.x < level.x){
		// character.x+=4;
		// }
		// if ((character.x+50) > (level.x+600)){
		// character.x-=4;
		// }
		// if (character.y < level.y){
		// character.y+=4;
		// }
		// if ((character.y+50) > (level.y+475)){
		// character.y-=4;
		// }

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
		// TODO Auto-generated method stub
//		if (e.getKeyCode() == KeyEvent.VK_A) {
//			character.left = true;
//			System.out.println("left true");
//		}
//		if (e.getKeyCode() == KeyEvent.VK_D) {
//			character.right = true;
//			System.out.println("right true");
//		}
//		if (e.getKeyCode() == KeyEvent.VK_W) {
//			character.up = true;
//			System.out.println("up true");
//		}
//		if (e.getKeyCode() == KeyEvent.VK_S) {
//			character.down = true;
//			System.out.println("down true");
//		}
//		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			if (currentState < 2) {
//				currentState++;
//			} else {
//				currentState = 0;
//			}
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Character.right = false;
			System.out.println("right false");
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Character.left = false;
			System.out.println("left false");
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Character.down = false;
			System.out.println("down false");
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Character.up = false;
			System.out.println("up false");
		}
	}

}
