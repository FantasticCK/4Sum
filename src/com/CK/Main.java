package com.CK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] nums = {-2, -1,-1, 0, 0, 2};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {-1,2,2,-5,0,-1,4};
        int[] nums = {-2, 0, 0, 3, 3, -1};
        int target = 5;
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, target));
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for (int forth = 0; forth <= n - 4; forth++) {
            int threeSumTarget = target - nums[forth];
            for (int third = forth + 1; third <= n - 3; third++) {
                int twoSumTarget = threeSumTarget - nums[third];
                int left = third + 1, right = n - 1;
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == twoSumTarget) {
                        res.add(ListHelper(nums[forth], nums[third], nums[left], nums[right]));
                        left++;
                        while (left < n - 1 && nums[left] == nums[left - 1]) left++;
                        right--;
                    } else {
                        if (twoSum < twoSumTarget) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
                while (nums[third] == nums[third + 1] && third < n - 3) third++;
            }
            while (nums[forth] == nums[forth + 1] && forth < n - 4) forth++;
        }
        return res;
    }

    private List<Integer> ListHelper(int a, int b, int c, int d) {
        List<Integer> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        return res;
    }
}
