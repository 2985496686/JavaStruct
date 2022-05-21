package Algorithm.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTest02 {
    //二分查找
    //将所有等于findVal的元素下标以集合的形式返回
    public static void binarySearch(int arr[], int left , int right, int findVal, ArrayList list){
        if(left > right) return;
        int mid = (left + right) / 2;
        if(findVal == arr[mid]){
            list.add(mid);
            binarySearch(arr, left, mid - 1, findVal, list);
            binarySearch(arr, mid + 1,right, findVal, list);
        }
        else if(arr[mid] > findVal) binarySearch(arr, left, mid - 1, findVal,list);
        else binarySearch(arr, mid + 1, right, findVal,list);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = input.nextInt();
        int findVal = input.nextInt();
        ArrayList list = new ArrayList();
        binarySearch(arr,0, n - 1,findVal,list);
        for(Object index:list){
            System.out.print(index + " ");
        }
    }
}
