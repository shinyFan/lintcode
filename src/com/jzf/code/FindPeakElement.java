package com.jzf.code;

public class FindPeakElement {
    public static void main(String[] args) {

    }



    public int findPeakElement(int[] nums){
        int length = nums.length;
        if(length==0){
            return 0;
        }
        int left=0;
        int right=length-1;
        int mid;
        while(left<right){
            mid=left+((right-left)>>1);
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
