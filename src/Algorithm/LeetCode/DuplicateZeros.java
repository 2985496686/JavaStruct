package Algorithm.LeetCode;

/*
力扣1089题
思路一：
另创一个数组，将原数组中的数据记录下来，然后通过遍历给原数组赋值就行(这种写法太low)

思路二：双指针
这个题很容易想到双指针，但是在实际操作时会发现，从前往后遍历的时候后面的数据很容易被覆盖掉，所以这个题需要从后往前遍历
若不考虑数组大小，那么数组中每一个数组在复写0之后往后移动的位数就是前面0的个数
 */
public class DuplicateZeros {
    public void duplicateZeros1(int[] arr) {
        int tmp1 = arr[0];
        int tmp2;
        int arr2[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }
        for(int i = 0,j = 0; i < arr.length && j < arr.length; i++){
            if(arr2[i] == 0 && j < arr.length-1){
                arr[j] = 0;
                arr[j+1] = 0;
                j = j+2;
            }
            else{
                arr[j] = arr2[i];
                ++j;
            }
        }
    }
    public void duplicateZeros2(int[] arr) {
        int n = arr.length;
        int cnt0 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                cnt0++;
            }
        }
        System.out.println(cnt0);
        for(int i = n - 1; i >= 0; i--){
            if(arr[i]  == 0) cnt0--;
            if(i + cnt0 < n){
                arr[i + cnt0] = arr[i];
            }
            if(arr[i] == 0 && i + cnt0 + 1 < n){
                arr[i + cnt0 + 1] = 0;
                if(i + cnt0 + 1 < n){}
            }
        }
    }





}
