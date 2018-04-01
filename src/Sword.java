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

	int cX = 0;
	int cY = 0;
	int cW = 0;
	int cH = 0;

	void update(int X, int Y) {
		// super.update();
		collisionBox.setBounds(x + cX, y + cY, width + cW, height + cH);
		x = X + 25;
		y = Y + 25;
	}

	double slice = 0;

	void draw(Graphics g) {
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		if (swing == true) {
			slice += 0.1;
			if (slice >= 0 && slice <= 1.6) {
				if (slice < 0.9) {
					cX -= 5;
					cY += 5;
					cW -= 4;
				} else {
					cX -= 9;
					cY -= 5;
					cW += 6;
				}
			} else if (slice >= 3.3 && slice <= 4.7) {
				if (slice < 4.2) {
					cX += 9;
					cY -= 5;
					cW -= 4;
				} else {
					cX += 5;
					cY += 5;
					cW += 6;
				}
			}
			if (slice >= 1.7 && slice <= 3.0) {
				if (slice < 2.4) {
					cX -= 5;
					cY -= 7;
					cH -= 5;
				} else {
					cX += 5;
					cY -= 9;
					cH += 5;
				}
			} else if (slice >= 4.9 && slice < 6.2) {
				if (slice < 5.6) {
					cX += 4;
					cY += 10;
					cH -= 5;
				} else {
					cX -= 4;
					cY += 6;
					cH += 5;
				}
			}
		}
		g2d.rotate(slice, x, y);
		g2d.drawImage(GamePanel.laserSword, x, y, width, height, null);
		if (slice >= 6.2) {
			slice = 0;
			cX = 0;
			cY = 0;
			cW = 0;
			cH = 0;
		}

	}
}
