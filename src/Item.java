import java.awt.image.BufferedImage;

public abstract class Item {

	private double valueOfItem;
	private BufferedImage itemImage;

	public Item(double valueOfItem,String fileName) {
		this.valueOfItem = valueOfItem;
		itemImage = ImageLoader.loadImage(fileName);
	}

	public void setValueOfItem(double newValue){
		valueOfItem=newValue;
	}
	public double getValueOfItem(){
		return valueOfItem;
	}

	public BufferedImage getItemImage(){
		return itemImage;
	}
	
}
