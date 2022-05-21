package Algorithm;

import java.util.Scanner;

public class sort {
    public static void quickSort(int arr[], int l, int r){
        if(l >= r) return;
        int key = arr[l], i = l - 1, j = r + 1;
        while(i < j){
            do ++i; while(arr[i] < key);
            do --j; while(arr[j] > key);
            if(i < j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quickSort(arr,l,j);
        quickSort(arr,j + 1, r);
    }

    public static void mergeSort(int arr[], int l, int r){
        if(l >= r) return;
        int tmp[] = new int[1000];
        int mid = (l + r) / 2 ;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r );
        int i = l , j = mid + 1, k = 0;
        while(i <= mid && j <= r){
            if(arr[i] < arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while(i <= mid) tmp[k++] = arr[i++];
        while(j <= mid) tmp[k++] = arr[j++];
        k = 0;
        for(i = l; i <= r; i++ ){
            arr[i] = tmp[k++];
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int arr[] = new int[N + 1];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        //quickSort(arr, 0, N - 1);
        mergeSort(arr,0,N-1);
        for(int i = 0; i < N; i++) System.out.print(arr[i] + " ");
    }
}
