package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/5/8 10:16
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] a={1};
        int[] b={1};
        int[] c=mergeSortedArray(a,b);
        System.out.println(c);
    }

    public static int[] mergeSortedArray(int[] a, int[] b) {
        // write your code here
        int[] big=a;
        int[] small=b;

        int c[]=new int[big.length+small.length];
        int i=0,j=0;
        while (i<big.length&&j<small.length){

            if(big[i]<small[j]){
                c[i+j]=big[i];
                i++;
            }else{
                c[i+j]=small[j];
                j++;
            }

            if(i>=big.length||j>=small.length) {
                if(i>=big.length){
                    while (j<small.length){
                        c[i+j]=small[j];
                        j++;
                    }
                    break;
                }else{
                    while (i<big.length){
                        c[i+j]=big[i];
                        i++;
                    }

                    break;
                }
            }
        }

        return  c;
    }
}
