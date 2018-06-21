import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends Event {
	private int x, y;
	public static final int PLAY_Y = 130, EXIT_Y = 180;
	private ScreenWriter sw;
	private BufferedImage selectionArrow;

	public Menu(EventManager em) {
		super(em);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Screen.WIDTH, Screen.HEIGHT);
		g.drawImage(selectionArrow, x, y, null);
		sw.printOnScreen(g, "Play", 155 + selectionArrow.getWidth(), 130);
		sw.printOnScreen(g, "Exit", 155 + selectionArrow.getWidth(), 180);
	}

	public void update() {

	}

	public void init() {
		sw = new ScreenWriter(Screen.WIDTH, Screen.HEIGHT);
		selectionArrow = ImageLoader.loadImage("arrowSelector");
		x = 150;
		y = PLAY_Y;

	}

	public void keyPressed(KeyEvent key) {
		int k = key.getKeyCode();
		if (k == KeyEvent.VK_UP) {
			y -= 50;
			if (y < PLAY_Y) {
				y = PLAY_Y;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			y += 50;
			if (y > EXIT_Y) {
				y = EXIT_Y;
			}
		}

		if (k == KeyEvent.VK_ENTER) {
			select();
		}

	}

	public void select() {
		if (y == PLAY_Y) {
			em.setCurrentEventSelection(EventManager.PLAY_EVENT);
		}
		if (y == EXIT_Y) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent key) {

	}

	public void keyTyped(KeyEvent paramKeyEvent) {

	}

	public void mouseClicked(MouseEvent paramMouseEvent) {

	}

	public void mousePressed(MouseEvent paramMouseEvent) {

	}

	public void mouseReleased(MouseEvent paramMouseEvent) {

	}

	public void mouseEntered(MouseEvent paramMouseEvent) {

	}

	public void mouseExited(MouseEvent paramMouseEvent) {

	}

}
