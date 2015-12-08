package three;

import java.util.LinkedList;

public class GiftList {
	/* Three */

	LinkedList<GiftMapObject> giftList = null;

	public GiftList() {
		giftList = new LinkedList<GiftMapObject>();
		giftList.add(new GiftMapObject(0, 0));
	}
	
	public GiftList(int gifts) {
		giftList = new LinkedList<GiftMapObject>();
		giftList.add(new GiftMapObject(0, 0, gifts));
	}


	public void add(GiftMapObject gift) {
//		System.out.println(gift.length + " "+gift.width + " "+gift.gifts);
		boolean added = false;
		for (GiftMapObject obj : giftList) {
			if (gift.length == obj.length && gift.width == obj.width) {
//				System.out.println("Object found! ");
				obj.gifts++;
				added = true;
				return;
			} else {

			}
		}
		// if (added == false) {

//		System.out.println("Object not found!");
		giftList.add(new GiftMapObject(gift.length, gift.width));
		// }
	}

	public int size() {
//		System.out.println("size of list: " + giftList.size());
		for(GiftMapObject obj : giftList){
//			System.out.println(obj.length + " "+obj.width + " "+ obj.gifts);
		}
		return giftList.size();
	}
}
