package seven;

import java.util.ArrayList;

public class SignalProcessor {
	ArrayList<Wire> wires;
	String[] abc;

	public SignalProcessor() {
		// TODO Auto-generated constructor stub
		wires = new ArrayList<Wire>();
	}
	
	public void addWire(Wire wire){
		boolean positivLookup = false;
		for (Wire w : wires){
			if(w.name == wire.name){
				positivLookup = true;
			}
		}
		if(!positivLookup){
			wires.add(wire);
		}
	}

	public Wire getWire(String wirename) {
		for(Wire w : wires){
			if(w.name.equals(wirename)){
				return w;
			}
		}
		return null;
	}


	public int LShift(String wirename, int shiftby){
		return LShift(getWire(wirename), shiftby);
	}
	public int RShift(String wirename, int shiftby){
		return RShift(getWire(wirename), shiftby);
	}
	public int And(String wirenameOne, String wirenameTwo){
		return And(getWire(wirenameOne), getWire(wirenameTwo));
	}
	public int Or(String wirenameOne, String wirenameTwo){
		return Or(getWire(wirenameOne), getWire(wirenameTwo));
	}
	public int Not(String wirename){
		return Not(getWire(wirename));
	}

	public int LShift(Wire wire, int shiftby){
		return LShift(wire.signal, shiftby);
	}
	
	public int RShift(Wire wire, int shiftby){
		return RShift(wire.signal, shiftby);
	}
	
	public int And(Wire wireOne, Wire wireTwo){
		return And(wireOne.signal, wireTwo.signal);
	}
	
	public int Or(Wire wireOne, Wire wireTwo){
		return Or(wireOne.signal, wireTwo.signal);
	}
	
	public int Not(Wire wire){
		return Not(wire.signal);
	}
	
	public int LShift(int signal, int shiftby) {
		return (signal << shiftby) & Seven.MAX_SHORT;
	}

	public int RShift(int signal, int shiftby) {
		return (signal >> shiftby) & Seven.MAX_SHORT;
	}

	public int And(int signalOne, int signalTwo) {
		return (signalOne & signalTwo) & Seven.MAX_SHORT;
	}

	public int Or(int signalOne, int SignalTwo) {
		return (signalOne | SignalTwo) & Seven.MAX_SHORT;
	}

	public int Not(int i) {
		return (Seven.MAX_SHORT - i) & Seven.MAX_SHORT;
	}

	public void print() {
		System.out.println("wirename --- signal ");
		// TODO Auto-generated method stub
		for(Wire w:wires){
			System.out.println(w.name+ " "+ w.signal);
		}
	}

	public boolean findWire(String string) {
		if(getWire(string) != null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isInteger(String string) {
		try{
			Integer.parseInt(string);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
