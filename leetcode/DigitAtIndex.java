package leetcode;

import java.util.Scanner;

/**
 * 剑指offer 44 数字序列中某一位数字 描述：某序列以 01234567891011121314151617...排布
 * 求：下标为index的数字为多少（从0开始计数）
 * 
 * @author Harson
 *
 */
public class DigitAtIndex {

	public static int digitAtIndex(int index) {
		if (index < 0) {
			return -1;
		}

		if (index == 0) {
			return 0;
		}

		int floor = 0, ceil = 1, digit = 0;
		while(true){
			if(index >= floor && index < ceil){
				break;
			}
			floor = ceil;
			ceil += 9 * (int)Math.pow(10, digit) * (digit + 1);
			++digit;
		}
		
		int number = (index - floor)/digit + (int)Math.pow(10, digit-1);
		int indexInNum = (index - floor) % digit;
		String numStr = number + "";
		return numStr.charAt(indexInNum) - '0';
	}

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while(scanner.hasNextInt()){
//			System.out.println(digitAtIndex(scanner.nextInt()));
//		}
		for(int i = 12324; i<12358; i++){
			System.out.print(digitAtIndex(i));
		}
	}

}
