import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	Character ch;
	Level l;
	ArrayList<LevelDoor> doors = new ArrayList<LevelDoor>();

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}
	
	void addCharacter(Character c) {
		ch = c;
	}
	
	void addDoor (LevelDoor ld) {
		doors.add(ld);
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
		doors.clear();
		int levelType = random1;
		if (random1 <= 10) {
			levelType = 1;
			//bonus level
		} else if (random1 > 10 && random1 <= 30) {
			levelType = 2;
			//regular level
		} else if (random1 > 30 && random1 <= 50) {
			levelType = 3;
			//boss level
		} else if (random1 > 50 && random1 <= 70) {
			levelType = 4;
			//slightly harder level
		} else if (random1 > 70 && random1 <= 90) {
			levelType = 5;
			//super hard level
		} else if (random1 > 90) {
			levelType = 6;
			//space level
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
		System.out.println("new");
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
		for (LevelDoor d: doors) {
			if (ch.collisionBox.intersects(d.collisionBox)) {
				reset(d);
				ch.reset();
				System.out.println("collision");
				break;
			}
		}

	}

	public void characterBoundaries(Character c, Level l) {
		if (c.x <= l.x) {
			c.left=false;
		}
		if ((c.x + 50) >= (l.x + 600)) {
			c.right=false;
		}
		if (c.y <= l.y) {
			c.up=false;
		}
		if ((c.y + 50) >= (l.y + 475)) {
			c.down=false;
		}
	}

//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int s) {
//		score = s;
//	}

	public void reset(LevelDoor d) {
		reset();
		int id = d.getDoorType();
		int levelType = 0;
		if (id <= 10) {
			levelType = 1;
			//bonus level
		} else if (id > 10 && id <= 30) {
			levelType = 2;
			//regular level
		} else if (id > 30 && id <= 50) {
			levelType = 3;
			//boss level
		} else if (id > 50 && id <= 70) {
			levelType = 4;
			//slightly harder level
		} else if (id > 70 && id <= 90) {
			levelType = 5;
			//super hard level
		} else if (id > 90) {
			levelType = 6;
			//space level
		}
		l = createLevel(levelType);
		System.out.println(levelType);
	}

	public void reset() {
		objects.clear();
		System.out.println("reset");
		
	}

	public void drawDoors(Graphics g) {
		// TODO Auto-generated method stub
		for 	 (LevelDoor d: doors) {
			d.draw(g);
//			System.out.println("doors");
		}
	}
}
