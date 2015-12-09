package three;

public class GiftMapObject {
	int length = 0;
	int width = 0;
	int gifts = 0;

	public GiftMapObject(int length, int width) {
		this.length = length;
		this.width = width;
		gifts = 1;
	}
	
	public GiftMapObject(int length, int width, int gifts) {
		this.length = length;
		this.width = width;
		this.gifts = gifts;
	}

	public void addGift() {
		gifts++;
	}
}