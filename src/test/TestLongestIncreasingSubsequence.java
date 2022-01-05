package test;

import java.util.Arrays;

public class TestLongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Integer.max( dp[i],dp[j]+1);
                }

            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Integer.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("lengthOfLIS(new int[]{}); = " + lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
