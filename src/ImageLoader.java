import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public ImageLoader(){
		
	}
	
	public static BufferedImage loadImage(String fileName){
		BufferedImage image = null;
		try {
			image = ImageIO.read(ImageLoader.class.getResourceAsStream("/assets/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	public static BufferedImage loadImage(String fileName, int x, int y){
		BufferedImage image = null;
		try {
			image = ImageIO.read(ImageLoader.class.getResourceAsStream("/assets/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image.getSubimage(x, y, image.getWidth(), image.getHeight());
		
		return image;
	}
	
	public static BufferedImage loadImage(String fileName, int x, int y, int width, int height){
		BufferedImage image = null;
		try {
			image = ImageIO.read(ImageLoader.class.getResourceAsStream("/assets/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image.getSubimage(x, y, width, height);
		
		return image;
	}
}
