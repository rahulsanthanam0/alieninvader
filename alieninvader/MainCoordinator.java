
import java.awt.Graphics;
import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Coordinator {

	public static boolean gameOver;
	public static String path = "alienInvader/imagesAndSounds/";
	
	
	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(200, 0, 600, 700);
		Graphics g = board.getCanvas();
		Timer timer = new Timer();
		
		Ship ship = new Ship(200, 600);
		
		board.addMouseMotionListener(ship);
		board.getJFrame().addKeyListener(ship); 
		
		board.setBackgroundImage(path + "bg.png");
		
		SoundPlayer bgSound = new SoundPlayer(path + "bgMusic.wav");
		bgSound.playLoop();
		
		while(!gameOver) {
		
			board.clear();
			
			ship.draw(g);
			
			AlienManager.create();
			
			MissileManager.move(ship);
			MissileManager.draw(g);
			
			AlienManager.move(ship);
			AlienManager.draw(g);
			
			TorpedoManager.move();
			TorpedoManager.draw(g);			
			
			board.repaint();
			timer.pause(50); 
		}
		
		bgSound.stop(); 
	}

	
}






