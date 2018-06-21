import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Health implements Drawable {
	public static final int MAX_HEALTH = 100;
	private int health, x, y;
	private boolean alive, showOnScreen;
	private BufferedImage emptyHealthbar, healthbarAddition, healthbarSubtraction, healthbarLeft;
	private Graphics2D g;

	public Health(int health, int x, int y, boolean showOnScreen) {
		this.health = health;
		this.x = x;
		this.y = y;
		this.showOnScreen = showOnScreen;
		emptyHealthbar = ImageLoader.loadImage("emptyHealthbar");
		healthbarAddition = ImageLoader.loadImage("healthbarAddition");
		healthbarSubtraction = ImageLoader.loadImage("healthbarSubtraction");
		healthbarLeft = new BufferedImage(102, 16, BufferedImage.TYPE_INT_RGB);
		g = healthbarLeft.createGraphics();
		g.drawImage(emptyHealthbar, 0, 0, null);
		redrawHealthbar();

		if (health > 0) {
			setAlive(true);
		} else {
			setAlive(false);
		}
	}
	
	public Health(int health, boolean showOnScreen) {
		this.health = health;
		this.x = 10;
		this.y = 10;
		this.showOnScreen = showOnScreen;
		emptyHealthbar = ImageLoader.loadImage("emptyHealthbar");
		healthbarAddition = ImageLoader.loadImage("healthbarAddition");
		healthbarSubtraction = ImageLoader.loadImage("healthbarSubtraction");
		healthbarLeft = new BufferedImage(102, 16, BufferedImage.TYPE_INT_RGB);
		g = healthbarLeft.createGraphics();
		g.drawImage(emptyHealthbar, 0, 0, null);
		redrawHealthbar();

		if (health > 0) {
			setAlive(true);
		} else {
			setAlive(false);
		}
	}
	
	

	public double getHealth() {
		return health;
	}

	public void redrawHealthbar() {
		for (int i = 0; i < health; i++) {
			g.drawImage(healthbarAddition, 1 + i, 0, null);
		}
		for (int i = 0; i < 100 - health; i++) {
			g.drawImage(healthbarSubtraction, 1 + i + (int) health, 0, null);
		}
	}

	public void checkHealth() {
		if (health > 100) {
			health = 100;
		}

		if (health <= 0) {
			health = 0;
		}
	}

	public void addHealth(double addHealth) {
		health += addHealth;
		redrawHealthbar();
	}

	public void removeHealth(double removeHealth) {
		health -= removeHealth;
		redrawHealthbar();
	}

	public void setHealth(int health) {
		this.health = health;
		redrawHealthbar();

	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean isShowOnScreen() {
		return showOnScreen;
	}

	public void setShowOnScreen(boolean showOnScreen) {
		this.showOnScreen = showOnScreen;
	}

	public void draw(Graphics2D g) {
		if (showOnScreen) {
			g.drawImage(healthbarLeft, x, y, null);
		}
	}

	public void update() {
		checkHealth();
	}
}
