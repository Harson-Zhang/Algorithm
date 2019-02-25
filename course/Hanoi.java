package course;

//算法思想：要把src上的盘子移到des上，【Step1】必须先将上面n-1个盘子移到medium上，
//【Step2】再把剩下最后一个盘子移到des上，【Step】最后把medium上的n-1个盘子移到des上。
public class Hanoi {
	//把src上的一个盘子移到des上
	public static void move(char scr, char des){
		System.out.println(scr + " ==> " + des);
	}
	
	//将src上的n个盘子移到des上
	public static void hanoi(int n, char scr, char med, char des){
		if(n == 1){
			move(scr, des);	//这一步还是有疑问。。。
		}else{
		hanoi(n-1, scr, des, med);	//Step1
		move(scr, des);				//Step2
		hanoi(n-1, med, scr, des);	//Step3
		}
	}
	
	static public void main(String[] args){
		hanoi(25, 'a', 'b', 'c');
	}
}
