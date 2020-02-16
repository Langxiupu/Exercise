class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for(int i = len / 2 - 1; i >= 0; --i)
            nums = percDown(nums, i, len);

        for(int i = 0; i < k - 1; ++i)
            nums = findMin(nums, len - i);
        return nums[0];
    }

    private int[] percDown(int[] a, int i, int len)
    {
        int tmp;
        int child;

        for(tmp = a[i]; leftChild(i) < len; i = child)
        {
            child = leftChild(i);
            if (child < len - 1 && a[child] < a[child + 1])
                child++;
            if(tmp < a[child])
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;

        return a;
    }

    private int leftChild(int x)
    {
        return 2 * x + 1;
    }

    private int[] findMin(int[] a, int len)
    {
        a[0] = a[len - 1];
        a = percDown(a, 0, len - 1);

        return a;
    }
}
