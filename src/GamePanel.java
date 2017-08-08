import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	Character character;
	Level level;
	ObjectManager manager;
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		character = new Character(225, 200, 50, 50, 0, 0, true);
		manager = new ObjectManager(character);
		
		manager.addObject(level);
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, 700, 600);
		character.draw(g);
		level.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		character.update();
		manager.update();
		repaint();

		if (character.x < level.x){
			character.x+=4;
		}
		if ((character.x+50) > (level.x+600)){
			character.x-=4;
		}
		if (character.y < level.y){
			character.y+=4;
		}
		if ((character.y+50) > (level.y+475)){
			character.y-=4;
		}
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
