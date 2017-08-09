import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LevelDoor extends GameObject{
	int doorType;
	public LevelDoor(int x, int y, int width, int height, int health, boolean isAlive, int doorType) {
		super(x, y, width, height, health, isAlive);
		this.doorType = doorType;
	}
	int getDoorType (){
		return doorType;
	}
	void draw(Graphics g){
		if (doorType == 1) {
			int random1 = new Random().nextInt(155);
			random1+=100;
			int random2 = new Random().nextInt(155);
			random2+=100;
			int random3 = new Random().nextInt(155);
			random3+=100;
			Color color = new Color(random1, random2, random3);
			g.setColor(color);;
			g.fillRect(x, y, width, height);
		} else if (doorType == 2) {
			g.setColor(Color.WHITE);
			g.drawRect(x, y, width, height);
		} else if (doorType == 3) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
			//Put skull here
		} else if (doorType == 4) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
			//Put timer here
		} else if (doorType == 5) {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		} else if (doorType == 6) {
			g.setColor(Color.WHITE);
			g.drawRect(x, y, width, height);
			//Put stars here
		}
	}
	void update(){
		
	}
}
