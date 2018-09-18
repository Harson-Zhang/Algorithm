package course;
/*
 * 寻找众数与重数，使用集合Map传值
 */

import java.util.*;
import sort.MergeSort;

public class Mode_ZhongShu {
	public static final int LENGTH = 50;
	
	//返回数组A的众数和重数的函数
	public static HashMap<String, Integer> modeMult(int[] A){
		//首先对数组进行从小到大的排序
		int[] temp = new int[LENGTH];	//用于存储排序结果的临时数组(开销可大了。。。)
		for(int i = 0; i<LENGTH; i++)
			temp[i] = A[i];
		MergeSort.mergeSort(temp, 0, LENGTH-1);
		
		//然后从前往后遍历数组，找出出现次数最多的那个数
		int mode = 0, mult = 1;			//众数和重数
		int cnt = 1;	//记录当前数出现的次数
		for(int i = 1; i<LENGTH; i++){
			if(temp[i] == temp[i-1]){	//要考虑数组越界哦！！！
				cnt++;
				if(cnt > mult){		//如果当前数出现次数大于之前最多的数，就记下来
					mode = temp[i];
					mult = cnt;
				}
			}else{
				cnt = 1;	//如果数字变化了
			}
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Mode", mode);
		map.put("Multiplicity", mult);
		return map;
	}
	

	public static void main(String[] args) {
		int[] array = new int[LENGTH];
		Random r = new Random(10);
		for(int i = 0; i<LENGTH - 1; i++){
			array[i] = r.nextInt(20);
			System.out.print(array[i] + " ");
		}	
		System.out.println();
		//定义一个大小为50的随机数组，随机种子为10，取值1-20

		Map<String, Integer> map = new HashMap<String, Integer>();
		map = modeMult(array);
		System.out.println("Mode: "+map.get("Mode"));
		System.out.println("Multiplicity: "+map.get("Multiplicity"));
	}
}
