import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Currency implements Drawable{
	private BufferedImage goldImage;
	private double gold;
	private int x,y;
	private ScreenWriter sw;
	public Currency(double goldAmount,int x, int y){
		gold = goldAmount;
		goldImage = ImageLoader.loadImage("gold");
		this.x=x;
		this.y=y;
		sw = new ScreenWriter(Screen.WIDTH,Screen.HEIGHT);
	}
	public Currency(double goldAmount){
		gold = goldAmount;
		goldImage = ImageLoader.loadImage("gold");
		this.x=100;
		this.y=50;
		sw = new ScreenWriter(Screen.WIDTH,Screen.HEIGHT);
	}
	
	public Currency(){
		gold = 100;
		goldImage = ImageLoader.loadImage("gold");
		this.x=Screen.WIDTH-150;
		this.y=10;
		sw = new ScreenWriter(Screen.WIDTH,Screen.HEIGHT);
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(goldImage, x, y,null);
		sw.printOnScreen(g, ":"+String.valueOf((int)gold), x+goldImage.getWidth()+5, y);
	}

	@Override
	public void update() {
		
	}
	
	public void checkGold(){
		if(gold<0){
			gold=0;
		}
	}
	
	public boolean checkEnoughGold(double amount){
		if(gold-amount<0){
			return false;
		}
		return true;
	}
	
	public void addGold(int amount)
	{
		gold+=amount;
	}
	
	public void removeGold(int amount){
		gold-=amount;
	}
	
	public double getGold(){
		return gold;
	}
}
