public class Solution {
    public static int ones(int n)
    {
        if (n == 1)
            return 1;

        return n % 2 == 0 ? ones(n/2) : 1 + ones(n / 2);
    }
}


