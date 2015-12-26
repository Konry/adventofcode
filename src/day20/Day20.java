package day20;

import java.util.ArrayList;

public class Day20 {
	public static ArrayList<Integer> divisorList = new ArrayList();
	public static void main(String[] args){
		long index = 786241;
		while(calcSumForNumber(index++) != 34000000){
		}
	}
	
	public static long calcSumForNumber(long number){
		if(number % 1000 == 0){
			System.out.println(number);
		}
		long sumOfAllDivisors = 0;
		for(long i = number/50; i <= number/2; i++){
			if(number % i == 0 && i * 50 >= number){
				sumOfAllDivisors += i;
			}
		}
		sumOfAllDivisors += number;
		if(sumOfAllDivisors*11 >= 34000000){
			System.out.println("YOLO "+number);
		}
		return sumOfAllDivisors * 11;
	}
	
}
