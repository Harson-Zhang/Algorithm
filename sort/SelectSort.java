<<<<<<< HEAD
package sort;

import java.util.Random;

public class SelectSort {
	public static final int LENGTH = 100; // 数组长度为100

	public static void selectSort(int[] A) {
		int min_i; // 一轮迭代下来最小数的下标
		for (int i = 0; i < A.length - 1; i++) {
			min_i = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[min_i])
					min_i = j;
			}
			swap(A, i, min_i);
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = new int[LENGTH];
		Random r = new Random(10); // 定义随机数类，种子设为10

		System.out.println("原始数组为：");
		for (int i = 0; i < LENGTH; i++) {
			array[i] = r.nextInt(100); // 整数取值1 - 100
			System.out.print(array[i] + " ");
		}
		System.out.println();

		long startTime = System.nanoTime(); // 获取开始时间
		selectSort(array);
		long endTime = System.nanoTime(); // 获取结束时间

		System.out.println("排序后数组为：");
		for (int ele : array)
			System.out.print(ele + " ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}
}
=======
package sort;

import java.util.Random;

public class SelectSort {
	public static final int LENGTH = 100; // 数组长度为100

	public static void selectSort(int[] A) {
		int min_i; // 一轮迭代下来最小数的下标
		for (int i = 0; i < A.length - 1; i++) {
			min_i = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[min_i])
					min_i = j;
			}
			swap(A, i, min_i);
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = new int[LENGTH];
		Random r = new Random(10); // 定义随机数类，种子设为10

		System.out.println("原始数组为：");
		for (int i = 0; i < LENGTH; i++) {
			array[i] = r.nextInt(100); // 整数取值1 - 100
			System.out.print(array[i] + " ");
		}
		System.out.println();

		long startTime = System.nanoTime(); // 获取开始时间
		selectSort(array);
		long endTime = System.nanoTime(); // 获取结束时间

		System.out.println("排序后数组为：");
		for (int ele : array)
			System.out.print(ele + " ");
		System.out.println();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}
}
>>>>>>> 7248ac3bb0d8b5ce7fa13c3c58b826ffd72d4513
