import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Alien extends GameObject{

boolean reverse = true;
Random numArrow = new Random();	
ArrayList<Integer> numberArrows = new ArrayList<Integer>();
final static int UP = 0;
final static int DOWN = 1;
final static int LEFT = 2;
final static int RIGHT = 3;

	public Alien(int x, int y, int width, int height, boolean reverse) {
		super(x, y, width, height);
		this.reverse = reverse;
		int arrows = numArrow.nextInt(4)+1;
		for(int i = 1; i<=arrows; i++ ) {
			numberArrows.add(numArrow.nextInt(4));
		}
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
