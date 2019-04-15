package com.jzf.code;

public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;

        for(int i = 0; i<nums.length; i++){
            dp[i] =1;
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i]=dp[i]<dp[j]+1?dp[j]+1:dp[i];
                }

            }
            if(dp[i]>max){
                max = dp[i];
            }

        }
        return max;
    }
}
