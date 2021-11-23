package com.qtx.test;

import java.util.Arrays;

/** @Author: QTX @Date: 2021/11/23 */
public class SparseArray {

	public static void main(String[] args) {
		int[][] ints = new int[10][10];
		for (int[] anInt : ints) {
			Arrays.fill(anInt, 0);
		}
		printArrays(ints);
	}

	/**
	 * 展示数组
	 *
	 * @param array 数组
	 */
	public static void printArrays(int[][] array) {
		for (int[] ints : array) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 数组转化成稀疏数组
	 *
	 * @param array 被转化数组
	 */
	public static int[][] setSparseArray(int[][] array) {
		int num = 0;
		for (int[] ints : array) {
			for (int i : ints) {
				if (i != 0) {
					num++;
				}
			}
		}
		int[][] sparseArr = new int[num + 1][3];
		int x = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					sparseArr[x][0] = i;
					sparseArr[x][1] = j;
					sparseArr[x][2] = array[i][j];
					x++;
				}
			}
		}
		sparseArr[0][0] = array.length;
		sparseArr[0][1] = array[0].length;
		sparseArr[0][2] = num;
		return sparseArr;
	}

	/**
	 * 稀疏数组转化成数组
	 *
	 * @param array 被转化数组
	 */
	public static int[][] setArray(int[][] array) {
		int a = array[0][0];
		int b = array[0][1];
		int[][] ints = new int[a][b];
		for (int[] anInt : ints) {
			Arrays.fill(anInt, 0);
		}
		for (int[] value : array) {
			ints[value[0]][value[1]] = value[2];
		}
		return ints;
	}

	public static void saveArray(String path, int[][] array) {
		
	}
}
