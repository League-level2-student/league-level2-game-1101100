import java.awt.Graphics;
import java.awt.Color;

public class Wizard extends GameObject{
	int speed;
	public Wizard(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update() {
		super.update();
		
	}
	public void right() {
	   
	}
	public void left(){

	}
	public void up(){

	}
	public void down(){
	
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(500, 350, width, height);
	}

}
