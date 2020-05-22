package com.jzf.code;

import java.util.ArrayList;
import java.util.List;

public class RecoverRotatedSortedArray {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);

        new RecoverRotatedSortedArray().recoverRotatedSortedArray(list);
    }
    public  void recoverRotatedSortedArray(List<Integer> nums) {
        if(nums == null || nums.size() == 0)  return;
        int i = findRotatedIndex(nums);
        if(i == -1) return;
        swap(nums, 0, i);
        swap(nums, i+1, nums.size()-1);
        swap(nums, 0, nums.size()-1);
    }


    public int findRotatedIndex(List<Integer> nums) {
        for(int i=0; i<nums.size(); i++) {
            if(i+1<nums.size() && nums.get(i) > nums.get(i+1)){
                return i;
            }
        }
        return -1;
    }

    public void swap(List<Integer> nums, int start, int end) {
        while(start<end) {
            Integer temp = nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

}
