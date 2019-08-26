package dev.onroad.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-07 00:16
 * @description 俩数之和,最优解
 */
public class TwoNumSum {

    private static int[] sum(int[] arr, int target) {
        //字典表  O(n) 时间复杂度 空间复杂度O(n)
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (dict.get(target - arr[i]) != null) {
                return new int[]{dict.get(target - arr[i]), i};
            }
            dict.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6};
        int target = 3;
        for (int i : sum(arr, target)) {
            System.out.println(i);
        }
    }
}
