package Algorithm.LeetCode;

/**
 * 力扣：240题
 *
 *方法一：
 * 二分查找每一行和每一列。
 *
 * 方法二：
 * 因为从一个元素开始，从左到右，从上到下都是递增的，无法定位具体位置
 * 但是，如果我们从左下角元素或者右上角元素开始，从下到上递减，从左到右递增，就可以锁定具体位置了
 */
public class SearchA2DMatrix2 {
    class Solution1 {
        public boolean binarySearch(int[] arr, int target){
            int l = 0, r = arr.length - 1;
            while(l <= r){
                int mid = (l + r) >> 1;
                if(arr[mid] == target) return true;
                else if(arr[mid] > target) r = mid - 1;
                else l = mid + 1;
            }
            return false;
        }
        public boolean searchMatrix(int[][] matrix, int target) {
            for(int i = 0; i < matrix.length; i++){
                if(binarySearch(matrix[i], target)) return true;
            }
            return false;
        }
    }

    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int i = matrix.length - 1, j = 0;
            while(i >= 0 && j < matrix[0].length){
                if(matrix[i][j] == target) return true;
                else if(matrix[i][j] > target) --i;
                else ++j;
            }
            return false;
        }
    }
}
