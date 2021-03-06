package Algorithm.LeetCode;

/**
 * 力扣35题
 * 算法：二分查找
 */
public class SearchInsterPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while(l <= r){
                int mid = (l + r) >> 1;
                if(nums[mid] == target){
                    return mid;
                }
                else if(nums[mid] > target){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
