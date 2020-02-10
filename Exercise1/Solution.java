public class Solution {
    public static int ones(int n)
    {
        if (n < 2)
            return n;

        return n % 2 + ones(n / 2);
    }
}


