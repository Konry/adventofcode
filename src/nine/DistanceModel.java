package nine;

public class DistanceModel{
	String start;
	String end;
	int distance;
	
	public DistanceModel(String start, String end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String print(){
		return start+" to "+end+" : "+String.valueOf(distance);
	}
}