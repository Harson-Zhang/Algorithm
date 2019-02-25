package sort;

public class QuickSortWithFlag {
	public static final int LENGTH = 50;	//数组长度为50
	
	public static void quickSort(Num[] A, int left, int right){
		
		if (left < right) {		//没有if，递归回无法终止
			int i = left, j =right;
			Num temp = new Num(A[i].ele, A[i].flag);	//temp为枢轴，将数组第一个数设为枢轴
			
			while (i < j) {		//i和j未汇合以前，执行以下操作
				while (i < j && A[j].ele > temp.ele)	j--;		//j寻找小数字
				if (i < j) {	//找到小数字后换前面去
					A[i].ele = A[j].ele;
					A[i].flag = A[j].flag;
					i++;
				}

				while (i < j && A[i].ele <= temp.ele)	i++;		//i寻找大数字
				if (i < j) {	//找到大数字后换后面去
					A[j].ele = A[i].ele;
					A[j].flag = A[i].flag;
					j--;
				}
			}
			A[i].ele = temp.ele;		//i、j已汇合，是时候将枢轴归位了
			A[i].flag = temp.flag;		//i、j已汇合，是时候将枢轴归位了
			
			quickSort(A, left, i-1);		//递归，i左边执行以上操作
			quickSort(A, i+1, right);		//递归，i右边执行以上操作
		}
	}
	
	public static void main(String[] args) {
		Num[] array = new Num[LENGTH];
		
		System.out.println("原始数组为：");
		for(int i = 0; i<LENGTH; i++){
			array[i] = new Num(1, i);	//数组内数全部相同
			System.out.print(array[i].ele + " ");
		}
		System.out.println();

		long startTime = System.nanoTime(); //获取开始时间
		quickSort(array, 0, LENGTH-1);					//排序算法
		long endTime = System.nanoTime();   //获取结束时间
		
		System.out.println("排序后数组为：");
		for(Num e:array)
			System.out.print(e.ele+" ");
		System.out.println();
		
		System.out.println("排序后他的flag为：");
		for(Num e:array)
			System.out.print(e.flag+" ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

	}

}






