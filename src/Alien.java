import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

boolean reverse = true;
	
	public Alien(int x, int y, int width, int height, boolean reverse) {
		super(x, y, width, height);
		this.reverse = reverse;
	}
	
	void update() {
		super.update();
		//TODO NEEDS TO SPAWN FROM BOTH X=0 & X = 500
		if (reverse) {
			x -= 1; 
			
		}
		else {
			x+=1;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
		
	}

}
