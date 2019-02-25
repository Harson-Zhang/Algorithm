<<<<<<< HEAD
package leetcode;

public class Huiwenshu {
	//方法一：转换字符法
//	public static boolean isPalindrome(int x) {
//        String str = String.valueOf(x);
//        boolean flag = true;	//flag为true时表示是回文数
//        char[] arr = str.toCharArray();	//字符串转变为数组
//        
//        for(int i = 0; i<str.length(); i++)
//        	if(arr[i] != arr[str.length()-i-1]){
//        		flag = false;
//        		break;
//        	}
//        return flag;
//    }
	
	//方法二：数值运算法
	public static boolean isPalindrome(int x){
		if(x<0 || (x%10 == 0 && x != 0)){
			return false;
		}
		
		int reNum = 0;
		while(x>reNum){
			reNum = reNum*10 + x%10;
			x = x/10;
		}
		
		return x==reNum || x==reNum/10;
		
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(12421));
		System.out.println(isPalindrome(0));
	}
}

=======
package leetcode;

public class Huiwenshu {
	//方法一：转换字符法
//	public static boolean isPalindrome(int x) {
//        String str = String.valueOf(x);
//        boolean flag = true;	//flag为true时表示是回文数
//        char[] arr = str.toCharArray();	//字符串转变为数组
//        
//        for(int i = 0; i<str.length(); i++)
//        	if(arr[i] != arr[str.length()-i-1]){
//        		flag = false;
//        		break;
//        	}
//        return flag;
//    }
	
	//方法二：数值运算法
	public static boolean isPalindrome(int x){
		if(x<0 || (x%10 == 0 && x != 0)){
			return false;
		}
		
		int reNum = 0;
		while(x>reNum){
			reNum = reNum*10 + x%10;
			x = x/10;
		}
		
		return x==reNum || x==reNum/10;
		
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(12421));
		System.out.println(isPalindrome(0));
	}
}

>>>>>>> 7248ac3bb0d8b5ce7fa13c3c58b826ffd72d4513
