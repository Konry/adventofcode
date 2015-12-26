package eightteen;

public class Lightshow {
	char[][] initialArray = new char[100][100];
	int size = 3;
	
	void fillLightArray(String[] lightArray){
		size = lightArray.length;
		initialArray = new char[lightArray.length][lightArray.length];
		int i = 0;
		int j = 0;
		for(String s : lightArray){
			for(char c : s.toCharArray()){
				initialArray[i][j++] = c;
			}
			i++;
			j = 0;
		}
	}
	
	void PlayGame(int rounds){
		char[][] game = initialArray;
		
		for(int i = 0; i < rounds; i++){
			//PrintArray(game);
			game = playRound(game);
		}
		PrintArray(game);
		System.out.println(countHash(game));
	}

	private char[][] playRound(char[][] game) {
		char[][] newField = new char[size][size];
		for(int i = 0; i < size; i++){
			for (int j = 0; j <size; j++){
				int sumOfHash = sumOfRaute(i, j, game);
				if(i==0 && j ==0 || i == size-1 && j == size-1 || i == 0 && j == size-1 || j == 0 && i == size-1 ){
					newField[i][j] = '#';
				}else
				if(sumOfHash == 3){
					newField[i][j] = '#';
				}else if(sumOfHash == 2 && game[i][j] == '#'){
					newField[i][j] = '#';
				} else {
					newField[i][j] = '.';
				}
			}
		}
		return newField;
	}
	
	private int sumOfRaute(int i, int j, char[][] game){
		int index_x_min = i-1;
		int index_x_max = i+1;
		int index_y_min = j-1;
		int index_y_max = j+1;
		if(index_x_min < 0){
			index_x_min = 0;
		}else if(index_x_max >= size){
			index_x_max = size-1;
		}
		if(index_y_min < 0){
			index_y_min = 0;
		} else if(index_y_max >= size){
			index_y_max = size-1;
		}
		int sumOfHash = 0;
		for(int k = index_x_min; k <= index_x_max ; k++){
			for(int l = index_y_min; l <= index_y_max; l++){
				if(game[k][l] == '#' && !(k == i && l == j)){
					sumOfHash++;
				}
			}
		}
		//System.out.println("sum for: "+i+ " "+j+ " "+sumOfHash);
		return sumOfHash;
	}
	
	private int countHash(char[][] game){
		int count = 0;
		for(int k = 0; k < size ; k++){
			for(int l = 0; l < size; l++){
				if(game[k][l] == '#'){
					count++;
				}
			}
		}
		return count;
	}
	
	private void PrintArray(char[][] game){
		System.out.println();
		for(int k = 0; k < size ; k++){
			for(int l = 0; l < size; l++){
					System.out.print(game[k][l]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
