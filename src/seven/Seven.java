package seven;

import java.io.File;
import java.util.ArrayList;

import stuff.StringFileReader;

public class Seven {
	public static final int MAX_SHORT = 0x000000000000FFFF;

	public static void main(String[] args) {
		File f = new File("seven2.txt");

		StringFileReader sfr = new StringFileReader();
		String[] lines = StringFileReader.readLinesOfFile(f);
		// TODO Auto-generated method stub
		SignalProcessor sig = new SignalProcessor();
		// String[] workingCopyOfLines = lines;
		ArrayList<String> workingCopyOfLines = new ArrayList<String>();
		for (String s : lines) {
			workingCopyOfLines.add(s);
		}
		System.out.println(lines.length);
		System.out.println(workingCopyOfLines.size());

		while (lines.length > 0) {
			recalculateStrings(lines, sig, workingCopyOfLines);
			System.out.println("length: " + lines.length);
			System.out.println("size: " + workingCopyOfLines.size());
			lines = workingCopyOfLines.toArray(new String[workingCopyOfLines.size()]);
			// System.out.println("length: "+lines.length);
//			sig.print();
		}
		sig.print();
	}

	private static void recalculateStrings(String[] lines, SignalProcessor sig, ArrayList<String> workingCopyOfLines) {
//		sig.print();
		sleep500();
//		for (String s : lines) {
//			System.out.println(s);
//		}
//		sleep500();
		// System.out.println(lines.length);
		// System.out.println(workingCopyOfLines.size());
		for (String l : lines) {
			// System.out.println(l);
			if (l == null) {
				break;
			}
			boolean toRemove = false;
			String[] splitDestination = l.split(" -> ");
			if (splitDestination[0].contains("AND")) {
				/* and part */
				String[] temp = splitDestination[0].replace(" AND ", ",").split(",");
				if (sig.findWire(temp[0]) && sig.findWire(temp[1])) {
					sig.addWire(new Wire(splitDestination[1], sig.And(temp[0], temp[1])));
					toRemove = true;
				}else {
					if(sig.isInteger(temp[0]) && sig.findWire(temp[1])){
						System.out.println("Is integer temp0: "+temp[0]);
						sig.addWire(new Wire(splitDestination[1], sig.And(Integer.parseInt(temp[0]), sig.getWire(temp[1]).signal)));
						toRemove = true;
					}else if (sig.isInteger(temp[1]) && sig.findWire(temp[0])){
						System.out.println("Is integer temp1: "+temp[1]);
						sig.addWire(new Wire(splitDestination[1], sig.And(Integer.parseInt(temp[1]), sig.getWire(temp[0]).signal)));
						toRemove = true;
					}
//					System.out.println("not remove because of "+temp[0]+ " and "+temp[1]);
				}
			} else if (splitDestination[0].contains("OR")) {
				/* or part */
				String[] temp = splitDestination[0].replace(" OR ", ",").split(",");
				if (sig.findWire(temp[0]) && sig.findWire(temp[1])) {
					sig.addWire(new Wire(splitDestination[1], sig.Or(temp[0], temp[1])));
					toRemove = true;
				}else {
					if(sig.isInteger(temp[0]) && sig.findWire(temp[1])){
						System.out.println("Is integer temp0: "+temp[0]);
						sig.addWire(new Wire(splitDestination[1], sig.Or(Integer.parseInt(temp[0]), sig.getWire(temp[1]).signal)));
						toRemove = true;
					}else if (sig.isInteger(temp[1]) && sig.findWire(temp[0])){
						System.out.println("Is integer temp1: "+temp[1]);
						sig.addWire(new Wire(splitDestination[1], sig.Or(Integer.parseInt(temp[1]), sig.getWire(temp[0]).signal)));
						toRemove = true;
					}
//					System.out.println("not remove because of "+temp[0]+ " and "+temp[1]);
				}
			} else if (splitDestination[0].contains("RSHIFT")) {
				/* lshift part */
				String[] temp = splitDestination[0].replace(" RSHIFT ", ",").split(",");
				if (sig.findWire(temp[0])) {
					sig.addWire(new Wire(splitDestination[1], sig.RShift(temp[0], Integer.parseInt(temp[1]))));

					toRemove = true;
				}else {
//					System.out.println("not remove because of "+temp[0]);
				}
			} else if (splitDestination[0].contains("LSHIFT")) {
				/* rshift part */
				String[] temp = splitDestination[0].replace(" LSHIFT ", ",").split(",");
				if (sig.findWire(temp[0])) {
					sig.addWire(new Wire(splitDestination[1], sig.LShift(temp[0], Integer.parseInt(temp[1]))));

					toRemove = true;
				}else {
//					System.out.println("not remove because of "+temp[0]);
				}
			} else if (splitDestination[0].contains("NOT")) {
				/* not part */
				String[] temp = splitDestination[0].replace("NOT ", "").split(",");
				if (sig.findWire(temp[0])) {
					sig.addWire(new Wire(splitDestination[1], sig.Not(temp[0])));
					toRemove = true;
				}else {
//					System.out.println("not remove because of "+temp[0]);
				}
			} else {
				/* new variable */
				// System.out.println(l);
				// System.out.println(splitDestination[0]);
				// System.out.println(splitDestination[1]);
				try {
					sig.addWire(new Wire(splitDestination[1], Integer.parseInt(splitDestination[0])));
					toRemove = true;
				} catch (NumberFormatException e) {
					if (sig.findWire(splitDestination[0])) {
						sig.addWire(new Wire(splitDestination[1], sig.getWire(splitDestination[0]).signal));
						toRemove = true;
					}
				}
			}
			if (toRemove) {
				// System.out.println("Remove");
				int index = 0;
				for (int i = 0; i < workingCopyOfLines.size(); i++) {
					if (workingCopyOfLines.get(i).equals(l)) {
						System.out.println("remove: "+workingCopyOfLines.get(i)+" ### "+l);
						// System.out.println("remove: " + l);
						break;
					}
					index++;
				}
				// System.out.println("remove");
				// System.out.println(l);
				workingCopyOfLines.remove(index);

			}
		}
	}

	private static void sleep500() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
