package com.jzf.code;

public class FindPosition {
    public int findPosition(int[] nums, int target) {
        int len=nums.length;
        if(len==0){
            return -1;
        }

        int head = 0;
        int tail = len - 1;
        int mid=len/2;
        while(head<=tail){
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                tail=mid-1;
            }else{
                head=mid+1;
            }
            mid=head + (tail - head)/2;
        }
        return -1;

    }
}
