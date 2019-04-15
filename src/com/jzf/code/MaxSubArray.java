package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/4/15 14:19
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // write your code here
        int  localMax=nums[0];
        int  grobalMax=nums[0];
        for(int i=1;i<nums.length;i++){
            localMax=Math.max(localMax+nums[i],nums[i]);
            grobalMax=Math.max(localMax,grobalMax);
        }
        return grobalMax;
    }
}
