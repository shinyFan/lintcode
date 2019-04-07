package com.jzf.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityNumber {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        MajorityNumber mn=new MajorityNumber();


        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        int i = mn.majorityNumber(list);
        System.out.println(i);

    }

    public int majorityNumber(List<Integer> nums) {
        // write your code here
       int _size=(nums.size()+1)>>1;
       int target=0;

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(Integer key : nums){
            if(map.get(key)==null){
                map.put(key,1);
            }else{
                Integer val=map.get(key);
                val++;
                map.put(key,val);
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>=_size){
                return entry.getKey();
            }
        }
        return target;
    }
}
