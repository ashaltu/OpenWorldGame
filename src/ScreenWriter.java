import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ScreenWriter {
	private String characters = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "0123456789!?:+-.,$#&()\\'\" ";
	private HashMap<Character, BufferedImage> alphabet;
	private BufferedImage pixelFont;

	public ScreenWriter(int screenWidth, int screenHeight) {
		init(screenWidth, screenHeight);
	}

	private void init(int width, int height) {
		alphabet = new HashMap<Character, BufferedImage>();
		pixelFont = ImageLoader.loadImage("pixelFont");
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 26; column++) {
				alphabet.put(characters.charAt((row * 26) + column),
						pixelFont.getSubimage((1 + column) + (8 * column), (1 + row) + (8 * row), 8, 8));
			}
		}
	}

	public void printOnScreen(Graphics2D g, String message, int x, int y) {
		for (int i = 0; i < message.length(); i++) {
			g.drawImage(alphabet.get(message.charAt(i)), x+i*16, y,16,16, null);

		}
	}
}
