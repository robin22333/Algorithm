package com.xujc.algorithm;

public class Sort {
	
	/**
	 * 直接选择排序，复杂度O(n2)，不是稳定的排序算法
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		int k;
		for (int i=0; i<arr.length; i++) {
			k = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j] < arr[k]) {
					k = j;
				}
			}
			
			if (k != i) {
				swap(arr, i, k);
			}
		}
	}
	
	/**
	 * 冒泡排序，复杂度O(n2)，是稳定的排序算法
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		int len = arr.length - 1;
		for (int i=len; i>=1; i--) {
			for (int j=0; j<i; j++) {
				if (arr[j+1] < arr[j]) {
					swap(arr, j+1, j);
				}
			}
		}
	}
	
	/**
	 * 插入排序，复杂度O(n2)，是稳定的排序算法
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		
		for (int i=1; i<arr.length; i++) {
			int inserval = arr[i];
			int index = i-1;
			while(index >= 0 && inserval < arr[index]) {
				arr[index + 1] = arr[index];
				index --;
			}
			
			arr[index + 1] = inserval;
		}
		
	}
	
	/**
	 * 希尔排序，复杂度上界O(n3/2)，不是稳定的排序算法
	 * @param arr
	 * @param n
	 */
	public static void shellSort(int[] arr, int n) {
		int d = n / 2;
		while (d >= 1) {
			for (int i=d; i<n; i++) {
				int inserval = arr[i];
				int index = i - d;
				while(index >= 0 && inserval < arr[index]) {
					arr[index + d] = arr[index];
					index -= d;
				}
				
				arr[index + d] = inserval;
			}
			
			d = d / 2;
		}
	}
	
	/**
	 * 快速排序，平均复杂度O(nlgn)，最坏O(n2)，不是稳定的排序算法
	 * @param arr
	 * @param n
	 */
	public static void quitSort(int[] arr, int p, int q) {
		if (p >= q) {
			return;
		}
		int x = arr[p];
		int i = p;
		for (int j=p; j<=q; j++) {
			if (arr[j] < x) {
				i ++;
				swap(arr, i, j);
			}
		}
		swap(arr, i, p);
		quitSort(arr, p, i-1);
		quitSort(arr, i+1, q);
	}
	
	/**
	 * 归并排序，复杂度O(nlgn)，是稳定的排序算法
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] mergeSort(int[] arr, int n) {
		if (n == 1) {
			return arr;
		}
		int mid = n / 2;
		int[] arr1 = new int[mid];
		int[] arr2 = new int[n - mid];
		for (int i=0; i<mid; i++) {
			arr1[i] = arr[i];
		}
		
		for (int i=0; i<(n-mid); i++) {
			arr2[i] = arr[i + mid];
		}
		
		return merge(mergeSort(arr1, arr1.length), mergeSort(arr2, arr2.length));
	}
	
	/**
	 * 数组归并
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length + arr2.length;
		int[] outarr = new int[n];
		int index1 = 0;
		int index2 = 0;
		for (int i=0; i<n; i++) {
			if (index1 == arr1.length) {
				outarr[i] = arr2[index2];
				index2 ++;
			} else if (index2 == arr2.length) {
				outarr[i] = arr1[index1];
				index1 ++;
			} else if (arr1[index1] < arr2[index2]) {
				outarr[i] = arr1[index1];
				index1 ++;
			} else {
				outarr[i] = arr2[index2];
				index2 ++;
			}
		}
		
		
		return outarr;
	}
	
	/**
	 * 堆排序，复杂度O(nlgn)，不是稳定的排序算法
	 * @param arr
	 * @param size
	 */
	public static void heapSort(int[] arr, int size) {
		buildHeap(arr, size);
		
		for (int i=size; i>=0; i--) {
			swap(arr, 0, i);
			heapAdjust(arr, 0, i-1);
		}
	}
	
	/**
	 * 初始堆
	 * @param arr
	 * @param size
	 */
	private static void buildHeap(int[] arr, int size) {
		for (int i=size/2; i>=0; i--) {
			heapAdjust(arr, i, size);
		}
	}
	
	/**
	 * 调整堆
	 * @param arr
	 * @param i
	 * @param size
	 */
	private static void heapAdjust(int[] arr, int i, int size) {
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		int maxValue = i;
		
		if (i <= size / 2) {
			if (leftChild <= size && arr[leftChild] > arr[maxValue]) {
				maxValue = leftChild;
			}
			if (rightChild <= size && arr[rightChild] > arr[maxValue]) {
				maxValue = rightChild;
			}
			
			if (maxValue != i) {
				swap(arr, i, maxValue);
				heapAdjust(arr, maxValue, size);
			}
		}
	}
	
	/**
	 * 计数排序，复杂度O(n+k)，当k不是非常大时，复杂度是线性的，快于比较类的排序算法，是稳定的排序算法
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] countSort(int[] arr, int k) {
		int[] c = new int[k+1];
		int[] b = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			c[arr[i]] ++;
		}
		
		for (int i=1; i<k+1; i++) {
			c[i] = c[i] + c[i-1];
		}
		
		for (int i=arr.length-1; i>=0; i--) {
			c[arr[i]] --;
			b[c[arr[i]]] = arr[i];
		}
		return b;
	}
	
	/**
	 * 交换在数组元素
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
