import java.util.*;

class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] rslt = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i)
        {
            int diff = target - nums[i];
            if(map.get(diff) != null)
            {
                rslt[0] = map.get(diff);
                rslt[1] = i;
                return rslt;
            }
            map.put(nums[i], i);
        }
        return rslt;
    }
}
