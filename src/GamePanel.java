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
	Platforms platform;
	ObjectManager manager;
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		character = new Character(225, 200, 50, 50, 0, 0, true);
		platform = new Platforms(150, 450, 150, 50, 0, true);
		manager = new ObjectManager(character);
		
		manager.addObject(platform);
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		character.draw(g);
		platform.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//character.update(0.5);
		//platform.update(0.5);
		manager.update();
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
			character.speed = -5;
		} if (e.getKeyCode() == KeyEvent.VK_D) {
			character.speed = 5;
		} if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			character.yVel=-10;
			platform.yVel=-2;
			System.out.println("hi");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			character.speed=0;
	}
}
