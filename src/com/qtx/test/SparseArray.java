package com.qtx.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** @Author: QTX @Date: 2021/11/23 */
public class SparseArray {

	public static void main(String[] args) throws IOException {
		int[][] ints = new int[10][10];
		for (int[] anInt : ints) {
			Arrays.fill(anInt, 0);
		}
		printArrays(ints);
		File file = new File("map.txt");
		file.createNewFile();
		saveArray("map.txt", ints);
		int[][] readArray = readArray("map.txt");
		System.out.println(Arrays.deepToString(readArray));
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

	/**
	 * 保存稀疏数组到本地
	 *
	 * @param path  路径
	 * @param array 数组
	 */
	public static void saveArray(String path, int[][] array) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for (int[] ints : array) {
			for (int i : ints) {
				try {
					//踩坑writer.write(int i);,jdk提供的默认方法可以传递int类型,源码实际是把int强制转化成了char,这样会导致没有对应的ASCII的数字就会乱码
					//解决办法:把数字转换成string或者自己提前转换成char测试
					writer.write(Integer.toString(i));
					writer.write(",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			writer.newLine();
		}
		writer.flush();
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取文件生成稀疏数组
	 *
	 * @param path 文件路径
	 */
	public static int[][] readArray(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String s;
		int x = 0;
		Map<Integer, String[]> map = new HashMap<>(15);
		while ((s = reader.readLine()) != null) {
			String[] split = s.split(",");
			map.put(x, split);
			x++;
		}
		System.out.println(x + "--" + map.size());
		int[][] ints = new int[map.size()][x];
		for (Map.Entry<Integer, String[]> m : map.entrySet()) {
			int i = 0;
			for (String s1 : m.getValue()) {
				ints[m.getKey()][i++] = Integer.parseInt(s1);
			}
		}
		return ints;
	}
}
