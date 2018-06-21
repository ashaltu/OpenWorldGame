import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Inventory implements Drawable, MouseListener {
	private boolean showOnScreen;

	private int x, y, mouseX, mouseY;
	private BufferedImage inventoryImage = ImageLoader.loadImage("inventory");
	private Item heldItem;
	private ArrayList<Slot> inventory;
	private static final int NUMBEROFSLOTS = 16;

	public Inventory(Inventory inventory) {
		this.inventory = inventory.getInventory();
		showOnScreen = false;
		x = (Screen.WIDTH / 2) - (inventoryImage.getWidth() / 2);
		y = (Screen.HEIGHT / 2) - (inventoryImage.getHeight() / 2);
		heldItem = null;
	}

	public Inventory() {
		inventory = new ArrayList<Slot>();
		x = (Screen.WIDTH / 2) - (inventoryImage.getWidth() / 2);
		y = (Screen.HEIGHT / 2) - (inventoryImage.getHeight() / 2);
		for (int i = 0; i < NUMBEROFSLOTS / 4; i++) {
			for (int j = 0; j < NUMBEROFSLOTS / 4; j++) {
				inventory.add(new Slot(16 + (48 * j) + x, 16 + (48 * i) + y, 48 + (48 * j) + x, 48 + (48 * i) + y));
			}
		}
		showOnScreen = false;
		heldItem = null;
		addToInventory(new Sword(5.0, "sword"));
		addToInventory(new Sword(5.0, "sword"));
		addToInventory(new Sword(5.0, "sword"));
		addToInventory(new Sword(5.0, "sword"));
		addToInventory(new Sword(5.0, "sword"));
		addToInventory(new Sword(5.0, "sword"));
	}

	public ArrayList<Slot> getInventory() {
		return inventory;
	}

	public void draw(Graphics2D g) {
		if (showOnScreen) {
			g.drawImage(inventoryImage, x, y, null);
			for (int i = 0; i < NUMBEROFSLOTS; i++) {
				inventory.get(i).draw(g);
			}
			if (heldItem != null) {
				g.drawImage(heldItem.getItemImage(), mouseX, mouseY, null);
			}
		}

	}

	public void update() {

	}

	public void addToInventory(Item item) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItem() == null) {
				inventory.get(i).setItem(item);
				break;
			}
		}

	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).mouseEntered(arg0);
		}
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}

	public void mouseExited(MouseEvent arg0) {
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).mouseExited(arg0);
		}
	}

	public void mousePressed(MouseEvent arg0) {
		/*
		 * Check if in slot area, if true, then hold item and set the heldItem
		 * to whatever pressed on If is pressed again and in vicinity of slot
		 * and the slot is null, move item to slot If already holding something
		 * make sure not to be able to switch item held
		 */

		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).isInSlot() && inventory.get(i).getItem() != null && heldItem == null) {
				heldItem = inventory.get(i).getItem();
				inventory.get(i).setItem(null);
			} else if (inventory.get(i).isInSlot() && inventory.get(i).getItem() == null && heldItem != null) {
				inventory.get(i).setItem(heldItem);
				heldItem = null;
			}
		}

	}

	public void mouseReleased(MouseEvent arg0) {

	}

	public boolean isShowOnScreen() {
		return showOnScreen;
	}

	public void setShowOnScreen(boolean showOnScreen) {
		this.showOnScreen = showOnScreen;
	}

}
