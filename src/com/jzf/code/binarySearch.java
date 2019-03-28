package com.jzf.code;

public class binarySearch {
    public static void main(String[] args) {
        int []num={2,6,8,13,15,17,17,18,19,20};
        int i = binarySearch(num, 15);
        System.out.println(i);
    }

    public static int binarySearch(int[] nums, int target) {
        // write your code here
        int len=nums.length;
        if(len==0){
            return -1;
        }

        int head = 0;
        int tail = len - 1;
        int mid=len/2;
        while(head+1<tail){
            if(nums[mid]>=target){
                tail=mid;
            }else{
                head=mid;
            }
            mid=head + (tail - head)/2;

        }
        if(nums[head]==target){
            return head;
        }else if(nums[mid]==target){
            return mid;
        }else if(nums[tail]==target){
            return tail;
        }
        return -1;
    }
}
