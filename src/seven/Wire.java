package seven;
	public class Wire{
		int signal;
		String name;
		
		Wire(String name){
			this.name = name;
			signal = 0;
		}
		
		Wire(String name, int signal){
			this.name = name;
			this.signal = signal;
		}
	}