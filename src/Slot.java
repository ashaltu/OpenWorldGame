import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Slot implements Drawable, MouseListener {
	private Item currentItem;
	private static int counter = 0;
	private int slotID;
	private boolean inSlot;
	private int minX, minY, maxX, maxY;

	public Slot(int minX, int minY, int maxX, int maxY, Item item) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		currentItem = item;
		inSlot = false;
		slotID = counter;
		counter++;
	}

	public Slot(int minX, int minY, int maxX, int maxY) {
		this(minX, minY, maxX, maxY, null);
	}

	public void setItem(Item item) {
		currentItem = item;
	}

	public Item getItem() {
		return currentItem;
	}

	public int getSlotID() {
		return slotID;
	}

	public boolean isInSlot() {
		return inSlot;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		if (e.getX() > minX && e.getX() < maxX && e.getY() > minY && e.getY() < maxY) {
			inSlot = true;
		}

	}

	public void mouseExited(MouseEvent e) {
		if (e.getX() <= minX || e.getX() >= maxX || e.getY() <= minY || e.getY() >= maxY) {
			inSlot = false;
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void draw(Graphics2D g) {
		if (currentItem != null) {
			g.drawImage(currentItem.getItemImage(), minX, minY, null);
		}
		g.setColor(Color.pink);
		g.fillRect(minX, minY, 16, 16);
	}

	public void update() {

	}

}
