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
	public ObjectManager(Wizard rocketShip) {
		this.wizard = wizard;
	}
	void addAlien() {
		
		Random random = new Random();
		aliens.add(new Alien(random.nextInt(450),0,50,50));
		
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
