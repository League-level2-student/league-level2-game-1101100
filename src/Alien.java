import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	void update() {
		super.update();
		//TODO NEEDS TO SPAWN FROM BOTH X=0 & X = 500
		x += 2; 
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(10, 10, width, height);
		
	}

}
