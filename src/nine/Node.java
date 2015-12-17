package nine;

public class Node {
	boolean visited = false;
	String city = "";
	
	public Node(String city) {
		this.city = city;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
