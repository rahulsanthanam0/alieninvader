
import java.awt.Graphics;

public class TorpedoManager {

	public static Torpedo[] torpedoes;
	
	static {
		torpedoes = new Torpedo[100];
	}
	

	public static void add(Torpedo torpedo) {
		boolean shouldContinue = true;
		for(int i=0; i<torpedoes.length && shouldContinue; i++) {
			if(torpedoes[i]==null) {
				torpedoes[i] = torpedo;
				shouldContinue = false;
			}
		}
	}
	
	
	public static void move() {
		for(int i=0; i<torpedoes.length; i++) {
			if(torpedoes[i]!=null) torpedoes[i].move();
		}
	}
	
	
	public static void draw(Graphics g) {
		for(int i=0; i<torpedoes.length; i++) {
			if(torpedoes[i]!=null) torpedoes[i].draw(g);
		}
	}
	
	
	public static void remove(Torpedo torpedo) {
		boolean shouldContinue = true;
		for(int i=0; i<torpedoes.length && shouldContinue; i++) {
			if(torpedoes[i]==torpedo) {
				torpedoes[i] = null;
				shouldContinue = false;
			}
		}
	}
		
	
	
}
