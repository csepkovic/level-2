import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Sword extends GameObject {
	ArrayList<Integer> pastX = new ArrayList<>();
	ArrayList<Integer> pastY = new ArrayList<>();
	boolean swing = false;

	public Sword(int x, int y, int width, int height, int health, boolean isAlive) {
		super(x, y, width, height, health, isAlive);
	}

	void update(int X, int Y) {
		super.update();
		x = X + 25;
		y = Y + 25;
	}

	double slice = 0.1;

	void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (swing == true) {
			slice += 0.1;
			System.out.println(slice);
		}
		g2d.rotate(slice, x, y);
		g2d.drawImage(GamePanel.laserSword, x, y, width, height, null);
		if (slice >= 6.2) {
			slice = 0;
		}
	}

	void attackDownLeft(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(.5, x, y);
		g.drawImage(GamePanel.laserSword, x, y, width, height, null);
	}
}
