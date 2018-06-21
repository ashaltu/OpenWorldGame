import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public abstract class Event implements Drawable,KeyListener,MouseListener{
	EventManager em;
	
	public Event(EventManager em){
		this.em=em;
		init();
	}
	
	public Event(){
		init();
	}
	
	public abstract void init();
	public abstract void keyPressed(KeyEvent arg0);
	public abstract void keyReleased(KeyEvent arg0);
}
