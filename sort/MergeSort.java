package sort;
/*
 * 归并排序，返回void
 */
import java.util.*;

public class MergeSort {
	public static final int LENGTH = 100;	//数组长度为100

	/**********merge**********/	
	//marge实现归并的递归运算
	public static void merge(int[] A, int L1, int R1, int L2, int R2){
		int i = L1, j = L2;
		int[] temp = new int[LENGTH];	//空间复杂度O(n)？
		int index = 0;	//temp数组的下标
		
		while(i<=R1 && j<=R2){
			if(A[i] < A[j]){
				temp[index++] = A[i];
				i++;	//其实可以合并的，但这样一来步骤更清晰。。。
			}else{	//逆序对：在这里做手脚
				temp[index++] = A[j];
				j++;
			}
		}	//退出循环后，i和j中有一方已经到达末端，剩下的步骤就是把另一方剩余的数归入temp数组中
	
		while(i<=R1)	temp[index++] = A[i++];
		while(j<=R2)	temp[index++] = A[j++];
		//目前为止排序完毕，下面将temp数组转移到A数组中
		
		for(int n = 0; n<index; n++){
			A[L1+n] = temp[n]; 
		}
	}
	
	/**********mergeSort**********/	
	//margeSort实现归并排序
	public static void mergeSort(int[] A, int left, int right){
		if(left<right){		//思考：用while还是if？
			int middle = (left + right)/2;
			mergeSort(A, left, middle);			//可怕，递归式写在函数体的前面了，先分割后操作。。和快排先操作后分割不一样那~
			mergeSort(A, middle+1, right);
			merge(A, left, middle, middle+1, right);	
		}
	}
	
	
	/************main*************/
	public static void main(String[] args){

		int[] array = new int[LENGTH];
		Random r = new Random(10);	//定义随机数类，种子设为10
		
		System.out.println("原始数组为：");
		for(int i = 0; i<LENGTH; i++){
			array[i] = r.nextInt(100);	//整数取值1 - 100
			System.out.print(array[i]+" ");
		}
		System.out.println();

		long startTime = System.nanoTime();   //获取开始时间
		mergeSort(array, 0, LENGTH - 1);
		long endTime = System.nanoTime();   //获取结束时间
		
		System.out.println("排序后数组为：");
		for(int ele:array)
			System.out.print(ele+" ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}	
}
//为何每次计算出来的时间都不一样啊！
