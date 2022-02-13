
import java.awt.Graphics;

public class MissileManager {

	public static Missile[] missiles;
	
	static {
		missiles = new Missile[200];
	}
	

	
	public static void add(Missile missile) {
		boolean shouldContinue = true;
		for(int i=0; i<missiles.length && shouldContinue; i++) {
			if(missiles[i]==null) {
				missiles[i] = missile;
				shouldContinue = false;
			}
		}
	}
	
	public static void move(Ship ship) {
		for(int i=0; i<missiles.length; i++) {
			if(missiles[i]!=null) missiles[i].move(ship);
		}
	}
	
	public static void draw(Graphics g) {
		for(int i=0; i<missiles.length; i++) {
			if(missiles[i]!=null) missiles[i].draw(g); 
		}
	}
	
	public static boolean isHit(Torpedo torpedo) {
		for(int i=0; i<missiles.length; i++) {
			if(missiles[i]!=null) {
				if(missiles[i].isHit(torpedo)) return true;
			}
		}
		return false;
	}
	
	
	public static void remove(Missile missile) { 
		boolean shouldContinue = true;
		for(int i=0; i<missiles.length && shouldContinue; i++) {
			if(missiles[i]==missile) {
				missiles[i] = null;
				shouldContinue = false;
			}
		}
	} 
	
	
}
