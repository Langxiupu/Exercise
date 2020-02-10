public class OrderedCollection<T extends Comparable<? super T>>
{
    public OrderedCollection()
    {
        this(DEFAULT_SIZE);
    }

    public OrderedCollection(int size)
    {
       array = (T[]) new Comparable[size];
       currentSize = 0;
    }

    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    public void makeEmpty()
    {
        array = (T[]) new Comparable[array.length];
        currentSize = 0;
    }

    public boolean insert(T x)
    {
        return insert(currentSize++, x);
    }

    public boolean insert(int idx, T x)
    {
        if (currentSize == array.length)
            return false;

        int i = currentSize;
        for (; i > idx; --i)
            array[i] = array[i - 1];
        array[i] = x;
        return true;
    }

    public boolean remove(int idx)
    {
        if(idx >= currentSize)
            return false;

        for(int i = idx; i < currentSize - 1; ++i)
            array[i] = array[i + 1];
        currentSize--;
        return true;
    }

    //remove all the x in the array
    public boolean remove(T x)
    {
        for(int i = 0; i < currentSize; ++i)
            if(array[i].equals(x))
            {
                int offset = 1;
                for(int j = i; j + offset < currentSize; j++)
                {
                    int next = i + offset;
                    while(next < currentSize
                            && array[next].compareTo(x) == 0)
                    {
                        offset++;
                        next++;
                    }
                    array[j] = array[next];
                }
                currentSize -= offset;
                return true;
            }

        return false;
    }

    public  T findMin()
    {
        if (currentSize == 0)
            return null;

        T minItem = array[0];
        for (int i = 1; i < currentSize; ++i)
            if (array[i].compareTo(minItem) < 0)
                minItem = array[i];
        return minItem;
    }

    public T findMax()
    {
        if(currentSize == 0)
            return null;

        T maxItem = array[0];
        for(int i = 1; i < currentSize; ++i)
            if(array[i].compareTo(maxItem) > 0)
                maxItem = array[i];
        return maxItem;
    }

    public boolean contains(T x)
    {
        for(int i = 0; i < currentSize; ++i)
            if(array[i].compareTo(x) == 0)
                return true;

        return false;
    }

    public void printArray()
    {
        if(currentSize == 0)
            System.out.println("Empty array!");
        else
        {
            for(int i = 0; i < currentSize; ++i)
                System.out.print(array[i] + " ");
        }
    }

    private static final int DEFAULT_SIZE = 10;
    private T[] array;
    private int currentSize;
}

