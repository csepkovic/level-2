import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objects;
	Character ch;
	Level l;
	Sword s;
	ArrayList<LevelDoor> doors = new ArrayList<LevelDoor>();
	int score;
	int doorVis;
	int moveLevels;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
		this.l = GamePanel.level;
	}

	void addCharacter(Character c) {
		ch = c;
		addObject(ch);
	}

	void addDoor(LevelDoor ld) {
		doors.add(ld);
	}

	void addSword(Sword sd) {
		s = sd;
		addObject(s);
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			if (i == 0) {
				o.update();
			}
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			objects.remove(i);
		}
	}

	public Level createLevel(int random1) {
		doors.clear();
		doorVis = 255;
		int levelType = random1;
		if (random1 <= 10) {
			levelType = 1;
			// bonus level
		} else if (random1 > 10 && random1 <= 30) {
			levelType = 2;
			// regular level
		} else if (random1 > 30 && random1 <= 50) {
			levelType = 3;
			// boss level
		} else if (random1 > 50 && random1 <= 70) {
			levelType = 4;
			// slightly harder level
		} else if (random1 > 70 && random1 <= 90) {
			levelType = 5;
			// super hard level
		} else if (random1 > 90) {
			levelType = 6;
			// space level
		}
		LevelDoor door1 = new LevelDoor(10, 255, 51, 70, 1, true);
		addDoor(door1);
		LevelDoor door2 = new LevelDoor(639, 255, 51, 70, 1, true);
		addDoor(door2);
		LevelDoor door3 = new LevelDoor(315, 10, 70, 51, 1, true);
		addDoor(door3);
		LevelDoor door4 = new LevelDoor(315, 510, 70, 51, 1, true);
		addDoor(door4);
		Level l = new Level(50, 50, 600, 475, 1, true, levelType);
		addObject(l);
		this.l = l;
		return l;
	}

	int invince = 0;
	int killPause = 0;
	int chealth = 0;
	int levelTypeBonus = 0;

	public void checkCollision() {
		for (LevelDoor d : doors) {
			if (ch.collisionBox.intersects(d.collisionBox)) {
				if (moveLevels == 0) {
				reset(d);
				ch.reset();
				chealth += 1;
				if (chealth == 3) {
					ch.health++;
					chealth = 0;
				}
				break;
				}
			}
		}
		if (killPause == 0) {
			if (l != null) {
				if (l.getEnemies() != null && s != null) {
					for (int i = 0; i < l.enemies.size(); i++) {
						Enemy1 temp = l.enemies.get(i);
						if (s.collisionBox.intersects(temp.collisionBox)) {
							l.enemies.remove(i);
							score++;
							if (l.levelType == 5 || l.levelType == 6) {
								levelTypeBonus++;
							}
							if (levelTypeBonus == 2) {
								score++;
								levelTypeBonus = 0;
							}
							killPause += 5;
							break;
						}
					}
				}
			}
		} else {
			killPause -= 1;
		}
		if (invince == 0) {
			if (l != null) {
				if (l.getEnemies() != null && ch != null) {
					for (Enemy1 enemy : l.getEnemies()) {
						if (enemy != null) {
							if (ch.collisionBox.intersects(enemy.collisionBox)) {
								ch.health -= 1;
								invince += 50;
								break;
							}
						}
					}
				}
			}
		} else {
			invince -= 1;
			// System.out.println(invince);
		}
	}

	public void characterBoundaries(Character c, Level l) {
		if (c.x <= l.x) {
			c.left = false;
		}
		if ((c.x + 50) >= (l.x + 600)) {
			c.right = false;
		}
		if (c.y <= l.y) {
			c.up = false;
		}
		if ((c.y + 50) >= (l.y + 475)) {
			c.down = false;
		}
	}

	// public int getScore() {
	// return score;
	// }
	//
	// public void setScore(int s) {
	// score = s;
	// }

	public void reset(LevelDoor d) {
		reset();
		int id = d.getDoorType();
		GamePanel.level = createLevel(id);
		System.out.println(id);
	}

	public void reset() {
		objects.clear();
		System.out.println("reset");
	}
	public void drawDoors(Graphics g) {
		// TODO Auto-generated method stub
		moveLevels = l.enemies.size();
		if (moveLevels == 0) {
			if (doorVis > 0) {
			doorVis-=5;
			}
		}
		for (LevelDoor d : doors) {
			d.draw(g, doorVis);
		}
	}
}
