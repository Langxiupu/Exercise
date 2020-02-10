import java.util.*;
public class Solution {
    public static void replacement(int N)
    {
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = i + 1;

        for(int i = 0; i < N; ++i)
        {
            int index = randInt(0, i);
            int tmp = a[index];
            a[index] = a[i];
            a[i] = tmp;
        }

        System.out.println(Arrays.toString(a));
    }

    private static int randInt(int i, int j)
    {
        Random r = new Random();
        return r.nextInt(j - i + 1) + i;
    }
}


