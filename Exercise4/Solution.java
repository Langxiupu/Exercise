public class Solution {
    public static void findMajor(int[] array)
    {
        int topOfStack = -1;
        int candidate = 0;

        for(int i = 0; i < array.length; ++i)
        {
            if(topOfStack == -1)
            {
                topOfStack++;
                candidate = array[i];
            }
            else if(array[i] == candidate)
                topOfStack++;
            else
                topOfStack--;
        }

        if(topOfStack == -1)
            System.out.println("No major element");
        else
        {
            int count = 0;
            for(int ele : array)
                if(ele == candidate)
                    count++;

                if(candidate > array.length / 2)
                    System.out.println("The major element of the array is: " + candidate);
                else
                    System.out.println("No major element");
        }
    }
}

