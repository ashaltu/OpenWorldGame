import java.awt.image.BufferedImage;

public abstract class Entity implements Drawable {
	private double x, y, xVel, yVel, width, height;
	private boolean movingUp, movingDown, movingLeft, movingRight;
	private Health health;
	private Inventory inventory;
	private Currency gold;
	private BufferedImage moveLeft, moveRight, moveUp, moveDown, currentImage;

	public Entity(double x, double y, double width, double height, Health health, Inventory inventory, Currency gold) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setHealth(health);
		this.setInventory(inventory);
		this.setGold(gold);
		setMoveDown(ImageLoader.loadImage("movingDown"));
		setMoveUp(ImageLoader.loadImage("movingUp"));
		setMoveLeft(ImageLoader.loadImage("movingLeft"));
		setMoveRight(ImageLoader.loadImage("movingRight"));
		setCurrentImage(moveDown);
	}

	public Entity(double x, double y, Health health, Inventory inventory, Currency gold) {
		this.setX(x);
		this.setY(y);
		this.width=16;
		this.height=16;
		this.setHealth(health);
		this.setInventory(inventory);
		this.setGold(gold);
		setMoveDown(ImageLoader.loadImage("movingDown"));
		setMoveUp(ImageLoader.loadImage("movingUp"));
		setMoveLeft(ImageLoader.loadImage("movingLeft"));
		setMoveRight(ImageLoader.loadImage("movingRight"));
		setCurrentImage(moveDown);
	}

	public abstract void move();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public Health getHealth() {
		return health;
	}

	public void setHealth(Health health) {
		this.health = health;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Currency getGold() {
		return gold;
	}

	public void setGold(Currency gold) {
		this.gold = gold;
	}

	public BufferedImage getMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(BufferedImage moveLeft) {
		this.moveLeft = moveLeft;
	}

	public BufferedImage getMoveRight() {
		return moveRight;
	}

	public void setMoveRight(BufferedImage moveRight) {
		this.moveRight = moveRight;
	}

	public BufferedImage getMoveUp() {
		return moveUp;
	}

	public void setMoveUp(BufferedImage moveUp) {
		this.moveUp = moveUp;
	}

	public BufferedImage getMoveDown() {
		return moveDown;
	}

	public void setMoveDown(BufferedImage moveDown) {
		this.moveDown = moveDown;
	}

	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}

}
