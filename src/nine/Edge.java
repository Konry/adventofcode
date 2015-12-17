package nine;

public class Edge {
	int distance = -1;
	String cityOne;
	String cityTwo;
	
	public Edge(String cityOne, String cityTwo, int distance) {
		this.cityOne = cityOne;
		this.cityTwo = cityTwo;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getCityOne() {
		return cityOne;
	}

	public void setCityOne(String cityOne) {
		this.cityOne = cityOne;
	}

	public String getCityTwo() {
		return cityTwo;
	}

	public void setCityTwo(String cityTwo) {
		this.cityTwo = cityTwo;
	}
	
}
