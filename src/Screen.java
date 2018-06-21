import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;

	private BufferedImage image;
	private Thread thread;
	private boolean running = false;
	private Graphics2D g;
	private int fps = 60;
	private long tt = 1000 / fps;

	private EventManager em;

	public Screen() {
		em = new EventManager();
		setLayout(null);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void draw() {
		em.draw(g);
	}

	public void update() {
		em.update();
	}

	public void run() {
		init();

		long start;
		long elapsed;
		long wait;
		while (running) {
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;
			wait = tt - elapsed / 1000000;
			if (wait < 0)
				wait = 5;
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
	}

	public void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			addMouseListener(this);
			thread.start();
		}
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		running = false;
		thread.stop();
	}

	public void mouseClicked(MouseEvent paramMouseEvent) {
		em.mouseClicked(paramMouseEvent);
	}

	public void mousePressed(MouseEvent paramMouseEvent) {
		em.mousePressed(paramMouseEvent);
	}

	public void mouseReleased(MouseEvent paramMouseEvent) {
		em.mouseReleased(paramMouseEvent);
	}

	public void mouseEntered(MouseEvent paramMouseEvent) {
		em.mouseEntered(paramMouseEvent);
	}

	public void mouseExited(MouseEvent paramMouseEvent) {
		em.mouseExited(paramMouseEvent);
	}

	public void keyTyped(KeyEvent paramKeyEvent) {
		em.keyTyped(paramKeyEvent);
	}

	public void keyPressed(KeyEvent paramKeyEvent) {
		em.keyPressed(paramKeyEvent);
	}

	public void keyReleased(KeyEvent paramKeyEvent) {
		em.keyReleased(paramKeyEvent);
	}

}
