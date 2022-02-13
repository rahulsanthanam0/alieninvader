
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

import resources.SoundPlayer;


public class Ship implements MouseMotionListener, KeyListener {

	public int x, y; // top-center
	public Image image;
	public int eachHeight = 20;
	public int topWidth = 4, middleWidth = 20, bottomWidth = 60;
	
	public SoundPlayer laser;
	
	
	public Ship(int x, int y) {
		this.x = x;
		this.y = y;
		laser = new SoundPlayer(Coordinator.path + "laser.wav");
		image = new ImageIcon(Coordinator.path + "ship.png").getImage();
	}
	
	public void mouseMoved(MouseEvent e) { 
		x = e.getX();
	}
	public void mouseDragged(MouseEvent e) {
	}
	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==32) {
			shootTorpedo();
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
	
	}
	
	
	public void shootTorpedo() {
		laser.play();
		TorpedoManager.add(new Torpedo(x, y-Torpedo.height, -7));
		//Coordinator.addTorpedo(new Torpedo(x+20, y-Torpedo.height + 40, -7));
		//Coordinator.addTorpedo(new Torpedo(x-20, y-Torpedo.height + 40, -7));
	}
	
	
	public boolean isHit(Alien alien) {
		if(isHit(alien.x, alien.y, Alien.size, Alien.size)) {
			Coordinator.gameOver = true;
			return true;
		}
		return false;
	}
	
	
	public boolean isHit(Missile missile) {
		if(isHit(missile.x, missile.y, Missile.width, Missile.height)) {
			Coordinator.gameOver = true;
			return true;
		}
		return false;
	}
	
	
	public boolean isHit(int xBC, int yBC, int w, int h) {
		   return xBC>=x-topWidth/2-w/2 && xBC<=x+topWidth/2+w/2 && yBC>=y+0*eachHeight && yBC<=y+1*eachHeight+h ||
		          xBC>=x-middleWidth/2-w/2 && xBC<=x+middleWidth/2+w/2 && yBC>=y+1*eachHeight && yBC<=y+2*eachHeight+h ||
		          xBC>=x-bottomWidth/2-w/2 && xBC<=x+bottomWidth/2+w/2 && yBC>=y+2*eachHeight && yBC<=y+3*eachHeight+h;
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(image, x-bottomWidth/2, y, null);
 	}
 	
}













