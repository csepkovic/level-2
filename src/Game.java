import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game {
	JFrame frame;
	GamePanel panel;
	static int width;
	static int height;
	public Game(int width, int height) {
		frame = new JFrame("Game");
		panel = new GamePanel();
		Game.width = width;
		Game.height = height;
		createUI();
	}
	void createUI(){
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
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



