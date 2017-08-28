import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	LevelDoor door1;
	LevelDoor door2;
	LevelDoor door3;
	LevelDoor door4;
	// Character character;
	private int score = 0;

	public ObjectManager(Character character) {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
		}
		// purgeObjects();
		System.out.println();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	// private void purgeObjects() {
	// for (int i = 0; i < objects.size(); i++) {
	// if (!objects.get(i).isAlive) {
	// objects.remove(i);
	// }
	// }
	// }
	public Level createLevel(int random1) {
		int levelType = random1;
		if (random1 <= 10) {
			levelType = 1;
		} else if (random1 > 10 && random1 <= 30) {
			levelType = 2;
		} else if (random1 > 30 && random1 <= 50) {
			levelType = 3;
		} else if (random1 > 50 && random1 <= 70) {
			levelType = 4;
		} else if (random1 > 70 && random1 <= 90) {
			levelType = 5;
		} else if (random1 > 90) {
			levelType = 6;
		}
		Level l = new Level(50, 50, 600, 475, 1, true, levelType);
		door1 = new LevelDoor(0, 255, 51, 70, 1, true);
		addObject(door1);
		door2 = new LevelDoor(649, 255, 51, 70, 1, true);
		addObject(door2);
		door3 = new LevelDoor(315, 0, 70, 51, 1, true);
		addObject(door3);
		door4 = new LevelDoor(315, 524, 70, 51, 1, true);
		addObject(door4);
		addObject(l);
		return l;
	}

	// public void manageEnemies() {
	// if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
	// addObject(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50,
	// 50));
	// enemyTimer = System.currentTimeMillis();
	// enemySpawnTime--;
	// }
	// }

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if (o1.collisionBox.intersects(o2.collisionBox)) {
					if ((o1 instanceof Character && o2 instanceof LevelDoor)) {
						if (o2 == door1) {
							int levelType = door1.getDoorType();
							createLevel(levelType);
						}
					} else if ((o2 instanceof Character && o1 instanceof LevelDoor)) {
						if (o1 == door1) {
							int levelType = door1.getDoorType();
							createLevel(levelType);
						}
					} else if ((o1 instanceof Character && o2 instanceof LevelDoor)) {
						if (o2 == door2) {
							int levelType = door2.getDoorType();
							createLevel(levelType);
						}
					} else if ((o2 instanceof Character && o1 instanceof LevelDoor)) {
						if (o1 == door2) {
							int levelType = door2.getDoorType();
							createLevel(levelType);
						}
					} else if ((o1 instanceof Character && o2 instanceof LevelDoor)) {
						if (o2 == door3) {
							int levelType = door3.getDoorType();
							createLevel(levelType);
						}
					} else if ((o2 instanceof Character && o1 instanceof LevelDoor)) {
						if (o1 == door3) {
							int levelType = door3.getDoorType();
							createLevel(levelType);
						}
					} else if ((o1 instanceof Character && o2 instanceof LevelDoor)) {
						if (o2 == door4) {
							int levelType = door4.getDoorType();
							createLevel(levelType);
						}
					} else if ((o2 instanceof Character && o1 instanceof LevelDoor)) {
						if (o1 == door4) {
							int levelType = door4.getDoorType();
							createLevel(levelType);
						}
					}
					// else if ((o1 instanceof Alien && o2 instanceof
					// RocketShip)
					// || (o2 instanceof Alien && o1 instanceof RocketShip)) {
					// o1.isAlive = false;
					// o2.isAlive = false;
					// }
					// else if ((o1 instanceof PowerUp && o2 instanceof
					// RocketShip)) {
					// o1.isAlive = false;
					// int random = new Random().nextInt(2);
					// if (random==1) {
					// ((RocketShip)o2).projectileSpeed+=5;
					// } else {
					// if (((RocketShip)o2).width>20) {
					// ((RocketShip)o2).width-=10;
					// ((RocketShip)o2).height-=10;
					// } else {
					// ((RocketShip)o2).speed+=2;
					// }
					// }
					// } else if ((o2 instanceof PowerUp && o1 instanceof
					// RocketShip)) {
					// o2.isAlive = false;
					// int random = new Random().nextInt(2);
					// if (random==1) {
					// ((RocketShip)o1).projectileSpeed+=5;
					// } else {
					// if (((RocketShip)o1).width>20) {
					// ((RocketShip)o1).width-=10;
					// ((RocketShip)o1).height-=10;
					// } else {
					// ((RocketShip)o1).speed+=2;
					// }
				}
			}
		}
	}

	public void characterBoundaries(Character c, Level l) {
		if (c.x <= l.x) {
			c.x += 4;
		}
		if ((c.x + 50) >= (l.x + 600)) {
			c.x -= 4;
		}
		if (c.y <= l.y) {
			c.y += 4;
		}
		if ((c.y + 50) >= (l.y + 475)) {
			c.y -= 4;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}
}
