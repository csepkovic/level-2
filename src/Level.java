import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Level extends GameObject {
	int levelType;

	public Level(int x, int y, int width, int height, int health, boolean isAlive, int levelType) {
		super(x, y, width, height, health, isAlive);
		this.levelType = levelType;
	}
	Enemy1 enemy;
	Enemy1 enemy1;
	Enemy1 enemy2;
	Enemy1 enemy3;
	int number = 0;
	Color color;

	void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		if (levelType == 1) {
			int random1 = new Random().nextInt(155);
			random1 += 50;
			int random2 = new Random().nextInt(155);
			random2 += 50;
			int random3 = new Random().nextInt(155);
			random3 += 50;
			if (number % 10 == 0) {
				color = new Color(random1, random2, random3);
			}
		} else if (levelType == 2) {
			color = new Color(40, 40, 40);
			if (enemy == null && enemy1 == null) {
			enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 1, 1);
			enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true, 1, 1);
			}
		} else if (levelType == 3) {
			color = new Color(50, 50, 50);
		} else if (levelType == 4) {
			color = new Color(70, 60, 60);
		} else if (levelType == 5) {
			color = new Color(180, 0, 0);
		} else if (levelType == 6) {
			color = new Color(0, 0, 0);
		}
		g.setColor(color);
		g.fillRect(x, y, width, height);
		number++;
		if (levelType == 5) {
			g.drawImage(GamePanel.pixelBlood1, x - 20, y - 20, width, height, null);
		}
		if (levelType == 6) {
			g.drawImage(GamePanel.space, x, y, width, height, null);
		}
//		System.out.println(levelType);
	}

	void update() {

	}
	void drawEnemy (Graphics g) {
		if (enemy != null && enemy1 != null) {
		enemy.draw(g);
		enemy1.draw(g);
		enemy.update();
		enemy1.update();
		if (enemy2 != null) {
			if (enemy3 != null) {
				
			}
		}
	}
	}
}
