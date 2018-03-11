import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Sword extends GameObject {
	ArrayList<Integer> pastX = new ArrayList<>();
	ArrayList<Integer> pastY = new ArrayList<>();
	boolean swing = false;

	public Sword(int x, int y, int width, int height, int health, boolean isAlive) {
		super(x, y, width, height, health, isAlive);
	}

	void update(int X, int Y) {
//		super.update();
		collisionBox.setBounds(x,  y ,  width, height);

		x = X + 25;
		y = Y + 25;
	}

	double slice = 0.1;

	void draw(Graphics g) {
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		if (swing == true) {
			slice += 0.1;
		}
		g2d.rotate(slice, x, y);
		g2d.drawImage(GamePanel.laserSword, x, y, width, height, null);
		super.draw(g);
		if (slice >= 6.2) {
			slice = 0;
		}
		
	}
}
