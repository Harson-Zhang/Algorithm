package course;
/*
 * 归并排序的修改，成为逆序对
 */
import java.util.*;

public class Nixvdui {
	public static final int LENGTH = 100;	//数组长度为100

	/**********merge**********/	
	//marge实现归并的递归运算
	public static void merge(int[] A, int L1, int R1, int L2, int R2){
		int i = L1, j = L2;
		int[] temp = new int[LENGTH];
		int index = 0;	//temp数组的下标
		
		while(i<=R1 && j<=R2){
			if(A[i] < A[j]){
				temp[index++] = A[i];
				i++;	//其实可以合并的，但这样一来步骤更清晰。。。
			}else{		//逆序对：在这里做手脚
				if(A[i] > A[j])
					System.out.printf(A[i]+ " - " + A[j] + "\n");
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
			mergeSort(A, left, middle);
			mergeSort(A, middle+1, right);
			merge(A, left, middle, middle+1, right);
		}
	}
	
	
	/******main*******/
	public static void main(String[] args){

		int[] array = new int[LENGTH];
		Random r = new Random(10);	//定义随机数类，种子设为100
		
		System.out.print("原始数据为：");
		for(int i = 0; i<LENGTH; i++){
			array[i] = r.nextInt(100);
			System.out.print(array[i]+" ");
		}
		System.out.println();

		mergeSort(array, 0, LENGTH - 1);

	}	
}
//为何每次计算出来的时间都不一样啊！
