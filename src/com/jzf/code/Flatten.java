package com.jzf.code;


import com.jzf.definition.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    List<Integer> flattenList = new ArrayList<>();

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        if (nestedList.isEmpty()) {
            return new ArrayList<>();
        }
        for (NestedInteger nestedInteger : nestedList) {
            //是否一个一个数字
            if (nestedInteger.isInteger()) {
                flattenList.add(nestedInteger.getInteger());
            }else {
                flatten(nestedInteger.getList());
            }
        }
        return flattenList;
    }
}
