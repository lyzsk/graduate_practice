import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/26
 **/
public class Solution {
    public int minPairSum(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }
}
