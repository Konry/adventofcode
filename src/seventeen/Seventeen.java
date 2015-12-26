package seventeen;

import java.io.File;

import stuff.StringFileReader;

public class Seventeen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] read = StringFileReader.readLinesOfFile(new File("seventeen.txt"));
		
		FillContainer c = new FillContainer();
		c.Load(read);
		c.tryOut(150);
		//c.calc(150);
	}

}
