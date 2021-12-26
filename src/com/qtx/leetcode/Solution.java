package com.qtx.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author: QTX
 * @Date: 2021/12/22
 */
public class Solution {
    /**
     * 数组重复与否
     *
     * @param nums 目标数组
     *
     * @return 是否重复
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void containsDuplicateTest() {
        int[] ints = {5, 5, 99, 4, 7, 1};
        int[] ints1 = {1, 2, 3};
        System.out.println(containsDuplicate(ints));
        System.out.println(containsDuplicate(ints1));
    }

    /**
     * 连续最大和
     *
     * @param nums 目标数组
     *
     * @return 求和结果
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], temp = 0;
        for (int num : nums) {
            if (temp < 0 && num > temp) {
                temp = 0;
            }
            temp += num;
            if (temp >= max) {
                max = temp;
            }
        }
        return max;
    }

    @Test
    public void maxSubArrayTest() {
        int[] ints = {-1, 0, -2};
        System.out.println(maxSubArray(ints));
    }

    /**
     * 俩数之和
     *
     * @param nums   数组
     * @param target 目标值
     *
     * @return 俩数位置
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }

    /**
     * 俩数之和
     *
     * @param nums   数组
     * @param target 目标值
     *
     * @return 俩数位置
     */
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(temp, i);
        }
        return null;
    }

    @Test
    public void twoSumTest() {
        int[] ints = {5, 5, 99, 4, 7, 1};
        int[] twoSum = twoSum(ints, 8);
        System.out.println(Arrays.toString(twoSum));
    }

    /**
     * 合并两个有序数组,利用jdk现有方法(俩数组有效内容长度和为m)
     *
     * @param nums1 数组1
     * @param m     截取长度
     * @param nums2 数组2
     * @param n     截取长度
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 合并两个有序数组,双指针
     *
     * @param nums1 数组1
     * @param m     截取长度
     * @param nums2 数组2
     * @param n     截取长度
     */
    public int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] ints = new int[m];
        System.arraycopy(nums1, 0, ints, 0, m);

        int x = 0, y = 0, z = 0;
        while ((x < m) && (y < n)) {
            if (ints[x] < nums2[y]) {
                nums1[z++] = ints[x++];
            } else {
                nums1[z++] = nums2[y++];
            }
        }
        if (x < m) {
            System.arraycopy(ints, x, nums1, x + y, m + n - x - y);
        }
        if (y < n) {
            System.arraycopy(nums2, y, nums1, x + y, m + n - x - y);
        }
        return nums1;
    }

    @Test
    public void mergeTest() {
        int[] ints = {1, 2, 3, 0, 0, 0};
        int[] ints1 = {2, 5, 6};
        //System.out.println(Arrays.toString(merge(ints, 3, ints1, 4)));
        System.out.println(Arrays.toString(merge1(ints, 3, ints1, 3)));
    }

    @Test
    public void arrayTest() {
        int[] ints = new int[5];
        System.out.println(ints.length);
    }

    /**
     * 两个数组的交集,
     *
     * @param nums1 数组1
     * @param nums2 数组2
     *
     * @return 交集数组集合
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int length = (int) Math.ceil(nums1.length > nums2.length ? nums1.length / 0.75 : nums2.length / 0.75);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i : nums1) {
            Integer num = map.getOrDefault(i, 0) + 1;
            map.put(i, num);
        }
        for (int i : nums2) {
            Integer integer = map.get(i);
            if (integer != null && integer != 0) {
                list.add(i);
                map.put(i, integer - 1);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    /**
     * 官方答案
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    @Test
    public void intersectTest() {
        int[] num1 = {1, 2, 2, 3};
        int[] num2 = {1, 2, 2, 4};
        System.out.println(Arrays.toString(intersect(num1, num2)));
        System.out.println(Arrays.toString(intersect1(num1, num2)));

    }
}
