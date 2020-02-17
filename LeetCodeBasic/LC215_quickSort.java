class Solution
{
    public int findKthLargest(int[] nums, int k)
    {
        quickSelect(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSelect(int[] a, int k, int left, int right)
    {
        if(right - left + 1 >= CUTOFF)
        {
            int pivot = median(a, left, right);
            int i = left, j = right - 1;

            for(; ;)
            {
                while(a[++i] > pivot) {}
                while(a[--j] < pivot) {}

                if(i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            swapReferences(a, i, right - 1);

            if(k <= i)
                quickSelect(a, k, left, i - 1);
            else if (k > i + 1)
                quickSelect(a, k, i + 1, right);
        }
        else
        {
         for(int i = left + 1; i <= right; ++i)
         {
             int j;
             int tmp = a[i];
             for(j = i; j > left && tmp > a[j - 1]; --j)
                 a[j] = a[j - 1];
             a[j] = tmp;
         }
        }
    }

    private int median(int[] a, int left, int right)
    {
        int center = (left + right) / 2;

        if(a[left] < a[center])
            swapReferences(a, left, center);
        if(a[left] < a[right])
            swapReferences(a, left, right);
        if(a[center] < a[right])
            swapReferences(a, center, right);

        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private void swapReferences(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private final int CUTOFF = 10;
}
