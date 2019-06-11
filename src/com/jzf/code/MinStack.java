package com.jzf.code;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();

    public MinStack() {
        // do intialization if necessary

    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.empty()||minStack.peek()>=number){
            minStack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        //比较最小值和要移除的值
        if(stack.peek()<=minStack.peek()){
            minStack.pop();
        }
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}