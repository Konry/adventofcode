package fiveteen;

import java.io.File;

import stuff.StringFileReader;

public class Fiveteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] res = StringFileReader.readLinesOfFile(new File("fiveteen.txt"));
		Cakemaer c = new Cakemaer();
		c.generateTeig(res);
	}

}
