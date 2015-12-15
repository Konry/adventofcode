package thirteen;

public class SittingArrangement {
	private String name = "";
	private int happinessPoints = 0;
	private String sittingNextTo = "";
	
	public SittingArrangement(String name, int happinessPoints, String settingNextTo) {
		this.setName(name);
		this.setHappinessPoints(happinessPoints);
		this.setSittingNextTo(settingNextTo);
	}

	public static SittingArrangement parseArrangement(String s) {
		s = s.replace(" would ", ",");
		s = s.replace(" happiness units by sitting next to ", ",");
		s = s.replace(" ", ",");
		s = s.replace(".", "");
		System.out.println(s);
		String[] split = s.split(",");
		int happinessValue = 0;
		if(split[1].contains("lose")){
			happinessValue = Integer.parseInt(split[2]) * -1;
		}else if(split[1].contains("gain")){
			happinessValue = Integer.parseInt(split[2]);
		}
		return new SittingArrangement(split[0], happinessValue, split[3]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSittingNextTo() {
		return sittingNextTo;
	}

	public void setSittingNextTo(String sittingNextTo) {
		this.sittingNextTo = sittingNextTo;
	}

	public int getHappinessPoints() {
		return happinessPoints;
	}

	public void setHappinessPoints(int happinessPoints) {
		this.happinessPoints = happinessPoints;
	}
}
