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
		this.character = character;
	}


	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		if (character.y<=400) {
			character.update(gravity);
		} else {
			for (int i = 0; i < objects.size(); i++) {
				GameObject o = objects.get(i);
				o.update(gravity);
			}
		}
		purgeObjects();
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
