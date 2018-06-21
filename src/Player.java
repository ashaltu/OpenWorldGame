import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player extends Entity implements KeyListener, MouseListener {
	private double speed = 1;

	public Player(double x, double y, Health health, Inventory inventory, Currency gold) {
		super(x, y, health, inventory, gold);
	}

	public Player(double x, double y, double width, double height, Health health, Inventory inventory, Currency gold) {
		super(x, y, width, height, health, inventory, gold);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void draw(Graphics2D g) {
		g.drawImage(getCurrentImage(), (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
		getHealth().draw(g);
		getGold().draw(g);
		getInventory().draw(g);
	}

	public void update() {
		getHealth().update();
		getGold().update();
		getInventory().update();
		move();
	}

	public void move() {
		setX(getX() + getxVel());
		setY(getY() + getyVel());
		if (isMovingUp()) {
			setyVel(-1.7 * speed);
		} else if (!isMovingUp()) {
			setyVel(0);
		}
		if (isMovingDown()) {
			setyVel(1.7 * speed);
		}
		if (isMovingLeft()) {
			setxVel(-1.7 * speed);
		} else if (!isMovingLeft()) {
			setxVel(0);
		}
		if (isMovingRight()) {
			setxVel(1.7 * speed);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_E && !getInventory().isShowOnScreen()) {
			getInventory().setShowOnScreen(true);
		} else if (e.getKeyCode() == KeyEvent.VK_E && getInventory().isShowOnScreen()) {
			getInventory().setShowOnScreen(false);
		} else if (!getInventory().isShowOnScreen()) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				speed += 1.5;
				if (speed > 50) {
					speed = 50;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				speed -= 1.5;
				if (speed < 0) {
					speed = .5;
				}
			}

			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				setCurrentImage(getMoveUp());
				setMovingUp(true);
				break;
			case KeyEvent.VK_S:
				setCurrentImage(getMoveDown());
				setMovingDown(true);
				break;
			case KeyEvent.VK_A:
				setCurrentImage(getMoveLeft());
				setMovingLeft(true);
				break;
			case KeyEvent.VK_D:
				setCurrentImage(getMoveRight());
				setMovingRight(true);
				break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (!getInventory().isShowOnScreen()) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				setCurrentImage(getMoveUp());
				setMovingUp(false);
				break;
			case KeyEvent.VK_S:
				setCurrentImage(getMoveDown());
				setMovingDown(false);
				break;
			case KeyEvent.VK_A:
				setCurrentImage(getMoveLeft());
				setMovingLeft(false);
				break;
			case KeyEvent.VK_D:
				setCurrentImage(getMoveRight());
				setMovingRight(false);
				break;
			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent paramMouseEvent) {
		getInventory().mouseClicked(paramMouseEvent);
	}

	@Override
	public void mousePressed(MouseEvent paramMouseEvent) {
		getInventory().mousePressed(paramMouseEvent);
	}

	@Override
	public void mouseReleased(MouseEvent paramMouseEvent) {
		getInventory().mouseReleased(paramMouseEvent);
	}

	@Override
	public void mouseEntered(MouseEvent paramMouseEvent) {
		getInventory().mouseEntered(paramMouseEvent);
	}

	@Override
	public void mouseExited(MouseEvent paramMouseEvent) {
		getInventory().mouseExited(paramMouseEvent);
	}

}
