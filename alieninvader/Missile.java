
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {

	public int x, y; // bottom-center
	public static int width, height;
	public static Image image;
	public int vy;
	public boolean collided;
	public static Color explosionColor;
	public static int explosionRadius;
	
	
	static {
		image = new ImageIcon(Coordinator.path + "missile.png").getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		explosionColor = Color.RED;
		explosionRadius = 80;
	}
	
	public Missile(int x, int y, int vy) {
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	
	public void move(Ship ship) {
		y += vy;
		
		if(y>690) MissileManager.remove(this);
		
		collided = ship.isHit(this);
	}
	
	
	public boolean isHit(Torpedo torpedo) {
		
		if(torpedo.x>=x-width/2-Torpedo.width/2 && 
		   torpedo.x<=x+width/2+Torpedo.width/2 &&
		   torpedo.y>=y-height-Torpedo.height	&& 
		   torpedo.y<=y) {
			
			MissileManager.remove(this); 
			return true;
		}
		
		return false;
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(image, x-width/2, y-height, null);  
		
		if(collided) {
			g.setColor(explosionColor);
			g.fillOval(x-explosionRadius, y-explosionRadius, 2*explosionRadius, 2*explosionRadius);
			MissileManager.remove(this);
		}
	}
}





