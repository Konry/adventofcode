package six;

public class LightsOn {
	int[][] lightGrid;

	public LightsOn() {
		lightGrid = new int[1000][1000];
	}

	public int countLightsOn() {
		int sum = 0;
		for (int i = 0; i <= 999; i++) {
			for (int j = 0; j <= 999; j++) {
				if (lightGrid[i][j] > 0) {
					sum++;
				}
			}
		}
		return sum;
	}

	public int countBrightness() {
		int sum = 0;
		for (int i = 0; i <= 999; i++) {
			for (int j = 0; j <= 999; j++) {
				if (lightGrid[i][j] > 0) {
					sum += lightGrid[i][j];
				}
			}
		}
		return sum;
	}

	public void turnOn(int start_x, int start_y, int end_x, int end_y) {
		for (int i = start_x; i <= end_x; i++) {
			for (int j = start_y; j <= end_y; j++) {
				lightGrid[i][j]++;
			}
		}
	}

	public void turnOff(int start_x, int start_y, int end_x, int end_y) {
		for (int i = start_x; i <= end_x; i++) {
			for (int j = start_y; j <= end_y; j++) {
				if (lightGrid[i][j] > 0)
					lightGrid[i][j]--;
			}
		}
	}

	public void toggle(int start_x, int start_y, int end_x, int end_y) {
		for (int i = start_x; i <= end_x; i++) {
			for (int j = start_y; j <= end_y; j++) {
				lightGrid[i][j] += 2;
			}
		}
	}

}
