import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Sword extends GameObject{
	ArrayList <Integer> pastX = new ArrayList<>();
	ArrayList <Integer> pastY = new ArrayList<>();

	public Sword(int x, int y, int width, int height, int health, boolean isAlive) {
		super(x, y, width, height, health, isAlive);
		
	}
	void update () {
		super.update();
	}
	void draw (Graphics g) {
		System.out.println("sword draw");
		g.drawImage(GamePanel.laserSword, x, y, width, height, null);
		if (pastX.size()<4) {
			pastX.add(x);
			pastY.add(y);
			} else {
				pastX.remove(0);
				pastY.remove(0);
			}
			for (int i = 0; i < pastX.size(); i++) {
				g.setColor(new Color(100, 100, 255, 70));
				g.drawImage(GamePanel.laserSword, pastX.get(i), pastY.get(i), width, height, null);
			}
	}
}
