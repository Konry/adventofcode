package fiveteen;

public class Cake {
	
	String name;
	int capacity;
	int durability;
	int flavor;
	int texture;
	int calories;
	
	public Cake(String name, int capacity, int duability, int flavor,int texture,int calories){
		this.name = name;
		this.capacity = capacity;
		this.durability = duability;
		this.flavor = flavor;
		this.texture = texture;
		this.calories = calories;
		
	}
	
	public static Cake parseCake(String cake){
		cake = cake.replace(": capacity ", ",");
		cake = cake.replace(" durability ", "");
		cake = cake.replace(" flavor ", "");
		cake = cake.replace(" texture ", "");
		cake = cake.replace(" calories ", "");
		System.out.println(cake);
		String[] split = cake.split(",");
		
		return new Cake(split[0], 
				Integer.parseInt(split[1]),
				Integer.parseInt(split[2]),
				Integer.parseInt(split[3]),
				Integer.parseInt(split[4]),
				Integer.parseInt(split[5]));
	}
}
