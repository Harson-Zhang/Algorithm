package sort;

import java.util.Random;

public class QuickSort {
	public static final int LENGTH = 100;	//数组长度为100
	public static void quickSort(int[] A, int left, int right){
		int i = left, j =right;
		
		if(i<j){
			 
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
		quickSort(array, 0, LENGTH-1);					//排序算法
		long endTime = System.nanoTime();   //获取结束时间
		
		System.out.println("排序后数组为：");
		for(int ele:array)
			System.out.print(ele+" ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

	}

}
