package Algorithm.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTest01 {
    //二分查找 ---- 递归式
    //不足：当数组中有多个值等于findVal时，直到找到其中一个
    public static int binarySearch1(int arr[], int left, int right, int findVal){
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if(arr[mid] == findVal) return mid;
        else if(arr[mid] > findVal) return binarySearch1(arr, left, mid - 1, findVal);
        else return binarySearch1(arr,mid + 1, right,findVal);
    }
    //非递归
    public static int binarySearch2(int arr[], int size, int findVal){
        int right = size - 1, left = 0, mid = 0;
        while(right >= left){
           mid = (right + left) >> 1;
           if(arr[mid] == findVal) return mid;
           else if(arr[mid] > findVal) right = mid - 1;
           else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = input.nextInt();
        int findVal = input.nextInt();
        //int index = binarySearch1(arr,0, n - 1, findVal);
        int index = binarySearch2(arr,n,findVal);
        if(index == -1){
            System.out.println("找不到！");
            return;
        }
        System.out.println("被查询数下标为：" + index);
    }
}
