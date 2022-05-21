package Algorithm.Search;

import java.util.ArrayList;
import java.util.Scanner;

/*
插值查找更适用于数据量大，且分布较为均匀的数据中查找
与二分查找的区别就是mid的选取，它会根据比例关系，估测处mid的大概位置
int mid = left + (right - left)* (findVal - arr[left]) / (arr[right] - arr[left]);
注意一：当查找序列中元素全部相同时，会出现分母为0的情况，需要进行特殊处理

注意二：求mid时，可能出现 mid > right 或 mid < left 的情况，需要特殊处理
 */
public class InsertValueSearch {
    public static void insertValueSearch(int[] arr, int left, int right, int findVal, ArrayList list){
        if(left > right) return;
        if(arr[left] == arr[right]){
            if(arr[left] != findVal) return;
            else
                for(int i = left; i <= right; i++){
                    list.add(i);
                }
                return;
        }
        int mid = left + (right - left)* (findVal - arr[left]) / (arr[right] - arr[left]);
        if(mid > right || mid < left) return;
        if(arr[mid] == findVal){
            list.add(mid);
            insertValueSearch(arr,left,mid - 1, findVal, list);
            insertValueSearch(arr, mid + 1, right ,findVal,list);
        }
        else if(arr[mid] > findVal) insertValueSearch(arr,left,mid - 1, findVal, list);
        else insertValueSearch(arr, mid + 1, right ,findVal,list);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = input.nextInt();
        int findVal = input.nextInt();
        ArrayList list = new ArrayList();
        insertValueSearch(arr, 0, n - 1, findVal, list);
        for(Object index:list){
            System.out.print(index + " ");
        }
    }
}
