import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Play extends Event{
	private Player player;
	private TileMap tileMap;
	private ScreenWriter sw;
	public Play() {
	}

	public void draw(Graphics2D g) {
		tileMap.draw(g);
		player.draw(g);
		sw.printOnScreen(g, "X:"+(int)player.getX()+" Y:"+(int)player.getY(), 0, Screen.HEIGHT-50);
		sw.printOnScreen(g, "Speed:"+player.getSpeed(), Screen.WIDTH-165, Screen.HEIGHT-50);
	}

	
	public void update() {
		tileMap.update();
		player.update();
	}

	
	public void init() {
		player = new Player(200, 200,32,32, new Health(Health.MAX_HEALTH,true), new Inventory(), new Currency());
		tileMap = new TileMap((int)(-Screen.WIDTH*1.5),(int)(-Screen.HEIGHT*1.5) , 0,0 , Screen.WIDTH*3, Screen.HEIGHT*3, Screen.WIDTH, Screen.HEIGHT);
		sw = new ScreenWriter(Screen.WIDTH,Screen.HEIGHT);
	}

	
	public void keyPressed(KeyEvent arg0) {
		player.keyPressed(arg0);
	}

	
	public void keyReleased(KeyEvent arg0) {
		player.keyReleased(arg0);
	}

	
	public void keyTyped(KeyEvent paramKeyEvent) {
		player.keyTyped(paramKeyEvent);
	}

	
	public void mouseClicked(MouseEvent paramMouseEvent) {
		player.mouseClicked(paramMouseEvent);
	}

	
	public void mousePressed(MouseEvent paramMouseEvent) {
		player.mousePressed(paramMouseEvent);
	}

	
	public void mouseReleased(MouseEvent paramMouseEvent) {
		player.mouseReleased(paramMouseEvent);
	}

	
	public void mouseEntered(MouseEvent paramMouseEvent) {
		player.mouseEntered(paramMouseEvent);
	}

	
	public void mouseExited(MouseEvent paramMouseEvent) {
		player.mouseExited(paramMouseEvent);
	}

}
