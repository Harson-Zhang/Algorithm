package others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * 另类栈
 * 根据输入对1-5的整数进行不同的操作，只有在执行query时才输出
 * @author Administrator1
 *
 */
public class SpecialStack {
	private static void push(Deque<Integer> deque, int v){
		deque.addFirst(v);
	}
	
	private static void pop(Deque<Integer> deque){
		if(deque.size() != 0){
			deque.removeFirst();
		}
	}
	
	private static void delete(Deque<Integer> deque, int v){
		if(deque.size() != 0){
			Deque<Integer> deque2 = new ArrayDeque<Integer>();// 建立新的栈，没找到v之前先把元素压到这个栈内
			while(deque.size()!=0 && deque.peekFirst()!=v){
				deque2.offerFirst(deque.pollFirst());
			}
			if(deque.size() != 0){
				deque.removeFirst();
			}
			deque.offerFirst(deque2.pollFirst());
		}
	}
	
	private static int query(Deque<Integer> deque){
		if(deque.size() != 0){
			return deque.getFirst();
		}else{
			return 0;
		}
	} 
	
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		List<Integer> out = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();	//一共操作多少次
		
		for(int i=0; i<rows; i++){
			String cmd = scanner.next();
			if("push".equals(cmd.substring(0, 4))){
				int v = cmd.charAt(5)-'0';
				push(deque, v);
			}else if("pop".equals(cmd.substring(0, 3))){
				pop(deque);
			}else if("delete".equals(cmd.substring(0, 6))){
				int v = cmd.charAt(7)-'0';
				delete(deque, v);
			}else if("query".equals(cmd.substring(0, 5))){
				out.add(query(deque));
			}
		}
		
		for(int ele:out){
			System.out.println(ele);
		}
		
		scanner.close();
	}
}
