import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class EventManager implements KeyListener , MouseListener {

	public static final int MENU_EVENT = 1;
	public static final int PLAY_EVENT = 2;
	private int currentEvent;
	private ArrayList<Event> events;

	public EventManager() {
		events = new ArrayList<Event>();
		events.add(new Menu(this));
		events.add(new Play());
		currentEvent = 0;
	}

	public void draw(Graphics2D g) {
		events.get(currentEvent).draw(g);
	}

	public void update() {
		events.get(currentEvent).update();

	}

	public void init() {
		events.get(currentEvent).init();

	}

	public void keyPressed(KeyEvent arg0) {
		events.get(currentEvent).keyPressed(arg0);

	}

	public void keyReleased(KeyEvent arg0) {
		events.get(currentEvent).keyReleased(arg0);

	}
	
	public void keyTyped(KeyEvent arg0){
		events.get(currentEvent).keyTyped(arg0);
	}

	public int getCurrentEventSelection() {
		return currentEvent;
	}

	public void setCurrentEventSelection(int num) {
		currentEvent = num-1;
	}

	public void mouseClicked(MouseEvent paramMouseEvent) {
		events.get(currentEvent).mouseClicked(paramMouseEvent);
	}

	public void mousePressed(MouseEvent paramMouseEvent) {
		events.get(currentEvent).mousePressed(paramMouseEvent);
	}

	public void mouseReleased(MouseEvent paramMouseEvent) {
		events.get(currentEvent).mouseReleased(paramMouseEvent);
	}

	public void mouseEntered(MouseEvent paramMouseEvent) {
		events.get(currentEvent).mouseEntered(paramMouseEvent);
	}

	public void mouseExited(MouseEvent paramMouseEvent) {
		events.get(currentEvent).mouseExited(paramMouseEvent);
	}

}
