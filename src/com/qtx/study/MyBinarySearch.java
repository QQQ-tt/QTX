package com.qtx.study;

/**
 * @author qtx
 */
public class MyBinarySearch {
	public static void main(String[] args)
	{
		System.out.println("Hello World!");

		int[] arr = {1,5,9,15,20,78};
		new RecursiveBinarySearch(arr,1);
		new NoRecursiveBinarySearch(arr,1);
		new BinarySearch(arr,1);

		int x = 2,y = 5;
		System.out.println("num: " + x*6/y); //2
		System.out.println("num: " + x/y*6); //0
	}
}

class RecursiveBinarySearch {
	private int[] array;

	public RecursiveBinarySearch(int[] arr,int target){
		array = arr;
		System.out.println(searchRecursion(target));
	}

	public int searchRecursion(int target){
		if (array != null){
		    return searchRecursion(target,0,array.length - 1);
		}
		return -1;
	}

	public int searchRecursion(int target,int start,int end){
		if (start > end) {
			return -1;
		}
		//int mid = (start + end)/2 no,no,no
		int mid = start + (end - start)/2;
		if (array[mid] == target){
			return mid;
		}
		if (array[mid] > target) {
			return searchRecursion(target,start,mid - 1);
		}else {
			return searchRecursion(target,mid + 1,end);
		}
	}
}

class NoRecursiveBinarySearch{
	private int[] array;

	private int num = 0;

	public NoRecursiveBinarySearch(int[] arr,int target){
		array = arr;
		System.out.println("subscript:" + search(target) + ",num:" + num);
	}

	public int search(int target){
		if (array == null) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		while(end >= start){
			num++;
			int mid = start + (end - start)/2;
			if (array[mid] == target) {
				return mid;
			}else if (array[mid] > target) {
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return -1;
	}
}

/**
 * adaptive mid
 */
class BinarySearch{
	private int[] array;

	private int num = 0;

	public BinarySearch(int[] arr,int target){
		array = arr;
		System.out.println("subscript:" + search(target) + ",num:" + num);
	}

	public int search(int target){
		if (array == null) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		while(end >= start){
			num++;
			//The essential
			int mid = start + (target - array[start]) * (end - start) / (array[end] - array[start]);
			if (array[mid] == target) {
				return mid;
			}else if (array[mid] > target) {
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return -1;
	}
}
