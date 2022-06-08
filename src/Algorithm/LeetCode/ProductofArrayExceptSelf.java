package Algorithm.LeetCode;
//力扣：238. 除自身以外数组的乘积

/*
思路前缀和。我们可以分别计算nums数组中每一个数字左侧的积与右侧的积，左侧的积从左开始计算，右侧的积从右开始计算
 最后 answer[i] = left[i] * right[i]
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf1(int[] nums) {
        int[]left = new int[nums.length];
        int[]right = new int[nums.length];
        //左侧数字的和
        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i-1]*left[i-1];
        }
        //右侧数字的和
        right[nums.length - 1] = 1;
        for(int i = nums.length-2; i >=0; i--){
            right[i] = right[i + 1]*nums[i+1];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = left[i]*right[i];
        }
        return nums;

    }

    //空间优化
    //与前一种方法区别不大，就是在计算右侧数字的积时直接在left数组上进行操作。
    public int[] productExceptSelf2(int[] nums) {
        int[]left = new int[nums.length];
        //左侧数字的和
        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i-1]*left[i-1];
        }
        int right = 1;
        for(int i = nums.length - 1; i>=0; i--){
            left[i] *= right;
            right *= nums[i];
        }
        return left;
    }
}
