
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class AlienManager {

	public static Alien[] aliens;
	
	public static Image[] images, imageAlts;
	
	static {
		aliens = new Alien[100];
		images = new Image[3];
		images[0]= new ImageIcon(Coordinator.path + "orangeAlien_1.png").getImage();
		images[1]= new ImageIcon(Coordinator.path + "greenAlien_1.png").getImage();
		images[2]= new ImageIcon(Coordinator.path + "blueAlien_1.png").getImage();
		
		imageAlts = new Image[3];
		imageAlts[0]= new ImageIcon(Coordinator.path + "orangeAlien_2.png").getImage();
		imageAlts[1]= new ImageIcon(Coordinator.path + "greenAlien_2.png").getImage();
		imageAlts[2]= new ImageIcon(Coordinator.path + "blueAlien_2.png").getImage();
	}
	
	
	
	public static void create() {
		if(Math.random()>0.05) return;
		
		int x = (int)(Math.random()*601);
		int vx = (int)(Math.random()*7) - 3;
		int vy = (int)(Math.random()*5) + 3;
		int randomIndex= (int) (Math.random()*images.length);
		Image image = images[randomIndex ];
		Image imageAlt = imageAlts[randomIndex];
	
		Alien alien = new Alien(x,0, image, imageAlt, vx, vy);
		
		boolean shouldContinue = true;
		for(int i=0; i<aliens.length && shouldContinue; i++) {
			if(aliens[i]==null) {
				aliens[i] = alien;
				shouldContinue = false;
			}
		}
	}
	
	public static void add(Alien alien) {
		boolean shouldContinue = true;
		for(int i=0; i<aliens.length && shouldContinue; i++) {
			if(aliens[i]==null) {
				aliens[i] = alien;
				shouldContinue = false;
			}
		}
	}
	public static void move(Ship ship) {
		for(int i=0; i<aliens.length; i++) {
			if(aliens[i]!=null) aliens[i].move(ship);
		}
	}
	
	public static void draw(Graphics g) {
		for(int i=0; i<aliens.length; i++) {
			if(aliens[i]!=null) aliens[i].draw(g);
		}
	}
	
	
	public static boolean isHit(Torpedo torpedo) {
		for(int i=0; i<aliens.length; i++) {
			if(aliens[i]!=null) {
				if(aliens[i].isHit(torpedo)) return true;
			}
		}
		return false;
	}
	
	public static void remove(Alien alien) {
		boolean shouldContinue = true;
		for(int i=0; i<aliens.length && shouldContinue; i++) {
			if(aliens[i]==alien) {
				aliens[i] = null;
				shouldContinue = false;
			}
		}
	}
	
	
	
	
}
