import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Level extends GameObject {
	int levelType;
	ArrayList<Enemy1> enemies = new ArrayList<Enemy1>();

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
			if (enemy == null && enemy1 == null) {
				enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 2,
						2);
				if (enemy.x > 350 && enemy.x < 400) {
					enemy.x += 50;
				}
				if (enemy.x > 300 && enemy.x < 350) {
					enemy.x -= 50;
				}
				if (enemy.y > 300 && enemy.y < 350) {
					enemy.y += 50;
				}
				if (enemy.y > 250 && enemy.y < 300) {
					enemy.y -= 50;
				}
				enemies.add(enemy);
				enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 2);
				if (enemy1.x > 350 && enemy1.x < 400) {
					enemy1.x += 50;
				}
				if (enemy1.x > 300 && enemy1.x < 350) {
					enemy1.x -= 50;
				}
				if (enemy1.y > 300 && enemy1.y < 350) {
					enemy1.y += 50;
				}
				if (enemy1.y > 250 && enemy1.y < 300) {
					enemy1.y -= 50;
				}
				System.out.println("enemy1 added");
			}
		} else if (levelType == 2) {
			color = new Color(40, 40, 40);
			if (enemy == null && enemy1 == null) {
				enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 2,
						2);
				if (enemy.x > 350 && enemy.x < 400) {
					enemy.x += 50;
				}
				if (enemy.x > 300 && enemy.x < 350) {
					enemy.x -= 50;
				}
				if (enemy.y > 300 && enemy.y < 350) {
					enemy.y += 50;
				}
				if (enemy.y > 250 && enemy.y < 300) {
					enemy.y -= 50;
				}
				enemies.add(enemy);
				enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 2);
				if (enemy1.x > 350 && enemy1.x < 400) {
					enemy1.x += 50;
				}
				if (enemy1.x > 300 && enemy1.x < 350) {
					enemy1.x -= 50;
				}
				if (enemy1.y > 300 && enemy1.y < 350) {
					enemy1.y += 50;
				}
				if (enemy1.y > 250 && enemy1.y < 300) {
					enemy1.y -= 50;
				}
				enemies.add(enemy1);
			}
		} else if (levelType == 3) {
			color = new Color(50, 50, 50);
			if (enemy == null && enemy1 == null && enemy2 == null) {
				enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 2,
						2);
				if (enemy.x > 350 && enemy.x < 400) {
					enemy.x += 50;
				}
				if (enemy.x > 300 && enemy.x < 350) {
					enemy.x -= 50;
				}
				if (enemy.y > 300 && enemy.y < 350) {
					enemy.y += 50;
				}
				if (enemy.y > 250 && enemy.y < 300) {
					enemy.y -= 50;
				}
				enemies.add(enemy);
				enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 2);
				if (enemy1.x > 350 && enemy1.x < 400) {
					enemy1.x += 50;
				}
				if (enemy1.x > 300 && enemy1.x < 350) {
					enemy1.x -= 50;
				}
				if (enemy1.y > 300 && enemy1.y < 350) {
					enemy1.y += 50;
				}
				if (enemy1.y > 250 && enemy1.y < 300) {
					enemy1.y -= 50;
				}
				enemies.add(enemy1);
				enemy2 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						2, 3);
				if (enemy2.x > 350 && enemy2.x < 400) {
					enemy2.x += 50;
				}
				if (enemy2.x > 300 && enemy2.x < 350) {
					enemy2.x -= 50;
				}
				if (enemy2.y > 300 && enemy2.y < 350) {
					enemy2.y += 50;
				}
				if (enemy2.y > 250 && enemy2.y < 300) {
					enemy2.y -= 50;
				}
				enemies.add(enemy2);
			}
		} else if (levelType == 4) {
			color = new Color(70, 60, 60);
			if (enemy == null && enemy1 == null && enemy2 == null && enemy3 == null) {
				enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 3,
						3);
				if (enemy.x > 350 && enemy.x < 400) {
					enemy.x += 50;
				}
				if (enemy.x > 300 && enemy.x < 350) {
					enemy.x -= 50;
				}
				if (enemy.y > 300 && enemy.y < 350) {
					enemy.y += 50;
				}
				if (enemy.y > 250 && enemy.y < 300) {
					enemy.y -= 50;
				}
				enemies.add(enemy);
				enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 2);
				if (enemy1.x > 350 && enemy1.x < 400) {
					enemy1.x += 50;
				}
				if (enemy1.x > 300 && enemy1.x < 350) {
					enemy1.x -= 50;
				}
				if (enemy1.y > 300 && enemy1.y < 350) {
					enemy1.y += 50;
				}
				if (enemy1.y > 250 && enemy1.y < 300) {
					enemy1.y -= 50;
				}
				enemies.add(enemy1);
				enemy2 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						2, 3);
				if (enemy2.x > 350 && enemy2.x < 400) {
					enemy2.x += 50;
				}
				if (enemy2.x > 300 && enemy2.x < 350) {
					enemy2.x -= 50;
				}
				if (enemy2.y > 300 && enemy2.y < 350) {
					enemy2.y += 50;
				}
				if (enemy2.y > 250 && enemy2.y < 300) {
					enemy2.y -= 50;
				}
				enemies.add(enemy2);
				enemy3 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						2, 2);
				if (enemy3.x > 350 && enemy3.x < 400) {
					enemy3.x += 50;
				}
				if (enemy3.x > 300 && enemy3.x < 350) {
					enemy3.x -= 50;
				}
				if (enemy3.y > 300 && enemy3.y < 350) {
					enemy3.y += 50;
				}
				if (enemy3.y > 250 && enemy3.y < 300) {
					enemy3.y -= 50;
				}
				enemies.add(enemy3);
			}
		} else if (levelType == 5) {
			color = new Color(180, 0, 0);
			if (enemy == null && enemy1 == null && enemy2 == null && enemy3 == null) {
				enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 3,
						3);
				if (enemy.x > 350 && enemy.x < 400) {
					enemy.x += 50;
				}
				if (enemy.x > 300 && enemy.x < 350) {
					enemy.x -= 50;
				}
				if (enemy.y > 300 && enemy.y < 350) {
					enemy.y += 50;
				}
				if (enemy.y > 250 && enemy.y < 300) {
					enemy.y -= 50;
				}
				enemies.add(enemy);
				System.out.println("enemy added");
				enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 3);
				if (enemy1.x > 350 && enemy1.x < 400) {
					enemy1.x += 50;
				}
				if (enemy1.x > 300 && enemy1.x < 350) {
					enemy1.x -= 50;
				}
				if (enemy1.y > 300 && enemy1.y < 350) {
					enemy1.y += 50;
				}
				if (enemy1.y > 250 && enemy1.y < 300) {
					enemy1.y -= 50;
				}
				enemies.add(enemy1);
				enemy2 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 3);
				if (enemy2.x > 350 && enemy2.x < 400) {
					enemy2.x += 50;
				}
				if (enemy2.x > 300 && enemy2.x < 350) {
					enemy2.x -= 50;
				}
				if (enemy2.y > 300 && enemy2.y < 350) {
					enemy2.y += 50;
				}
				if (enemy2.y > 250 && enemy2.y < 300) {
					enemy2.y -= 50;
				}
				enemies.add(enemy2);
				enemy3 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						3, 2);
				if (enemy3.x > 350 && enemy3.x < 400) {
					enemy3.x += 50;
				}
				if (enemy3.x > 300 && enemy3.x < 350) {
					enemy3.x -= 50;
				}
				if (enemy3.y > 300 && enemy3.y < 350) {
					enemy3.y += 50;
				}
				if (enemy3.y > 250 && enemy3.y < 300) {
					enemy3.y -= 50;
				}
				enemies.add(enemy3);
			}
		} else if (levelType == 6) {
			color = new Color(0, 0, 0);
			if (enemy == null && enemy1 == null) {
				enemy = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 100, 25, 1, 25, true, 2,
						2);
				if (enemy.x > 350 && enemy.x < 400) {
					enemy.x += 50;
				}
				if (enemy.x > 300 && enemy.x < 350) {
					enemy.x -= 50;
				}
				if (enemy.y > 300 && enemy.y < 350) {
					enemy.y += 50;
				}
				if (enemy.y > 250 && enemy.y < 300) {
					enemy.y -= 50;
				}
				enemies.add(enemy);
				enemy1 = new Enemy1(new Random().nextInt(400) + 100, new Random().nextInt(200) + 300, 25, 1, 25, true,
						2, 3);
				if (enemy1.x > 350 && enemy1.x < 400) {
					enemy1.x += 50;
				}
				if (enemy1.x > 300 && enemy1.x < 350) {
					enemy1.x -= 50;
				}
				if (enemy1.y > 300 && enemy1.y < 350) {
					enemy1.y += 50;
				}
				if (enemy1.y > 250 && enemy1.y < 300) {
					enemy1.y -= 50;
				}
				enemies.add(enemy1);
			}
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
	}

	void update() {

	}

	void drawEnemy(Graphics g) {
		for (Enemy1 enemies : getEnemies()) {
			enemies.update();
			enemies.draw(g);
		}
	}

	ArrayList<Enemy1> getEnemies() {
		return enemies;
	}

}
