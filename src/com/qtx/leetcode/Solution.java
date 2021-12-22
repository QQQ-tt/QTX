package com.qtx.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
}
