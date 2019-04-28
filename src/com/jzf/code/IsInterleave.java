package com.jzf.code;

/**
 * Created by JINZONGFAN on 2019/4/26 16:03
 */
public class IsInterleave {
    public static void main(String[] args) {
        IsInterleave isInterleave=new IsInterleave();
        boolean result = isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(result);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int length3 = s3.length();
        int length2 = s2.length();
        int length1 = s1.length();
        char[] char3 = s3.toCharArray();
        char[] char2 = s2.toCharArray();
        char[] char1 = s1.toCharArray();
        boolean result=true;
        int i=0,j=0,k=0,o=0,l=0,m=0;
        while (i+j<length3){
            if(i<length1&&j<length2&&char1[i]==char2[j]&&m<=k){
                o=i;
                l=j;
                m++;
            }
            if(k%2==0){
                //这个点可能会出错

                if(i<length1&&char3[i+j]==char1[i]){
                    i++;
                    continue;
                }
                if(j<length2&&char3[i+j]==char2[j]){
                    j++;
                    continue;
                }
                k++;
                i=o;
                j=l;

            }else{
                if(j<length2&&char3[i+j]==char2[j]){
                    j++;
                    continue;
                }
                if(i<length1&&char3[i+j]==char1[i]){
                    i++;
                    continue;
                }
                k++;
                i=o;
                j=l;
            }





        }
        return true;
    }
}
