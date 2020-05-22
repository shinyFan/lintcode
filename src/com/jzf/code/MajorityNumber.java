package com.jzf.code;

import java.util.Arrays;
import java.util.List;

public class MajorityNumber {
    public static void main(String[] args) {
        MajorityNumber majorityNumber = new MajorityNumber();
        int i = majorityNumber.majorityNumber(Arrays.asList(2, 1,2,1, 2));
        System.out.println(i);
    }
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int count=0;
        Integer target=null;
        for(Integer num:nums){
            if(num==target){
                count++;
            }else {
                count--;
            }
            if (count<0){
                target = num;
                count=1;
            }
        }
        return target;
    }
}
