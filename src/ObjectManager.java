import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;



public class ObjectManager {
	ArrayList<GameObject> objects;
	Character character;
	private int score = 0;
	double gravity = 0.5;

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
//		purgeObjects();
		System.out.println();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

//	private void purgeObjects() {
//		for (int i = 0; i < objects.size(); i++) {
//			if (!objects.get(i).isAlive) {
//				objects.remove(i);
//			}
//		}
//	}
	int random1 = new Random().nextInt(100);
	public Level createLevel(){
		int levelType = random1;
		if (random1 <= 10) {
			levelType=1;
		} else if (random1 > 10 && random1 <= 30) {
			levelType=2;
		} else if (random1 > 30 && random1 <= 50) {
			levelType=3;
		} else if (random1 > 50 && random1 <= 70) {
			levelType=4;
		} else if (random1 > 70 && random1 <= 90) {
			levelType=5;
		} else if (random1 > 90) {
			levelType=6;
		}
		Level level = new Level(50, 50, 600, 475, 1, true, levelType);
		addObject(level);
		return level;
	}

//	public void manageEnemies() {
//		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
//			addObject(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
//			enemyTimer = System.currentTimeMillis();
//			enemySpawnTime--;
//		}
//	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);

				if (o1.collisionBox.intersects(o2.collisionBox)) {
					if ((o1 instanceof Character && o2 instanceof LevelDoor)
							|| (o2 instanceof Character && o1 instanceof LevelDoor)) {
						o1.isAlive = false;
						o2.isAlive = false;
					} 
//						else if ((o1 instanceof Alien && o2 instanceof RocketShip)
//							|| (o2 instanceof Alien && o1 instanceof RocketShip)) {
//						o1.isAlive = false;
//						o2.isAlive = false;
//					} 
//					else if ((o1 instanceof PowerUp && o2 instanceof RocketShip)) {
//						o1.isAlive = false;
//						int random = new Random().nextInt(2);
//						if (random==1) {
//						((RocketShip)o2).projectileSpeed+=5;
//						} else {
//							if (((RocketShip)o2).width>20) {
//						((RocketShip)o2).width-=10;
//						((RocketShip)o2).height-=10;
//							} else {
//								((RocketShip)o2).speed+=2;
//							}
//						}
//					} else if ((o2 instanceof PowerUp && o1 instanceof RocketShip)) {
//						o2.isAlive = false;
//						int random = new Random().nextInt(2);
//						if (random==1) {
//						((RocketShip)o1).projectileSpeed+=5;
//						} else {
//							if (((RocketShip)o1).width>20) {
//								((RocketShip)o1).width-=10;
//								((RocketShip)o1).height-=10;
//									} else {
//										((RocketShip)o1).speed+=2;
//									}						
					}
				}
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
