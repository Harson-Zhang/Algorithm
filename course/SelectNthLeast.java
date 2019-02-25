package course;

import java.util.Random;

public class SelectNthLeast {
	
	// 将数组A从下标p到q之间划分出来，返回“枢轴”的下标
	public static int RandomPartition(int[] A, int p, int q) { 
		Random rand = new Random();
		int index = p + rand.nextInt(q - p); // 生成p~q内随机数，与最后一个数交换
		swap(A, index, q);

		int temp = A[q];	//temp为枢轴，将数组最后一个数设为枢轴
		int i = p, j =q;
		
		while (i < j) {		//i和j未汇合以前，执行以下操作
			while (i < j && A[i] < temp)	i++;		//i寻找大数字
			if (i < j) {	//找到大数字后换后面去
				A[j] = A[i];
				j--;
			}
			
			while (i < j && A[j] >= temp)	j--;		//j寻找小数字
			if (i < j) {	//找到小数字后换前面去
				A[i] = A[j];
				i++;
			}
		}
		A[i] = temp;		//i、j已汇合，是时候将枢轴归位了
		return i;
	}
	
	// 选出第k小的数字
	public static int Select(int [] A, int p, int q, int k) {
		if(p==q) return A[p];
		
		int r = RandomPartition(A, p, q);//r为枢轴的下标
		int i = r-p+1;	//i表示划分结果为第i小
		
		if(i==k){
			return A[r];	//返回值一直有问题，导致错误！！其实就是枢轴啊！！！
		}else if(i > k){
			return Select(A, p, r-1, k);
		}else{
			return Select(A, r+1, q, k-i);
		}
	}

	public static void main(String[] args) {
		int [] A = {12,23,32,14,41,21};
		int k = 2;	//选出第2小元素：14
		System.out.println(Select(A, 0, 5, k));
	}

	// 交换两个元素
	private static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
