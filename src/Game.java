import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Game {
	JFrame frame;
	GamePanel panel;
	static int width;
	static int height;
	private static final String UP = "up";
	private static final String DOWN = "udown";
	private static final String LEFT = "left";
	private static final String RIGHT = "right";
	public Game(int width, int height) {
		frame = new JFrame("Game");
		panel = new GamePanel();
		Game.width = width;
		Game.height = height;
		createUI();
	}
	void createUI(){
		frame.add(panel);
		//frame.addKeyListener(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
		frame.addKeyListener(panel);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Game game = new Game(700, 600);
			}
		});
	}
}



