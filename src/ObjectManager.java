import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class ObjectManager implements ActionListener {
	Wizard wizard;
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
	int getScore() {
		
		return score;
	}
	public ObjectManager(Wizard wizard) {
		this.wizard = wizard;
	}
	void addAlien() {
		
		Random random = new Random();
		aliens.add(new Alien(0, random.nextInt(500)+100,50,50, false));
		Random random2 = new Random();
		aliens.add(new Alien(1000, random2.nextInt(600),50,50, true));
	}
	void attackAlien(int arrowCheck) {
		
		if (aliens.size() > 0) {	
			aliens.get(0).attacked(arrowCheck);
			if(aliens.get(0).numberArrows.size() == 0) {
				aliens.remove(0);
				score++;
			}
		}
	}
	void update() {
		
		wizard.update();
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		checkCollision();
		purgeObjects();
		
	}
	void draw(Graphics g) {
		wizard.draw(g);

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
			if(i == 0) {
				g.setColor(Color.RED);
				g.fillOval(aliens.get(i).x + 19, aliens.get(i).y + 30, 10, 10);
			}
		}
	}
	void purgeObjects() {
		
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
	}
	void checkCollision() {

		for(int i = 0; i<aliens.size(); i++) {
			if(wizard.collisionBox.intersects(aliens.get(i).collisionBox)) {
				wizard.isActive = false;
				System.out.println("rocket destroyed");
		
			}
		}
	

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		System.out.println(aliens.size());
	}

}
