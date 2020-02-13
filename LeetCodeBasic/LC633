class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = 0, j = (int)Math.sqrt(c); i <= j;)
        {
            double sum = Math.pow(i, 2) + Math.pow(j, 2);
            if(sum == c)
                return true;
            else if(sum > c)
                j--;
            else
                i++;
        }
        return false;
    }
}
