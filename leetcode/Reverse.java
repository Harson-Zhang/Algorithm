package leetcode;


public class Reverse {
	public static int reverse(int x) {
        
		int[] array = new int[32];	//用于保存取余得到的数
		int i = 0;
		//不断的取余和整除
		while(x != 0){
			array[i] = x%10;
			x = x/10;
			i++;
		}
		int count = i;	//结束时i刚好代表位数，所以用count代替
		
		int res=0;		//记录最后的结果
		for(int j = 0; j<count; j++, i-- ){
			res += array[j]*Math.pow(10, i-1);
		}
		
		return res;
    }
	
	public static void main(String[] args){
		int a = 1534236469;
		int b = -123;
		int c = 120;
		System.out.println(reverse(a));
		System.out.println(reverse(b));
		System.out.println(reverse(c));
	}
	
	
}
