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
		panel.addKeyListener(panel);
		ActionMap actionMap = panel.getActionMap();
	      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
	      InputMap inputMap = panel.getInputMap(condition);

	      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), UP);
	      actionMap.put(UP, new UpAction());
	      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), DOWN);
	      actionMap.put(DOWN, new DownAction());
	      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), LEFT);
	      actionMap.put(LEFT, new LeftAction());
	      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), RIGHT);
	      actionMap.put(RIGHT, new RightAction());
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
	@SuppressWarnings("serial")
	class UpAction extends AbstractAction {
	   @Override
	   public void actionPerformed(ActionEvent arg0) {
	      Character.up=true;
	      Character.down=false;
	      System.out.println("up");
	   }
	}
	@SuppressWarnings("serial")
	class DownAction extends AbstractAction {
	   @Override
	   public void actionPerformed(ActionEvent arg0) {
	      Character.down=true;
	      Character.up=false;
	      System.out.println("down");
	   }
	}
	@SuppressWarnings("serial")
	class LeftAction extends AbstractAction {
	   @Override
	   public void actionPerformed(ActionEvent arg0) {
	      Character.left=true;
	      Character.right=false;
	      System.out.println("left");
	   }
	}
	@SuppressWarnings("serial")
	class RightAction extends AbstractAction {
	   @Override
	   public void actionPerformed(ActionEvent arg0) {
	      Character.right=true;
	      Character.left=false;
	      System.out.println("right");
	   }
	}
	
}



