package ics202;

import java.util.NoSuchElementException;


public class BinaryHeap2 extends AbstractContainer implements PriorityQueue2
{

    protected Comparable array[];

    public BinaryHeap2(int i) {
        array = new Comparable[i + 1];
    }

    public BinaryHeap2(Comparable[] comparable)
    {
        this(comparable.length);

        for(int i = 0; i < comparable.length; i++)
            array[i + 1] = comparable[i];

        count = comparable.length;

        buildHeapBottomUp();
    }

    private void buildHeapBottomUp()
    {

        for(int i = count / 2; i >= 1; i--) {

            percolateDown(i);
            System.out.println(i);
        }
    }


    private void percolateDown(int hole)
    {

        int maxChildIndex;
        Comparable temp = array[hole];
        while(hole * 2 <= count)
        {
            maxChildIndex = hole * 2;
            if(maxChildIndex + 1 <= count && array[maxChildIndex + 1].compareTo(array[maxChildIndex])>0)
                maxChildIndex++;
            if(array[maxChildIndex].compareTo(temp)>0)
                array[hole] = array[maxChildIndex];
            else
                break;

            hole = maxChildIndex;
        }

        array[hole] = temp;
    }

    private void percolateUp(int hole){
        System.out.println(1);
        Comparable comparable = array[hole];
        while(hole > 1 && array[hole / 2].compareTo(comparable)<0)
        {
            array[hole] = array[hole / 2];
            hole = hole / 2 ;
        }

        array[hole] = comparable;
    }


    public void purge()
    {
        while(count > 0)
            array[count--] = null;
    }

    public void enqueue(Comparable comparable)
    {
        if(isFull())
            throw new ContainerFullException();

        int hole = ++count;

        // percolate up via a hole
        while(hole > 1 && array[hole / 2].compareTo(comparable)<0)
        {
            array[hole] = array[hole / 2];
            hole = hole / 2 ;
        }

        array[hole] = comparable;
    }

    public Comparable findMax()
    {
        if(isEmpty())
            throw new ContainerEmptyException();
        else
            return array[1];
    }

    public Comparable dequeueMax()
    {
        if(isEmpty())
            throw new ContainerEmptyException();
        Comparable maxItem = array[1];
        array[1] = array[count];
        count--;
        percolateDown(1);
        return maxItem;
    }


    public boolean isFull()
    {
        return count == array.length - 1;
    }

    public Iterator iterator()
    {
        return new Iterator()
        {
            protected int pos = 1;

            public boolean hasNext()
            {
                return pos <= count;
            }

            public Object next()
            {
                if(pos > count)
                    throw new NoSuchElementException();
                else
                    return array[pos++];
            }
        };
    }

    public String toString(){
        if(isEmpty())
            return "{ }";

        String s = "{ ";
        for(int k = 1; k <= count; k++)
            s = s + "  " + array[k];
        return s +"}";

    }
}