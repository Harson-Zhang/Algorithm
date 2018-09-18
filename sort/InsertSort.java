package sort;

import java.util.Random;

public class InsertSort {
	public static final int LENGTH = 100;	//数组长度为100
	
	public static void insertSort(int[] A){
		int temp;
		for(int i = 1; i<A.length; i++){
			temp = A[i];		//i指向正在插入关键字的下标，temp用于储存该关键字
			int j = i-1;			//j用于寻找插入的位置，并辅助挪动数组
			for(; j>=0 && temp<A[j]; j--)	//j>=0，因为待插入的数也可能比A[0]小
								//注意， &&两边的表达式绝对不能换，否则可能数组越界
				A[j+1] = A[j];
			A[j+1] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[LENGTH];
		Random r = new Random(10);	//定义随机数类，种子设为10
		
		System.out.println("原始数组为：");
		for(int i = 0; i<LENGTH; i++){
			array[i] = r.nextInt(100);	//整数取值1 - 100
			System.out.print(array[i]+" ");
		}
		System.out.println();

		long startTime = System.nanoTime(); //获取开始时间
		insertSort(array);					//排序算法
		long endTime = System.nanoTime();   //获取结束时间
		
		System.out.println("排序后数组为：");
		for(int ele:array)
			System.out.print(ele+" ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}	
	
}


