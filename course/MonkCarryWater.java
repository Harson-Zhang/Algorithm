package course;

public class MonkCarryWater {
	public final static int day = 7;		//一周8天？先改为7天
	public final static int m = 7;			//和尚个数7个
	
	public int spare[][] = new int[day][m];	//周=day，和尚=m是否有空
	public int monk[] = new int[day];	//输出结果：周一至周末值日的和尚
	public int done[] = new int[day];	//约束条件之一：用来存放和尚在星期day是否值日过
	
	
	public static void main(String[] args) {
		
	}

}
