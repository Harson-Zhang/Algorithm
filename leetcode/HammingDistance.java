package leetcode;

public class HammingDistance {

	public static int hammingDistance(int x, int y) {
        int z = x^y;
        int cnt = 0;
        String str = Integer.toBinaryString(z);
        char[] c = str.toCharArray();
        for(char ele:c){
        	if(ele == '1')	cnt++;
        }
        
        return cnt;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

}
