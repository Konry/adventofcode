package day23;

import java.io.File;
import java.util.ArrayList;

import stuff.StringFileReader;

public class Day23 {

	public static void main(String[] args) {
		String[] inst = StringFileReader.
				readLinesOfFile(new File("day23.txt"));
		
		TouringLock tl = new TouringLock(1, 0);
		tl.load(inst);
		tl.runCode();
	}

	public static class Instruction {
		String instruction;
		String register;
		int jumpOffset = -1;

		public Instruction(String instruction, String register) {
			this.instruction = instruction;
			this.register = register;
		}

		public Instruction(String instruction, String register, int jumpOffset) {
			this.instruction = instruction;
			this.register = register;
			this.jumpOffset = jumpOffset;
		}
	}

	public static class TouringLock {
		int registerA = 0;
		int registerB = 0;

		ArrayList<Instruction> instrList = new ArrayList<>();

		public TouringLock(int registerA, int registerB) {
			this.registerA = registerA;
			this.registerB = registerB;
		}

		public void load(String[] listOfInstructions) {
			for (String s : listOfInstructions) {
				String[] tempSplit = s.split(" ");
				if (s.startsWith("jio")) {
					String[] secondSplit = tempSplit[1].split(",");
					instrList.add(new Instruction("jio", secondSplit[0], toJumpToInt(tempSplit[2])));
				} else if (s.startsWith("jie")) {
					String[] secondSplit = tempSplit[1].split(",");
					instrList.add(new Instruction("jie", secondSplit[0], toJumpToInt(tempSplit[2])));
				} else if (s.startsWith("jmp")) {
					instrList.add(new Instruction("jmp", "", toJumpToInt(tempSplit[1])));
				} else if (s.startsWith("inc")) {
					instrList.add(new Instruction("inc", tempSplit[1]));
				} else if (s.startsWith("tpl")) {
					instrList.add(new Instruction("tpl", tempSplit[1]));
				} else if (s.startsWith("hlf")) {
					instrList.add(new Instruction("hlf", tempSplit[1]));
				}
			}
		}

		public void runCode() {
			boolean ended = false;

			int index = 0;
			int count = 0;
			
			while (!ended) {
				count++;
				if (index >= instrList.size()) {
					ended = true;
				} else {
					System.out.println("run instruction "+index+ " "+instrList.get(index).instruction);
					Instruction instr = instrList.get(index);

					switch (instr.instruction) {
					case "hlf":
						if (instr.register.equals("a")) {
							registerA /= 2;
						} else if (instr.register.equals("b")) {
							registerB /= 2;
						}
						index++;
						break;
					case "tpl":
						if (instr.register.equals("a")) {
							registerA *= 3;
						} else if (instr.register.equals("b")) {
							registerB *= 3;
						}
						index++;
						break;
					case "inc":
						if (instr.register.equals("a")) {
							registerA++;
						} else if (instr.register.equals("b")) {
							registerB++;
						}
						index++;
						break;
					case "jmp":
						index += instr.jumpOffset;
						break;
					case "jie":
						if (instr.register.equals("a") && registerA % 2 == 0) {
							index += instr.jumpOffset;
						} else if (instr.register.equals("b") && registerB % 2 == 0) {
							index += instr.jumpOffset;
						} else {
							index++;
						}
						break;
					case "jio":
						if (instr.register.equals("a") && registerA == 1) {
							index += instr.jumpOffset;
						} else if (instr.register.equals("b") && registerB == 1) {
							index += instr.jumpOffset;
						} else {
							index++;
						}
						break;
					default:
						break;
					}
				}
			}
			System.out.println(count);
			System.out.println("registerA "+registerA);
			System.out.println("registerB "+registerB);
		}

		private int toJumpToInt(String secondSplit) {
			return Integer.parseInt(secondSplit.replace("+", ""));
		}
	}

}
