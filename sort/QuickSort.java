package sort;

import java.util.Random;

public class QuickSort {
	public static final int LENGTH = 100;	//数组长度为100
	public static void quickSort(int[] A, int left, int right){
		
		if (left < right) {		//没有if，递归回无法终止
			int i = left, j =right;
			int temp = A[i];	//temp为枢轴，将数组第一个数设为枢轴
			
			while (i < j) {		//i和j未汇合以前，执行以下操作
				while (i < j && A[j] >= temp)	j--;		//j寻找小数字
				if (i < j) {	//找到小数字后换前面去
					A[i] = A[j];
					i++;
				}

				while (i < j && A[i] < temp)	i++;		//i寻找大数字
				if (i < j) {	//找到大数字后换后面去
					A[j] = A[i];
					j--;
				}
			}
			A[i] = temp;		//i、j已汇合，是时候将枢轴归位了
			quickSort(A, left, i-1);		//递归，i左边执行以上操作
			quickSort(A, i+1, right);		//递归，i右边执行以上操作
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
