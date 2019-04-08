package com.jzf.code;

public class QuickSort {
    public void sort(int[] sortList) {
        // write your code here
        quick_sort(sortList, 0, sortList.length - 1);
    }

    private void quick_sort(int sortList[], int l, int r) {
        if (l < r) {
            int i, j, x;

            i = l;
            j = r;
            x = sortList[i];
            while (i < j) {
                while (i < j && sortList[j] > x) {
                    j--;
                }
                if (i < j) {
                    sortList[i++] = sortList[j];
                }
                while (i < j && sortList[i] < x) {
                    i++;
                }
                if (i < j) {
                    sortList[j--] = sortList[i];
                }
            }
            sortList[i] = x;
            quick_sort(sortList, l, i - 1);
            quick_sort(sortList, i + 1, r);
        }
    }
}