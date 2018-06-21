import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TileMap implements Drawable{
	public static final BufferedImage stoneBlock = ImageLoader.loadImage("stoneBlock");
	public static final BufferedImage grassBlock = ImageLoader.loadImage("grassBlock");
	private BufferedImage fullMap, screenMap;
	private int x, y, screenX, screenY, width, height,screenWidth,screenHeight;
	
	public TileMap(int x, int y, int screenX, int screenY, int width, int height,int screenWidth,int screenHeight) {
		this.setX(x);
		this.setY(y);
		this.setScreenX(screenX);
		this.setScreenY(screenY);
		this.setWidth(width);
		this.setHeight(height);
		this.setScreenWidth(screenWidth);
		this.setScreenHeight(screenHeight);
		createMap();
	}

	public void createMap() {
		fullMap = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = fullMap.createGraphics();
		for (int i = 0; i < width/16; i++) {
			for (int j = 0; j < height/16; j++) {
				g2.drawImage(grassBlock, j*16, i*16, null);
			}
		}
		screenMap = fullMap.getSubimage(screenX, screenY, screenWidth, screenHeight);
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(screenMap, 0, 0, null);
	}

	public void update() {
	//	screenMap = fullMap.getSubimage(screenX, screenY, screenWidth, screenHeight);
	}

	public int getScreenX() {
		return screenX;
	}

	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}

	public int getScreenY() {
		return screenY;
	}

	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
