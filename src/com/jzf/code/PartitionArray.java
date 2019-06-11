package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/5/31 15:04
 */
public class PartitionArray {
    public static void main(String[] args) {
        int[] nums={4,3,1};
        partitionArray(nums,2);
    }

    public  static  int partitionArray(int[] nums, int k) {
        // write your code here
        int[] newArray=new int[nums.length];
        int i=0,j=nums.length-1;
        int index=0;
        int h=0;
        while(i<=j){
            if(nums[h]<k){
                newArray[i]=nums[h];
                i++;
            }else{
                newArray[j]=nums[h];
                j--;
            }
            h++;
        }
        if(i==nums.length-1){
            return nums.length;
        }
        return Math.max(i,j);
    }
}
