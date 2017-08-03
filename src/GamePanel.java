
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

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		character = new Character(225, 375, 50, 50, 0, 0.5, 0);
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		character.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		character.update();
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
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			character.speed = 5;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			character.yVel=-10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			character.speed=0;
	}
}
