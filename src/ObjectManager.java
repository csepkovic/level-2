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
		purgeObjects();
		System.out.println();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}
	int random1 = new Random().nextInt(100);
	public void createLevel(){
		int levelType;
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
		addObject(new Level(50, 50, 600, 475, true, 0));
	}

//	public void manageEnemies() {
//		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
//			addObject(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
//			enemyTimer = System.currentTimeMillis();
//			enemySpawnTime--;
//		}
//	}

	public void checkCollision() {
		
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
