package Algorithm.LeetCode;

/**
 * 力扣：69题
 * 算法思想：二分查找
 * 思路：
 * 从 1到x范围内采用二分查找，查找符合条件的数，数据较大，要定义成long型
 */
public class SqrtX {
    class Solution {
        public int mySqrt(int x) {
            long l = 0, r = x;
            long x1 = x;
            while(l <= r){
                long mid = (l + r) >> 1;
                if(mid*mid == x1 || mid*mid < x && (mid + 1)*(mid + 1) > x1) return (int)mid;
                else if((mid*mid) > x1) r = mid - 1;
                else l = mid + 1;
            }
            return -1;
        }
    }
}
