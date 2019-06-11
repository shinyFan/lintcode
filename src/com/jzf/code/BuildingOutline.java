package com.jzf.code;

import java.util.ArrayList;
import java.util.List;

public class BuildingOutline {
    public static void main(String[] args) {
        int[][]  buildings={
                                {1,3,3,},
                                {2,4,4},
                                {5,6,1}
                             };
        BuildingOutline buildingOutline=new BuildingOutline();
        buildingOutline.buildingOutline(buildings);
    }

    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        List<List<Integer>> result=new ArrayList<>();
        int i=0,j=0;
        int col=buildings.length;
        int start=0,end=0,high=0;
        for(i=0;i<col;i++){
            start=start<buildings[i][0]?start:buildings[i][0];
            end=end>buildings[i][1]?end:buildings[i][1];
            high=high>buildings[i][2]?high:buildings[i][2];
        }
        int[][] temp=new int[high][end];
        for (int[] a:buildings){
            for(int k=a[0];k<a[1];k++){
                for(int l=0;l<a[2];l++){
                    temp[l][k]=1;
                }
            }
        }
        for(int q=0;q<high;q++){
            for(int p=0;p<end;p++){
                System.out.print(temp[q][p]);
            }
            System.out.println();
        }

        for(int q=0;q<high;q++){
            for(int p=0;p<end;p++){
                if(temp[0][p]==0){
                    break;
                }
                List<Integer> list=new ArrayList<>();
                if(temp[q][p]==1){
                    list.add(q);
                }else{
                    list.add(p);
                }
                System.out.print(temp[q][p]);
            }
            System.out.println();
        }
        return result;
    }
}
