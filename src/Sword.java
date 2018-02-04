import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Sword extends GameObject{
	ArrayList <Integer> pastX = new ArrayList<>();
	ArrayList <Integer> pastY = new ArrayList<>();

	public Sword(int x, int y, int width, int height, int health, boolean isAlive) {
		super(x, y, width, height, health, isAlive);
	}
	void update (int X, int Y) {
		super.update();
		x=X-20;
		y=Y-20;
		System.out.println("sword move");
//		if (pastX.size()<4) {
//			pastX.add(x);
//			pastY.add(y);
//			} else {
//				pastX.remove(0);
//				pastY.remove(0);
//			}
	}
	void draw (Graphics g) {
		
		g.drawImage(GamePanel.laserSword, x, y, width, height, null);
//		if (pastX.size()<4) {
//			for (int i = 0; i < pastX.size(); i++) {
//				g.setColor(new Color(100, 100, 255, 70));
//				g.drawImage(GamePanel.laserSword, pastX.get(i), pastY.get(i), width, height, null);
//			}
//	}
	}
}
