
import javax.swing.JFrame;
//Version 0.1
//By Abdul Shaltu
public class Game {
	public static final double VERSION = 0.1; //////////////////////<<<CURRENT GAME VERSION
	public static void main(String[] args) {
		Screen screen = new Screen();
		screen.setSize(Screen.WIDTH, Screen.HEIGHT);
		JFrame jf = new JFrame();
		jf.setTitle("Open World Game");
		jf.setSize(Screen.WIDTH, Screen.HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setContentPane(screen);
		jf.setVisible(true);
		screen.setVisible(true);
		
	}
}
