package com.jzf.code;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class FindFirstBadVersion {

    public static void main(String[] args) {
        FindFirstBadVersion ffbv=new FindFirstBadVersion();
        int n=31;
        int bad=ffbv.findFirstBadVersion(n);
        System.out.println(bad);
    }

    public int findFirstBadVersion(int n) {
        int fi=1;
        int fo=n;
        int k;

        while(fi<fo){
            k = fi + ((fo - fi) >> 1);
            if(!SVNRepo.isBadVersion(k)){
                fi=k+1;
            }else{
                fo=k;
            }
        }
        return fi;
    }
}
