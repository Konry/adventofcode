package day25;

public class Day25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherMaschineCode wmc = new WeatherMaschineCode(20151125);
		System.out.println(wmc.calcManualBook(3010, 3019));
	}

	public static class WeatherMaschineCode {
		int[][] manualBook;

		private int startingCode = 0;

		public WeatherMaschineCode(int startingCode) {
			this.startingCode = startingCode;
		}

		public int calcManualBook(int row, int col) {
			int calcToRow = row + col - 1;
			manualBook = new int[calcToRow][calcToRow];
			manualBook[0][0] = startingCode;

			int level = 2;

			boolean filledUp = false;
			int lastValue = manualBook[0][0];
			while (!filledUp) {
				int j = 1;
				for (int i = level; i > 0; i--) {
					manualBook[i - 1][j - 1] = calcValue(lastValue);
					lastValue = manualBook[i - 1][j - 1];
					if (row == i && col == j) {
						return manualBook[row - 1][col - 1];
					}
					j++;
				}
				level++;
			}

			return manualBook[row - 1][col - 1];
		}

		private int calcValue(int lastValue) {
			long result = lastValue;
			result *= 252533;
			return (int) (result % 33554393);
		}
	}
}
