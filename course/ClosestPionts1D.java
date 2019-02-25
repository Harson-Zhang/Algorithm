package course;
//一维最近点对问题的实现
public class ClosestPionts1D {
	final static int INF =  2147483640;
	
	public static boolean Cpair1(int [] S, int i, int j, int d){
		if(j - i < 1) { 	//子集数量为1或0，则不存在最近点对
			d = INF;
			return false;
		}
		
		int m = S[(j-i)/2];		//m是子集的中位数
		int n = j-i+1;			//子集大小为n
		
		Cpair1(S, i, m, d);	//d1怎么求？？？不会啊！！！！
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] S = {-20, -1, -40, 3, 6, 11, 18, 9, -7};
		
	}

}
