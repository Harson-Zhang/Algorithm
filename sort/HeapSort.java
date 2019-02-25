package sort;

import java.util.Random;

public class HeapSort {
	public static final int LENGTH = 50;	//数组长度为50
	//在数组low - high范围内，完成对结点A[low]的调整
	 static void sift(int[] A, int low, int high){
		int i = low, j = 2*i;	//i为父亲，j为孩子
		int temp = A[i];
		//下面整个循环完成对A[low]的一次调整
		while(j <= high){
			if(j<high && A[j+1] > A[j]){	//哪个孩子大，j指向哪个
				j++;
			}
			if(A[j] > temp){	//孩子比temp大，孩子当爹
				A[i] = A[j];	//注意，是A[j] > temp，而不是A[j] > A[i]
				i = j;
				j = 2*i;
			}else				//孩子比不上temp，则没有调整的必要
				break;
		}
		A[i] = temp;		//temp归位
	}
	
	//堆排序函数
	 static void heapSort(int[] A){
		for(int i = A.length/2; i>=0; i--){	//初始化堆排序
			sift(A, i, A.length - 1);
		}
		for(int i = A.length - 1; i>1; i--){	//进行多轮sift，每次sift后交换顶部结点到末端
			int temp = A[i];
			A[0] = A[i];
			A[i] = temp;
			sift(A, 0, i-1);
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
		heapSort(array);					//排序算法
		long endTime = System.nanoTime();   //获取结束时间
		
		System.out.println("排序后数组为：");
		for(int ele:array)
			System.out.print(ele+" ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

	}

}
