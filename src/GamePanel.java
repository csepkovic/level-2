import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font title;
	Character character;
	Level level;
	ObjectManager manager;
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		title = new Font ("W", Font.PLAIN, 50);
		character = new Character(225, 200, 50, 50, 0, 0, 3, true);
		manager = new ObjectManager(character);
		manager.addObject(level);
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
		if (character.isAlive==false) {
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
			g.drawString("OwO", 100, 100); 
	}

	void drawGameState(Graphics g) {
		g.fillRect(0, 0, 700, 600);
		character.draw(g);
		level.draw(g);
		manager.door1.draw(g);
		manager.door2.draw(g);
		manager.door3.draw(g);
		manager.door4.draw(g);
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
//		if (character.x < level.x){
//			character.x+=4;
//		}
//		if ((character.x+50) > (level.x+600)){
//			character.x-=4;
//		}
//		if (character.y < level.y){
//			character.y+=4;
//		}
//		if ((character.y+50) > (level.y+475)){
//			character.y-=4;
//		}
		
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
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_A) {
			character.xSpeed-=4;
		} if (e.getKeyCode() == KeyEvent.VK_D) {
			character.xSpeed+=4;
			
		} if (e.getKeyCode() == KeyEvent.VK_W) {
			character.ySpeed-=4;
			
		} if (e.getKeyCode() == KeyEvent.VK_S) {
			character.ySpeed+=4;
			
		} if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState<2){
			currentState++;
			} else {
				currentState=0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_D) {
			character.xSpeed-=4;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			character.xSpeed+=4;
		} if (e.getKeyCode() == KeyEvent.VK_S) {
			character.ySpeed-=4;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			character.ySpeed+=4;
		}
	}
}
